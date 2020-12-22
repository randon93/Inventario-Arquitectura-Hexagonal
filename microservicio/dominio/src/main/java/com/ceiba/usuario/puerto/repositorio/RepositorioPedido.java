package com.ceiba.usuario.puerto.repositorio;

import com.ceiba.usuario.modelo.entidad.Pedido;

public interface RepositorioPedido {

    Long crear(Pedido pedido);

    void eliminar(Long id);

    void actualizar(Pedido pedido);

    boolean existe(Long usuario, Long producto);
}
