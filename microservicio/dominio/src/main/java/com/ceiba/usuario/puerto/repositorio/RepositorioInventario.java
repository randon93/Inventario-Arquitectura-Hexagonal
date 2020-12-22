package com.ceiba.usuario.puerto.repositorio;

import com.ceiba.usuario.modelo.entidad.Inventario;

public interface RepositorioInventario {


    /**
     * Permite crear un producto
     *
     * @param inventario
     * @return el id generado
     */
    Long crear(Inventario inventario);

    /**
     * Permite actualizar un producto
     *
     * @param inventario
     */
    void actualizar(Inventario inventario);

    /**
     * Permite eliminar un producto
     *
     * @param id
     */
    void eliminar(Long id);

    /**
     * Permite validar si existe un producto con un nombre
     *
     * @param id
     * @return si existe o no
     */
    boolean existe(Long id);

    /**
     * Permite validar si existe un producto con un nombre excluyendo un id
     *
     * @param nombre
     * @return si existe o no
     */
    boolean existeExcluyendoId(Long id, String nombre);

    boolean agegarEjemplarProducto(Long idProducto, Integer cantidad);
}
