package com.ceiba.pedido.servicio.testDataBuilder;

import com.ceiba.usuario.modelo.entidad.Pedido;

public class PedidoTestDataBuilder {

    private Long id;
    private Long usuario;
    private Integer cantidad;
    private Long producto;
    private Double precioTotal;


    public PedidoTestDataBuilder() {
        this.usuario = 1l;
        this.cantidad = 1;
        this.producto = 1l;
    }

    public PedidoTestDataBuilder conPrecio() {
        precioTotal = 200d;
        return this;
    }

    public PedidoTestDataBuilder conUsuario(Long idUsuario) {
        usuario = idUsuario;
        return this;
    }

    public PedidoTestDataBuilder conProducto(Long idProducto) {
        producto = idProducto;
        return this;
    }

    public PedidoTestDataBuilder conCantidad(Integer cantidad) {
        this.cantidad = cantidad;
        return this;
    }

    public PedidoTestDataBuilder conId(Long id) {
        this.id = id;
        return this;
    }

    public Pedido build() {
        return new Pedido(id, usuario, cantidad, producto);
    }
}
