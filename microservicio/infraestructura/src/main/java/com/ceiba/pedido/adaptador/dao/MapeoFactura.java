package com.ceiba.pedido.adaptador.dao;

import com.ceiba.infraestructura.jdbc.MapperResult;
import com.ceiba.usuario.modelo.dto.DtoFactura;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class MapeoFactura implements RowMapper<DtoFactura>, MapperResult {

    @Override
    public DtoFactura mapRow(ResultSet rs, int rowNum) throws SQLException {
        Long idPedido = rs.getLong("codigo_pedido");
        Long idUsuario = rs.getLong("codigo_usuario");
        Long idProdcuto = rs.getLong("codigo_producto");
        String nombreProducto = rs.getString("nombre_producto");
        String nombreUsuario = rs.getString("usuario");
        Integer cantidad = rs.getInt("cantidad");
        Double precioUnitario = rs.getDouble("precio_unitario");
        Double precioTotal = rs.getDouble("precio_total");

        return new DtoFactura(
                idPedido,
                idUsuario,
                nombreUsuario,
                idProdcuto,
                nombreProducto,
                cantidad,
                precioUnitario,
                precioTotal
        );
    }
}
