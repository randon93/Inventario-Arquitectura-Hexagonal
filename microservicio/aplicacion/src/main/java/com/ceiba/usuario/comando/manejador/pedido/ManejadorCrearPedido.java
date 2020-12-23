package com.ceiba.usuario.comando.manejador.pedido;

import com.ceiba.usuario.comando.ComandoPedido;
import com.ceiba.usuario.comando.fabrica.pedido.FabricaPedido;
import com.ceiba.usuario.modelo.entidad.Pedido;
import com.ceiba.usuario.servicio.inventario.ServicioRealizarPedidoEnInventario;
import com.ceiba.usuario.servicio.pedido.ServicioCalcularPrecioTotal;
import com.ceiba.usuario.servicio.pedido.ServicioCrearPedido;
import org.springframework.stereotype.Component;

@Component
public class ManejadorCrearPedido {

    private final FabricaPedido fabricaPedido;
    private final ServicioCrearPedido servicioCrearPedido;
    private final ServicioRealizarPedidoEnInventario servicioRealizarPedidoEnInventario;
    private final ServicioCalcularPrecioTotal servicioCalcularPrecioTotal;

    public ManejadorCrearPedido(FabricaPedido fabricaPedido,
                                ServicioCrearPedido servicioCrearPedido,
                                ServicioRealizarPedidoEnInventario servicioRealizarPedidoEnInventario,
                                ServicioCalcularPrecioTotal servicioCalcularPrecioTotal) {
        this.fabricaPedido = fabricaPedido;
        this.servicioCrearPedido = servicioCrearPedido;
        this.servicioRealizarPedidoEnInventario = servicioRealizarPedidoEnInventario;
        this.servicioCalcularPrecioTotal = servicioCalcularPrecioTotal;
    }

    public Double ejecutar(ComandoPedido comandoPedido) {
        Pedido pedido = fabricaPedido.crear(comandoPedido);
        servicioRealizarPedidoEnInventario.ejecutar(pedido.getProducto(), pedido.getCantidad());
        Long idPedido = servicioCrearPedido.ejecutar(pedido);
        comandoPedido.setId(idPedido);
        pedido = fabricaPedido.crear(comandoPedido);
        return servicioCalcularPrecioTotal.ejecutar(pedido);
    }
}
