package com.ceiba.usuario.puerto.dao;

import com.ceiba.usuario.modelo.dto.DtoInventario;
import com.ceiba.usuario.modelo.entidad.Inventario;

import java.util.List;

public interface DaoInventario {

    /**
     * Permite listar inventario
     *
     * @return los inventarios
     */
    List<DtoInventario> listar();

    DtoInventario buscarPorIdProducto(Long idProdcuto);

    DtoInventario buscarPorId(Long id);

}
