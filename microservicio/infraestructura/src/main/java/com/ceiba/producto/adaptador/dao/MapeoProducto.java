package com.ceiba.producto.adaptador.dao;

import com.ceiba.infraestructura.jdbc.MapperResult;
import com.ceiba.usuario.modelo.dto.DtoProducto;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class MapeoProducto implements RowMapper<DtoProducto>, MapperResult {

    @Override
    public DtoProducto mapRow(ResultSet resultSet, int rowNum) throws SQLException {

        Long id = resultSet.getLong("id");
        String nombre = resultSet.getString("nombre");
        Float precio = resultSet.getFloat("precio");

        return new DtoProducto(id, nombre, precio);
    }

}
