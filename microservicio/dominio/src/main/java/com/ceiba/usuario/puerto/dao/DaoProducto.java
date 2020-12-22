package com.ceiba.usuario.puerto.dao;

import com.ceiba.usuario.modelo.dto.DtoProducto;

import java.util.List;

public interface DaoProducto {

    /**
     * Permite listar productos
     * @return los productos
     */
    List<DtoProducto> listar();

    DtoProducto buscar(String nombre);

    DtoProducto buscarPorId(Long id);
}
