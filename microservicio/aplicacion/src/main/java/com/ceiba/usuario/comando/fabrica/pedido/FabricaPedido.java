package com.ceiba.usuario.comando.fabrica.pedido;

import com.ceiba.usuario.comando.ComandoPedido;
import com.ceiba.usuario.modelo.dto.DtoPedido;
import com.ceiba.usuario.modelo.entidad.Pedido;
import org.springframework.stereotype.Component;

@Component
public class FabricaPedido {

    public Pedido crear(ComandoPedido comandoPedido) {
        return new Pedido(
                comandoPedido.getId(),
                comandoPedido.getUsuario(),
                comandoPedido.getCantidad(),
                comandoPedido.getProducto()
        );
    }

}
