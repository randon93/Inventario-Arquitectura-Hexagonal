package com.ceiba.inventario.adaptadores.repositorio;

import com.ceiba.infraestructura.jdbc.CustomNamedParameterJdbcTemplate;
import com.ceiba.infraestructura.jdbc.sqlstatement.SqlStatement;
import com.ceiba.usuario.modelo.entidad.Inventario;
import com.ceiba.usuario.puerto.repositorio.RepositorioInventario;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.stereotype.Repository;

@Repository
public class RepositorioInventarioMysql implements RepositorioInventario {

    private final CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate;


    @SqlStatement(namespace="inventario", value="crear")
    private static String sqlCrear;

    @SqlStatement(namespace="inventario", value="actualizar")
    private static String sqlActualizar;

    @SqlStatement(namespace="inventario", value="existe")
    private static String sqlExiste;

    @SqlStatement(namespace="inventario", value="eliminar")
    private static String sqlEliminar;

    public RepositorioInventarioMysql(CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate) {
        this.customNamedParameterJdbcTemplate = customNamedParameterJdbcTemplate;
    }

    @Override
    public Long crear(Inventario inventario) {
        return customNamedParameterJdbcTemplate.crear(inventario, sqlCrear);
    }

    @Override
    public void actualizar(Inventario inventario) {
        this.customNamedParameterJdbcTemplate.actualizar(inventario, sqlActualizar);
    }

    @Override
    public void eliminar(Long id) {
        MapSqlParameterSource paramSource = new MapSqlParameterSource();
        paramSource.addValue("id", id);
        this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().update(sqlEliminar,paramSource);
    }

    @Override
    public boolean existe(Long producto) {
        MapSqlParameterSource paramSource = new MapSqlParameterSource();
        paramSource.addValue("producto", producto);
        return this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().queryForObject(sqlExiste,paramSource, Boolean.class);
    }

    @Override
    public boolean existeExcluyendoId(Long id, String nombre) {
        return false;
    }

    @Override
    public boolean agegarEjemplarProducto(Long idProducto, Integer cantidad) {
        return false;
    }
}
