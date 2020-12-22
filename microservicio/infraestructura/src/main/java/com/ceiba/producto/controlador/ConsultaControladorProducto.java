package com.ceiba.producto.controlador;

import com.ceiba.usuario.consulta.producto.ManejadorListarProducto;
import com.ceiba.usuario.modelo.dto.DtoProducto;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/producto")
@Api(tags = {"Consulta Controlador Producto"})
public class ConsultaControladorProducto {

    private final ManejadorListarProducto manejadorListarProducto;

    public ConsultaControladorProducto(ManejadorListarProducto manejadorListarProducto) {
        this.manejadorListarProducto = manejadorListarProducto;
    }

    @GetMapping
    @ApiOperation("Lista todos los productos registrados")
    public List<DtoProducto> listar(){
        return manejadorListarProducto.ejecutar();
    }
}
