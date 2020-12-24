package com.ceiba.inventario.controlador;

import com.ceiba.usuario.consulta.inventario.ManejadorBucarInventarioPorId;
import com.ceiba.usuario.consulta.inventario.ManejadorBucarInventarioPorProducto;
import com.ceiba.usuario.consulta.inventario.ManejadorListarInventario;
import com.ceiba.usuario.modelo.dto.DtoInventario;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/inventario")
@Api(tags = {"Controlador Consulta Inventario"})
public class ConsultaControladorInventario {

    private final ManejadorListarInventario manejadorListarInventario;
    private final ManejadorBucarInventarioPorId manejadorBuscarInventarioPorId;
    private final ManejadorBucarInventarioPorProducto manejadorBuscarInventarioPorProducto;

    public ConsultaControladorInventario(ManejadorListarInventario manejadorListarInventario, ManejadorBucarInventarioPorId manejadorBuscarInventarioPorId, ManejadorBucarInventarioPorProducto manejadorBuscarInventarioPorProducto) {
        this.manejadorListarInventario = manejadorListarInventario;
        this.manejadorBuscarInventarioPorId = manejadorBuscarInventarioPorId;
        this.manejadorBuscarInventarioPorProducto = manejadorBuscarInventarioPorProducto;
    }

    @GetMapping
    @ApiOperation("Listar Inventario")
    public List<DtoInventario> listar() {
        return manejadorListarInventario.ejecutar();
    }

    @GetMapping("/buscar/{id}")
    @ApiOperation("Busca un inventario en especifico por su ID")
    public DtoInventario buscarPorId(@PathVariable Long id) {
        return manejadorBuscarInventarioPorId.ejecutar(id);
    }

    @GetMapping("/buscar-producto/{id}")
    @ApiOperation("Busca un inventario en especifico por su PRODUCTO")
    public DtoInventario buscarPorProducto(@PathVariable Long id) {
        return manejadorBuscarInventarioPorProducto.ejecutar(id);
    }
}
