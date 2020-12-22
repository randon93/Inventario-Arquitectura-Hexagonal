package com.ceiba.usuario.servicio.inventario;

import com.ceiba.dominio.excepcion.ExcepcionDuplicidad;
import com.ceiba.usuario.modelo.entidad.Inventario;
import com.ceiba.usuario.puerto.repositorio.RepositorioInventario;
import lombok.extern.slf4j.Slf4j;

import java.time.LocalDateTime;

public class ServicioCrearInventario {

    private static final String PRODUCTO_EXISTENTE_EN_INVENTARIO = "El producto ya existe en el inventario";
    private static final Integer CANTIDAD_DEFAULT = 1;

    private final RepositorioInventario repositorioInventario;

    public ServicioCrearInventario(RepositorioInventario repositorioInventario) {
        this.repositorioInventario = repositorioInventario;
    }

    public void ejecutar(Long producto) {
        validarExistenciaPrevia(producto);
        Inventario inventario = new Inventario(
                0l,
                producto,
                CANTIDAD_DEFAULT,
                true,
                LocalDateTime.now(),
                true);
        this.repositorioInventario.crear(inventario);
    }

    private void validarExistenciaPrevia(Long producto) {
        boolean existe = this.repositorioInventario.existe(producto);
        if (existe) {
            throw new ExcepcionDuplicidad(PRODUCTO_EXISTENTE_EN_INVENTARIO);
        }
    }
}
