package com.ceiba.pedido.adaptador.dao;

import com.ceiba.infraestructura.jdbc.CustomNamedParameterJdbcTemplate;
import com.ceiba.infraestructura.jdbc.sqlstatement.SqlStatement;
import com.ceiba.usuario.adaptador.dao.MapeoUsuario;
import com.ceiba.usuario.modelo.dto.DtoFactura;
import com.ceiba.usuario.modelo.dto.DtoPedido;
import com.ceiba.usuario.puerto.dao.DaoPedido;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class DaoPedidoMysql implements DaoPedido {

    private final CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate;

    @SqlStatement(value = "listar", namespace = "pedido")
    private static String sqlListar;

    @SqlStatement(value = "buscarPorId", namespace = "pedido")
    private static String sqlBuscarId;

    public DaoPedidoMysql(CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate) {
        this.customNamedParameterJdbcTemplate = customNamedParameterJdbcTemplate;
    }

    @Override
    public List<DtoPedido> listar() {
        return this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().query(sqlListar, new MapeoPedido());
    }

    @Override
    public DtoPedido buscarPorId(Long idProducto) {
        Map<String,Object> parametros = new HashMap<>();
        parametros.put("id", idProducto);
        return this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().queryForObject(sqlBuscarId, parametros, new MapeoPedido());
    }
}
