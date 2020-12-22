package com.ceiba.inventario.adaptadores.dao;

import com.ceiba.infraestructura.jdbc.CustomNamedParameterJdbcTemplate;
import com.ceiba.infraestructura.jdbc.sqlstatement.SqlStatement;
import com.ceiba.usuario.comando.fabrica.inventario.FabricaInventario;
import com.ceiba.usuario.modelo.dto.DtoInventario;
import com.ceiba.usuario.modelo.entidad.Inventario;
import com.ceiba.usuario.puerto.dao.DaoInventario;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class DaoInventarioMysql implements DaoInventario {

    private final CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate;
    private final FabricaInventario fabricaInventario;

    @SqlStatement(namespace = "inventario", value = "buscarPorId")
    private static String sqlBuscar;

    @SqlStatement(namespace = "inventario", value = "listar")
    private static String sqListar;

    public DaoInventarioMysql(CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate, FabricaInventario fabricaInventario) {
        this.customNamedParameterJdbcTemplate = customNamedParameterJdbcTemplate;
        this.fabricaInventario = fabricaInventario;
    }

    @Override
    public List<DtoInventario> listar() {
        return this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().query(sqListar, new MapeoInventario());
    }

    @Override
    public Inventario buscarPorIdProducto(Long idProdcuto) {
        Map<String, Object> parametros = new HashMap<>();
        parametros.put("id", idProdcuto);
        DtoInventario dto = null;
        dto = this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().queryForObject(sqlBuscar, parametros, new MapeoInventario());
        return fabricaInventario.crear(dto);

    }
}
