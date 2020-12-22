package com.ceiba.usuario.consulta.pedido;

import com.ceiba.usuario.modelo.dto.DtoPedido;
import com.ceiba.usuario.puerto.dao.DaoPedido;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ManejadorListarPedido {

    private final DaoPedido daoPedido;

    public ManejadorListarPedido(DaoPedido daoPedido) {
        this.daoPedido = daoPedido;
    }

    public List<DtoPedido> ejecutar() {
        return daoPedido.listar();
    }
}
