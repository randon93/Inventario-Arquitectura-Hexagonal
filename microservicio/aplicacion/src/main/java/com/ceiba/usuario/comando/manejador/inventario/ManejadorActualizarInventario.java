package com.ceiba.usuario.comando.manejador.inventario;

import com.ceiba.usuario.comando.inventario.ComandoActualizarInventario;
import com.ceiba.usuario.comando.inventario.ComandoInventario;
import com.ceiba.usuario.comando.fabrica.inventario.FabricaInventario;
import com.ceiba.usuario.modelo.dto.DtoInventario;
import com.ceiba.usuario.modelo.entidad.Inventario;
import com.ceiba.usuario.puerto.dao.DaoInventario;
import com.ceiba.usuario.servicio.inventario.ServicioActualizarInventario;
import org.springframework.stereotype.Component;

@Component
public class ManejadorActualizarInventario {

    private final ServicioActualizarInventario repositorioInventario;
    private final FabricaInventario fabricaInventario;
    private final DaoInventario daoInventario;

    public ManejadorActualizarInventario(ServicioActualizarInventario repositorioInventario, FabricaInventario fabricaInventario, DaoInventario daoInventario) {
        this.repositorioInventario = repositorioInventario;
        this.fabricaInventario = fabricaInventario;
        this.daoInventario = daoInventario;
    }

    public void ejecutar(ComandoActualizarInventario comandoInventario) {
        DtoInventario dto = daoInventario.buscarPorIdProducto(comandoInventario.getProducto());
        Inventario inventario = fabricaInventario.crear(dto);
        repositorioInventario.ejecutar(inventario, comandoInventario.getCantidad());
    }
}
