package com.ceiba.usuario.consulta.inventario;

import com.ceiba.usuario.modelo.dto.DtoInventario;
import com.ceiba.usuario.puerto.dao.DaoInventario;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ManejadorListarInventario {

    private final DaoInventario daoInventario;

    public ManejadorListarInventario(DaoInventario daoInventario) {
        this.daoInventario = daoInventario;
    }

    public List<DtoInventario> ejecutar() {
        return daoInventario.listar();
    }
}
