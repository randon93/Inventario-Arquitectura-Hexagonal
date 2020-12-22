package com.ceiba.pedido.entidad;

import com.ceiba.pedido.servicio.testDataBuilder.PedidoTestDataBuilder;
import com.ceiba.usuario.modelo.entidad.Pedido;
import org.junit.Assert;
import org.junit.Test;

public class PedidoTest {

    @Test
    public void calcularPrecioTotalSinDescuentos() {
        Pedido pedido = new PedidoTestDataBuilder()
                .conProducto(1l)
                .conCantidad(1)
                .conUsuario(1l)
                .build();
        Double precioTotal = 150.0 * pedido.getCantidad();
        pedido.calcularPrecioTotal(150.0, 7);
        Assert.assertEquals(pedido.getPrecioTotal(), precioTotal, 0);
    }

    @Test
    public void calcularPrecioTotalConDescuentos() {
        Double precioProducto = 150.0;
        Pedido pedido = new PedidoTestDataBuilder()
                .conProducto(1l)
                .conCantidad(1)
                .conUsuario(1l)
                .build();

        Double descuento = (precioProducto * 16) / 100;
        Double precioReal = precioProducto * pedido.getCantidad();
        Double precioRealConDescuento = precioReal - descuento;
        pedido.calcularPrecioTotal(precioProducto, 20);
        Assert.assertEquals(pedido.getPrecioTotal(), precioRealConDescuento, 0);
    }

}
