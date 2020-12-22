package com.ceiba.usuario.servicio.producto;

import com.ceiba.dominio.excepcion.ExcepcionObjectoNoEncontrado;
import com.ceiba.usuario.modelo.entidad.Producto;
import com.ceiba.usuario.puerto.repositorio.RepositorioProducto;

public class ServicioActualizarProducto {

    private static final String PRODUCTO_NO_EXISTE= "EL producto no existe";

    private final RepositorioProducto repositorioProduct;

    public ServicioActualizarProducto(RepositorioProducto repositorioProduct) {
        this.repositorioProduct = repositorioProduct;
    }

    public void ejecutar(Producto producto) {
        vaidarExistenciaPrevia(producto);
        repositorioProduct.actualizar(producto);
    }

    private void vaidarExistenciaPrevia(Producto producto) {
        boolean existe = this.repositorioProduct.existe(producto.getId());
        if (!existe) {
            throw new ExcepcionObjectoNoEncontrado(PRODUCTO_NO_EXISTE);
        }
    }
}
