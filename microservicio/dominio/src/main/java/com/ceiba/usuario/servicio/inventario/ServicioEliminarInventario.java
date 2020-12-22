package com.ceiba.usuario.servicio.inventario;

import com.ceiba.usuario.puerto.repositorio.RepositorioInventario;

public class ServicioEliminarInventario {

    private final RepositorioInventario repositorioInventario;
    private final com.ceiba.usuario.puerto.dao.DaoInventario daoInventario;

    public ServicioEliminarInventario(RepositorioInventario repositorioInventario, com.ceiba.usuario.puerto.dao.DaoInventario daoInventario) {
        this.repositorioInventario = repositorioInventario;
        this.daoInventario = daoInventario;
    }

    public void ejecutar(Long inventario) {
        this.repositorioInventario.eliminar(inventario);
    }

}
