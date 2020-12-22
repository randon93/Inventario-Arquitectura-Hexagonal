package com.ceiba.usuario.servicio.producto;

import com.ceiba.dominio.excepcion.ExcepcionConStock;
import com.ceiba.usuario.modelo.entidad.Producto;
import com.ceiba.usuario.puerto.dao.DaoProducto;
import com.ceiba.usuario.puerto.repositorio.RepositorioProducto;

public class ServicioEliminarProducto {

    private static final String TIENE_ESTOCK = "EL producto tiene ejemplares";

    private final RepositorioProducto repositorioProducto;
    private final DaoProducto daoProducto;

    public ServicioEliminarProducto(RepositorioProducto repositorioProducto, DaoProducto daoProducto) {
        this.repositorioProducto = repositorioProducto;
        this.daoProducto = daoProducto;
    }

    public void ejecutar(Producto producto) {
        validarExistencia(producto.getId());
        repositorioProducto.eliminar(producto.getId());
    }

    private void validarExistencia(Long idProducto) {
        boolean tiene = repositorioProducto.tieneStock(idProducto);
        if (tiene) {
            throw new ExcepcionConStock(TIENE_ESTOCK);
        }
    }
}
