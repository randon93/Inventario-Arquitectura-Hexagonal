package com.ceiba.inventario.adaptadores.dao;

import com.ceiba.infraestructura.excepcion.ExcepcionTecnica;
import com.ceiba.infraestructura.jdbc.CustomNamedParameterJdbcTemplate;
import com.ceiba.infraestructura.jdbc.sqlstatement.SqlStatement;
import com.ceiba.usuario.modelo.dto.DtoInventario;
import com.ceiba.usuario.puerto.dao.DaoInventario;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class DaoInventarioMysql implements DaoInventario {

    private final static String NO_SE_ENCONTRO_EL_PRODUCTO = "NO SE ENCONTRO EL PRODUCTO CON EL  ";

    private final CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate;

    @SqlStatement(namespace = "inventario", value = "buscarPorIdProducto")
    private static String sqlBuscarPorIdProducto;

    @SqlStatement(namespace = "inventario", value = "buscarPorId")
    private static String sqlBuscarPorId;

    @SqlStatement(namespace = "inventario", value = "listar")
    private static String sqListar;

    public DaoInventarioMysql(CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate) {
        this.customNamedParameterJdbcTemplate = customNamedParameterJdbcTemplate;
    }

    @Override
    public List<DtoInventario> listar() {
        return this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().query(sqListar, new MapeoInventario());
    }

    @Override
    public DtoInventario buscarPorIdProducto(Long idProdcuto) {
        Map<String, Object> parametros = new HashMap<>();
        parametros.put("id", idProdcuto);
        DtoInventario dto = null;
        try {
            dto = this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().queryForObject(sqlBuscarPorIdProducto, parametros, new MapeoInventario());
        } catch (EmptyResultDataAccessException e) {
            throw new ExcepcionTecnica(NO_SE_ENCONTRO_EL_PRODUCTO.concat("ID DE PRODUCTO: " + idProdcuto));
        }
        return dto;
    }

    @Override
    public DtoInventario buscarPorId(Long id) {
        Map<String, Object> parametros = new HashMap<>();
        parametros.put("id", id);
        DtoInventario dto = null;
        try {
            dto = this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().queryForObject(sqlBuscarPorId, parametros, new MapeoInventario());
        }catch (EmptyResultDataAccessException e) {
            throw new ExcepcionTecnica(NO_SE_ENCONTRO_EL_PRODUCTO.concat("ID: " + id));
        }
        return dto;
    }
}
