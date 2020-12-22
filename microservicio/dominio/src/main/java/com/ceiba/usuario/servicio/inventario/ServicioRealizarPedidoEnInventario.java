package com.ceiba.usuario.servicio.inventario;

import com.ceiba.dominio.Util.Calendar.UtilCalendar;
import com.ceiba.dominio.excepcion.ExcepcionFinDeMes;
import com.ceiba.usuario.modelo.entidad.Inventario;
import com.ceiba.usuario.puerto.dao.DaoInventario;
import com.ceiba.usuario.puerto.repositorio.RepositorioInventario;

import java.time.Clock;
import java.time.LocalDate;
import java.time.LocalDateTime;

public class ServicioRealizarPedidoEnInventario {

    private static final String FIN_MES_TODO_PRODUCTOS_BLOQUADO = "Los ultimos dias del mes todo producto se bloquea";
    private static final Integer ULTIMOS_DIAS = 3;
    private static final Integer CANTIDAD_MINIMA = 2;

    private final RepositorioInventario repositorioInventario;
    private final com.ceiba.usuario.puerto.dao.DaoInventario daoInventario;
    private final Clock fechaActual;

    public ServicioRealizarPedidoEnInventario(RepositorioInventario repositorioInventario, DaoInventario daoInventario, Clock fechaActual) {
        this.repositorioInventario = repositorioInventario;
        this.daoInventario = daoInventario;
        this.fechaActual = fechaActual;
    }

    public void ejecutar(Long producto, Integer pedido) {
        Inventario inventario = validar(producto, pedido);
        this.repositorioInventario.actualizar(inventario);
    }

    private Inventario validar(Long producto, Integer pedido) {
        Inventario inventario = daoInventario.buscarPorIdProducto(producto);
        finDeMes();
        inventario.validarPedido(pedido, CANTIDAD_MINIMA);
        return inventario;
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
