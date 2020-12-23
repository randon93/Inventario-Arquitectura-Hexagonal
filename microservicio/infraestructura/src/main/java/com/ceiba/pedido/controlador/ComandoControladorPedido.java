package com.ceiba.pedido.controlador;

import com.ceiba.usuario.comando.ComandoPedido;
import com.ceiba.usuario.comando.manejador.pedido.ManejadorCrearPedido;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/pedido")
@Api(tags = { "Controlador comando pedido"})
public class ComandoControladorPedido {

    private final ManejadorCrearPedido manejadorCrearPedido;

    public ComandoControladorPedido(ManejadorCrearPedido manejadorCrearPedido) {
        this.manejadorCrearPedido = manejadorCrearPedido;
    }

    @PostMapping("/save")
    @ApiOperation("Crea una solicitud de producto")
    public Double crear(@RequestBody ComandoPedido comandoPedido) {
        return manejadorCrearPedido.ejecutar(comandoPedido);
    }
}
