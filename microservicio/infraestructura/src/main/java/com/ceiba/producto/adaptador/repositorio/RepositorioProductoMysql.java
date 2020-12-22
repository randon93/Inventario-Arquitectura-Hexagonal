package com.ceiba.producto.adaptador.repositorio;

import com.ceiba.infraestructura.jdbc.CustomNamedParameterJdbcTemplate;
import com.ceiba.infraestructura.jdbc.sqlstatement.SqlStatement;
import com.ceiba.usuario.modelo.entidad.Producto;
import com.ceiba.usuario.puerto.repositorio.RepositorioProducto;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.stereotype.Repository;

@Repository
public class RepositorioProductoMysql implements RepositorioProducto {

    private final CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate;

    @SqlStatement(namespace="producto", value="crear")
    private static String sqlCrear;

    @SqlStatement(namespace="producto", value="actualizar")
    private static String sqlActualizar;

    @SqlStatement(namespace="producto", value="existeNombre")
    private static String sqlExisteNombre;

    @SqlStatement(namespace="producto", value="existeId")
    private static String sqlExisteId;

    @SqlStatement(namespace="producto", value="productoConStock")
    private static String sqlConStock;

    @SqlStatement(namespace="producto", value="eliminar")
    private static String sqlEliminar;


    public RepositorioProductoMysql(CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate) {
        this.customNamedParameterJdbcTemplate = customNamedParameterJdbcTemplate;
    }

    @Override
    public Long crear(Producto producto) {
        return this.customNamedParameterJdbcTemplate.crear(producto, sqlCrear);
    }

    @Override
    public void actualizar(Producto producto) {
        this.customNamedParameterJdbcTemplate.actualizar(producto, sqlActualizar);
    }

    @Override
    public void eliminar(Long id) {
        MapSqlParameterSource parameterSource = new MapSqlParameterSource();
        parameterSource.addValue("id", id);
        this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().update(sqlEliminar, parameterSource);
    }

    @Override
    public boolean existe(String nombre) {
        MapSqlParameterSource paramSource = new MapSqlParameterSource();
        paramSource.addValue("nombre", nombre);
        return this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().queryForObject(sqlExisteNombre,paramSource, Boolean.class);
    }

    @Override
    public boolean existe(Long id) {
        MapSqlParameterSource paramSource = new MapSqlParameterSource();
        paramSource.addValue("id", id);
        return this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().queryForObject(sqlExisteId,paramSource, Boolean.class);
    }

    @Override
    public boolean existeExcluyendoId(Long id, String nombre) {
        return false;
    }

    @Override
    public boolean tieneStock(Long id) {
        MapSqlParameterSource paramSource = new MapSqlParameterSource();
        paramSource.addValue("id", id);
        return this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().queryForObject(sqlConStock,paramSource, Boolean.class);
    }
}
