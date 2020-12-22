package com.ceiba.usuario.servicio.producto;

import com.ceiba.dominio.excepcion.ExcepcionObjectoNoEncontrado;
import com.ceiba.usuario.modelo.entidad.Producto;
import com.ceiba.usuario.puerto.repositorio.RepositorioProducto;

public class ServicioCrearProducto {

    private static final String PRODUCTO_ENCONTRADO = "El producto ya existe";

    private final RepositorioProducto repositorioProducto;

    public ServicioCrearProducto(RepositorioProducto repositorioProducto) {
        this.repositorioProducto = repositorioProducto;
    }

    public Long ejecutar(Producto producto) {
        validarExistencia(producto.getNombre());
        return repositorioProducto.crear(producto);
    }

    private void validarExistencia(String nombre) {
        Boolean existe = repositorioProducto.existe(nombre);
        if (existe) {
            throw new ExcepcionObjectoNoEncontrado(PRODUCTO_ENCONTRADO);
        }
    }
}
