package com.ceiba.inventario.controlador;

import com.ceiba.usuario.comando.ComandoInventario;
import com.ceiba.usuario.comando.manejador.inventario.ManejadorActualizarInventario;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/inventario")
@Api(tags = {"Controlador comando Inventario"})
public class ComandoControladorInventario {

    private final ManejadorActualizarInventario manejadorPedidoInventario;

    public ComandoControladorInventario(ManejadorActualizarInventario manejadorPedidoInventario) {
        this.manejadorPedidoInventario = manejadorPedidoInventario;
    }

    @PutMapping("/actualizar")
    @ApiOperation("Actualiza el stock del inventario de un producto")
    public void actualizar(@RequestBody ComandoInventario inventario) {
        manejadorPedidoInventario.ejecutar(inventario);
    }
}
