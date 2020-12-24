package com.ceiba.inventario.adaptadores.dao;

import com.ceiba.infraestructura.jdbc.MapperResult;
import com.ceiba.usuario.modelo.dto.DtoInventario;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;

public class MapeoInventario implements RowMapper<DtoInventario>, MapperResult {

    @Override
    public DtoInventario mapRow(ResultSet resultSet, int rowNum) throws SQLException {

        Long id = resultSet.getLong("id");
        Long producto = resultSet.getLong("producto");
        Integer cantidad = resultSet.getInt("cantidad");
        Boolean recarga = resultSet.getBoolean("recarga_stock");
        LocalDateTime fecha = extraerLocalDateTime(resultSet, "fecha_recarga");
        Boolean bloqueado = resultSet.getBoolean("bloqueado");
        String nombreProducto = "";
        try{
            nombreProducto = resultSet.getNString("nombre_producto");
        }catch (Exception e ) {}
        return new DtoInventario(id, producto, nombreProducto, cantidad, fecha, recarga, bloqueado);
    }

}
