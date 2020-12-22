package com.ceiba.usuario.comando.manejador.inventario;

import com.ceiba.usuario.comando.ComandoInventario;
import com.ceiba.usuario.comando.fabrica.inventario.FabricaInventario;
import com.ceiba.usuario.modelo.entidad.Inventario;
import com.ceiba.usuario.servicio.inventario.ServicioActualizarInventario;
import org.springframework.stereotype.Component;

@Component
public class ManejadorActualizarInventario {

    private final ServicioActualizarInventario repositorioInventario;
    private final FabricaInventario fabricaInventario;

    public ManejadorActualizarInventario(ServicioActualizarInventario repositorioInventario, FabricaInventario fabricaInventario) {
        this.repositorioInventario = repositorioInventario;
        this.fabricaInventario = fabricaInventario;
    }

    public void ejecutar(ComandoInventario comandoInventario) {
        Inventario inventario = fabricaInventario.crear(comandoInventario);
        repositorioInventario.ejecutar(inventario);
    }
}
