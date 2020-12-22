package com.ceiba.usuario.adaptador.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.ceiba.infraestructura.jdbc.CustomNamedParameterJdbcTemplate;
import com.ceiba.infraestructura.jdbc.sqlstatement.SqlStatement;
import com.ceiba.usuario.puerto.dao.DaoUsuario;

import org.springframework.stereotype.Component;

import com.ceiba.usuario.modelo.dto.DtoUsuario;

@Component
public class DaoUsuarioMysql implements DaoUsuario {

    private final CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate;

    @SqlStatement(namespace="usuario", value="listar")
    private static String sqlListar;

    @SqlStatement(namespace="usuario", value="buscar")
    private static String sqlBuscar;

    public DaoUsuarioMysql(CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate) {
        this.customNamedParameterJdbcTemplate = customNamedParameterJdbcTemplate;
    }

    @Override
    public List<DtoUsuario> listar() {
        return this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().query(sqlListar, new MapeoUsuario());
    }

    @Override
    public DtoUsuario buscar(Long id) {
        Map<String,Object> parametros = new HashMap<>();
        parametros.put("id", id);
        return this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().queryForObject(sqlBuscar, parametros, new MapeoUsuario());
    }

}
