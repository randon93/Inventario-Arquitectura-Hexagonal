package com.ceiba.pedido.controlador;

import com.ceiba.usuario.consulta.pedido.ManejadorListarPedido;
import com.ceiba.usuario.modelo.dto.DtoPedido;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/pedido")
@Api(tags = {"Controlador consulta Pedido"})
public class ConsultaControladorPedido {

    private final ManejadorListarPedido manejadorListarPedidos;

    public ConsultaControladorPedido(ManejadorListarPedido manejadorListarPedidos) {
        this.manejadorListarPedidos = manejadorListarPedidos;
    }

    @GetMapping
    @ApiOperation("Permite listar todos los pedidos")
    public List<DtoPedido> listar() {
        return manejadorListarPedidos.ejecutar();
    }
}
