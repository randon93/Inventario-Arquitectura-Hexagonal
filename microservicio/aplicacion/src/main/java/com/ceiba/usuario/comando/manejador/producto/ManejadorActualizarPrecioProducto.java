package com.ceiba.usuario.comando.manejador.producto;

import com.ceiba.usuario.comando.ComandoProducto;
import com.ceiba.usuario.comando.fabrica.producto.FabricaProducto;
import com.ceiba.usuario.modelo.entidad.Producto;
import com.ceiba.usuario.servicio.producto.ServicioActualizarProducto;
import org.springframework.stereotype.Component;

@Component
public class ManejadorActualizarPrecioProducto {

    private final ServicioActualizarProducto servicioActualizarProducto;
    private final FabricaProducto fabricaProducto;

    public ManejadorActualizarPrecioProducto(ServicioActualizarProducto servicioActualizarProducto, FabricaProducto fabricaProducto) {
        this.servicioActualizarProducto = servicioActualizarProducto;
        this.fabricaProducto = fabricaProducto;
    }

    public void ejecutar(ComandoProducto comandoProducto) {
        Producto producto = fabricaProducto.crear(comandoProducto);
        servicioActualizarProducto.ejecutar(producto);
    }
}
