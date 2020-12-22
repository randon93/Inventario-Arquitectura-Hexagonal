package com.ceiba.usuario.consulta.producto;

import com.ceiba.usuario.modelo.dto.DtoProducto;
import com.ceiba.usuario.puerto.dao.DaoProducto;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ManejadorListarProducto {

    private final DaoProducto daoProducto;

    public ManejadorListarProducto(DaoProducto daoProducto) {
        this.daoProducto = daoProducto;
    }

    public List<DtoProducto> ejecutar() {
        return daoProducto.listar();
    }
}
