package com.ceiba.producto.adaptador.dao;

import com.ceiba.infraestructura.jdbc.CustomNamedParameterJdbcTemplate;
import com.ceiba.infraestructura.jdbc.sqlstatement.SqlStatement;
import com.ceiba.usuario.adaptador.dao.MapeoUsuario;
import com.ceiba.usuario.modelo.dto.DtoProducto;
import com.ceiba.usuario.puerto.dao.DaoProducto;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class DaoProductoMysql implements DaoProducto {

    private final CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate;

    @SqlStatement(value = "listar", namespace = "producto")
    private static String sqlListar;

    @SqlStatement(value = "buscarId", namespace = "producto")
    private static String sqlBuscaId;

    @SqlStatement(value = "buscarNombre", namespace = "producto")
    private static String sqlBuscaNombre;

    public DaoProductoMysql(CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate) {
        this.customNamedParameterJdbcTemplate = customNamedParameterJdbcTemplate;
    }

    @Override
    public List<DtoProducto> listar() {
        return this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().query(sqlListar, new MapeoProducto());
    }

    @Override
    public DtoProducto buscar(String nombre) {
        Map<String,Object> parametros = new HashMap<>();
        parametros.put("nombre", nombre);
        return this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().queryForObject(sqlBuscaNombre, parametros, new MapeoProducto());
    }

    @Override
    public DtoProducto buscarPorId(Long id) {
        Map<String,Object> parametros = new HashMap<>();
        parametros.put("id", id);
        return this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().queryForObject(sqlBuscaId, parametros, new MapeoProducto());
    }
}
