package com.ceiba.usuario.servicio.inventario;

import com.ceiba.dominio.excepcion.ExcepcionObjectoNoEncontrado;
import com.ceiba.usuario.modelo.entidad.Inventario;
import com.ceiba.usuario.puerto.dao.DaoInventario;
import com.ceiba.usuario.puerto.repositorio.RepositorioInventario;

public class ServicioActualizarInventario {

    private static final String INVENTARIO_NO_ENCONTRADO = "El inventario del producto no se encontro.";

    private final RepositorioInventario repositorioInventario;
    private final DaoInventario daoInventario;

    public ServicioActualizarInventario(RepositorioInventario repositorioInventario, com.ceiba.usuario.puerto.dao.DaoInventario daoInventario) {
        this.repositorioInventario = repositorioInventario;
        this.daoInventario = daoInventario;
    }

    public void ejecutar(Inventario inventario, Integer nuevosJemeplares) {
        validarExistenciaPrevia(inventario.getId());
        inventario.actualizarStock(nuevosJemeplares);
        repositorioInventario.actualizar(inventario);
    }

    private void validarExistenciaPrevia(Long id) {
        Boolean existe = repositorioInventario.existe(id);
        if (!existe) {
            throw new ExcepcionObjectoNoEncontrado(INVENTARIO_NO_ENCONTRADO);
        }
    }

}
