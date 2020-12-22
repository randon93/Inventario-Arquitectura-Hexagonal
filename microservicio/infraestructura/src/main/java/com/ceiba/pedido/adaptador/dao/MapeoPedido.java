package com.ceiba.pedido.adaptador.dao;

import com.ceiba.infraestructura.jdbc.MapperResult;
import com.ceiba.usuario.modelo.dto.DtoPedido;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class MapeoPedido implements RowMapper<DtoPedido>, MapperResult {

    @Override
    public DtoPedido mapRow(ResultSet rs, int rowNum) throws SQLException {
        Long id = rs.getLong("id");
        Long usuario = rs.getLong("usuario");
        Long producto = rs.getLong("producto");
        Double precio = rs.getDouble("precio_total");
        Integer cantidad = rs.getInt("cantidad");
        return new DtoPedido(id, usuario, cantidad, producto, precio);
    }
}
