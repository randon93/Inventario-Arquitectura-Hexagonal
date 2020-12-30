package com.ceiba.usuario.controlador;

import java.util.List;

import com.ceiba.usuario.consulta.usuario.ManejadorBuscarUsuario;
import com.ceiba.usuario.consulta.usuario.ManejadorListarUsuarios;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ceiba.usuario.modelo.dto.DtoUsuario;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/usuarios")
@Api(tags={"Controlador consulta usuario"})
public class ConsultaControladorUsuario {

    private final ManejadorListarUsuarios manejadorListarUsuarios;

    private final ManejadorBuscarUsuario manejadorBuscarUsuario;

    public ConsultaControladorUsuario(ManejadorListarUsuarios manejadorListarUsuarios, ManejadorBuscarUsuario manejadorBuscarUsuario) {
        this.manejadorListarUsuarios = manejadorListarUsuarios;
        this.manejadorBuscarUsuario = manejadorBuscarUsuario;
    }

    @GetMapping
    @ApiOperation("Listar Usuarios")
    public List<DtoUsuario> listar() {
        return this.manejadorListarUsuarios.ejecutar();
    }

    @GetMapping("/{id}")
    @ApiOperation("Bucar Usuario")
    public DtoUsuario buscar(@PathVariable Long id) {
        return this.manejadorBuscarUsuario.ejecutar(id);
    }
}
