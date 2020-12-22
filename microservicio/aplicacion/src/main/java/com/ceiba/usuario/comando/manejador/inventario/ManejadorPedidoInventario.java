package com.ceiba.usuario.comando.manejador.inventario;

import com.ceiba.ComandoRespuesta;
import com.ceiba.usuario.comando.ComandoInventario;
import com.ceiba.usuario.comando.fabrica.inventario.FabricaInventario;
import com.ceiba.usuario.modelo.entidad.Inventario;
import com.ceiba.usuario.servicio.inventario.ServicioRealizarPedidoEnInventario;
import org.springframework.stereotype.Component;

@Component
public class ManejadorPedidoInventario {

    private final FabricaInventario fabricaInventario;
    private final ServicioRealizarPedidoEnInventario servicioRealizarPedidoEnInventario;

    public ManejadorPedidoInventario(FabricaInventario fabricaInventario, ServicioRealizarPedidoEnInventario servicioRealizarPedidoEnInventario) {
        this.fabricaInventario = fabricaInventario;
        this.servicioRealizarPedidoEnInventario = servicioRealizarPedidoEnInventario;
    }

    public ComandoRespuesta<Long> ejecutar(ComandoInventario comandoInventario) {
        Inventario inventario = this.fabricaInventario.crear(comandoInventario);
        return new ComandoRespuesta<>(555L);
    }
}
