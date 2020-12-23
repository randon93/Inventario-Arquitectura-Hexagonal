package com.ceiba.inventario.controlador;

import com.ceiba.usuario.consulta.inventario.ManejadorListarInventario;
import com.ceiba.usuario.modelo.dto.DtoInventario;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/inventario")
@Api(tags = {"Controlador Consulta Inventario"})
public class ConsultaControladorInventario {

    private final ManejadorListarInventario manejadorListarInventario;

    public ConsultaControladorInventario(ManejadorListarInventario manejadorListarInventario) {
        this.manejadorListarInventario = manejadorListarInventario;
    }

    @GetMapping
    @ApiOperation("Listar Inventario")
    public List<DtoInventario> listar() {
        return manejadorListarInventario.ejecutar();
    }
}
