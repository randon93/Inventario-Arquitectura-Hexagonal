package com.ceiba.usuario.comando.manejador.pedido;

import com.ceiba.usuario.comando.ComandoPedido;
import com.ceiba.usuario.comando.fabrica.inventario.FabricaInventario;
import com.ceiba.usuario.comando.fabrica.pedido.FabricaPedido;
import com.ceiba.usuario.modelo.dto.DtoInventario;
import com.ceiba.usuario.modelo.entidad.Inventario;
import com.ceiba.usuario.modelo.entidad.Pedido;
import com.ceiba.usuario.puerto.dao.DaoInventario;
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
    private final DaoInventario daiInventario;
    private final FabricaInventario fabricaInventario;

    public ManejadorCrearPedido(FabricaPedido fabricaPedido,
                                ServicioCrearPedido servicioCrearPedido,
                                ServicioRealizarPedidoEnInventario servicioRealizarPedidoEnInventario,
                                ServicioCalcularPrecioTotal servicioCalcularPrecioTotal, DaoInventario daiInventario, FabricaInventario fabricaInventario) {
        this.fabricaPedido = fabricaPedido;
        this.servicioCrearPedido = servicioCrearPedido;
        this.servicioRealizarPedidoEnInventario = servicioRealizarPedidoEnInventario;
        this.servicioCalcularPrecioTotal = servicioCalcularPrecioTotal;
        this.daiInventario = daiInventario;
        this.fabricaInventario = fabricaInventario;
    }

    public Double ejecutar(ComandoPedido comandoPedido) {
        Pedido pedido = fabricaPedido.crear(comandoPedido);

        DtoInventario dto = daiInventario.buscarPorIdProducto(pedido.getProducto());
        Inventario inventario = fabricaInventario.crear(dto);
        servicioRealizarPedidoEnInventario.ejecutar(inventario, pedido);

        Long idPedido = servicioCrearPedido.ejecutar(pedido);
        comandoPedido.setId(idPedido);
        pedido = fabricaPedido.crear(comandoPedido);
        return servicioCalcularPrecioTotal.ejecutar(pedido);
    }
}
