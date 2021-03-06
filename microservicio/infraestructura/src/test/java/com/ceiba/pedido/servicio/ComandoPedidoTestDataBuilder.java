package com.ceiba.pedido.servicio;

import com.ceiba.usuario.comando.ComandoPedido;

public class ComandoPedidoTestDataBuilder {

    private Long id;
    private Long usuario;
    private Integer cantidad;
    private Long producto;
    private Double precioTotal;

    public ComandoPedidoTestDataBuilder() {
        usuario = 1l;
        cantidad = 1;
        producto = 1l;
    }

    public ComandoPedidoTestDataBuilder conId(Long id) {
        this.id = id;
        return this;
    }

    public ComandoPedidoTestDataBuilder conPrecio() {
        this.precioTotal = 200d;
        return this;
    }

    public ComandoPedido build() {
        return new ComandoPedido(id, usuario,cantidad,producto);
    }
}
