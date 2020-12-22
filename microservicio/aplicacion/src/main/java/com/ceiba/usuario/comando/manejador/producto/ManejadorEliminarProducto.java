package com.ceiba.usuario.comando.manejador.producto;

import com.ceiba.usuario.comando.fabrica.producto.FabricaProducto;
import com.ceiba.usuario.modelo.dto.DtoProducto;
import com.ceiba.usuario.puerto.dao.DaoProducto;
import com.ceiba.usuario.servicio.inventario.ServicioEliminarInventario;
import com.ceiba.usuario.servicio.producto.ServicioEliminarProducto;
import org.springframework.stereotype.Component;

@Component
public class ManejadorEliminarProducto {

    private final ServicioEliminarProducto servicioEliminarProducto;
    private final DaoProducto daoProducto;
    private final FabricaProducto fabricaProducto;
    private final ServicioEliminarInventario servicioEliminarInventario;

    public ManejadorEliminarProducto(ServicioEliminarProducto servicioEliminarProducto,
                                     DaoProducto daoProducto,
                                     FabricaProducto fabricaProducto,
                                     ServicioEliminarInventario servicioEliminarInventario) {
        this.servicioEliminarProducto = servicioEliminarProducto;
        this.daoProducto = daoProducto;
        this.fabricaProducto = fabricaProducto;
        this.servicioEliminarInventario = servicioEliminarInventario;
    }

    public void ejecutar(Long id) {
        DtoProducto dto = daoProducto.buscarPorId(id);
        servicioEliminarProducto.ejecutar(
                fabricaProducto.crear(dto)
        );
        servicioEliminarInventario.ejecutar(id);
    }
}
