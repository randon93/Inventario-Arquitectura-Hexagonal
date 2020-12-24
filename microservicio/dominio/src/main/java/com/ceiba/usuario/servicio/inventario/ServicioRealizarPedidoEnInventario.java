package com.ceiba.usuario.servicio.inventario;

import com.ceiba.dominio.Util.Calendar.UtilCalendar;
import com.ceiba.dominio.excepcion.ExcepcionFinDeMes;
import com.ceiba.dominio.excepcion.ExcepcionObjectoNoEncontrado;
import com.ceiba.usuario.modelo.entidad.Inventario;
import com.ceiba.usuario.modelo.entidad.Pedido;
import com.ceiba.usuario.puerto.dao.DaoInventario;
import com.ceiba.usuario.puerto.repositorio.RepositorioInventario;
import com.ceiba.usuario.puerto.repositorio.RepositorioUsuario;

import java.time.Clock;
import java.time.LocalDate;
import java.time.LocalDateTime;

public class ServicioRealizarPedidoEnInventario {

    private static final String FIN_MES_TODO_PRODUCTOS_BLOQUADO = "Los ultimos dias del mes todo producto se bloquea";
    private static final String USUARIO_NO_ENCONTRADO = "Usuario no encontrado";
    private static final Integer ULTIMOS_DIAS = 3;
    private static final Integer CANTIDAD_MINIMA = 2;

    private final RepositorioInventario repositorioInventario;
    private final DaoInventario daoInventario;
    private final RepositorioUsuario repositorioUsuario;
    private final Clock fechaActual;

    public ServicioRealizarPedidoEnInventario(RepositorioInventario repositorioInventario, DaoInventario daoInventario, RepositorioUsuario repositorioUsuario, Clock fechaActual) {
        this.repositorioInventario = repositorioInventario;
        this.daoInventario = daoInventario;
        this.repositorioUsuario = repositorioUsuario;
        this.fechaActual = fechaActual;
    }

    public void ejecutar(Inventario inventario, Pedido pedido) {

        validarPedidoEnInventario(inventario, pedido.getCantidad());
        this.repositorioInventario.actualizar(inventario);
    }

    public void validarUsuario(Long usuarioId) {
        Boolean existe = repositorioUsuario.existePorId(usuarioId);
        if (existe) {
            throw new ExcepcionObjectoNoEncontrado(USUARIO_NO_ENCONTRADO);
        }
    }

    private void validarPedidoEnInventario(Inventario inventario, Integer pedido) {
        finDeMes();
        inventario.validarPedido(pedido, CANTIDAD_MINIMA);
    }

    private void finDeMes() {
        Boolean ultimosDiasDelMes = UtilCalendar.seEncuentraEn(ULTIMOS_DIAS, localDate());
        if (ultimosDiasDelMes) {
            throw new ExcepcionFinDeMes(FIN_MES_TODO_PRODUCTOS_BLOQUADO + "(" + ULTIMOS_DIAS + ")");
        }
    }

    private LocalDate localDate() {
        return LocalDateTime.ofInstant(fechaActual.instant(), fechaActual.getZone()).toLocalDate();
    }

}
