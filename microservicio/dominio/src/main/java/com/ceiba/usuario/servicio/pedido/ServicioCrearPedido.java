package com.ceiba.usuario.servicio.pedido;

import com.ceiba.usuario.modelo.entidad.Pedido;
import com.ceiba.usuario.puerto.repositorio.RepositorioPedido;

public class ServicioCrearPedido {

    private final RepositorioPedido repositorioPedido;

    public ServicioCrearPedido(RepositorioPedido repositorioPedido) {
        this.repositorioPedido = repositorioPedido;
    }

    public void ejecutar(Pedido pedido) {
        repositorioPedido.crear(pedido);
    }
}
