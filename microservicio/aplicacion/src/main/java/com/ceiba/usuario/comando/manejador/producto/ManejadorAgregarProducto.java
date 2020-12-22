package com.ceiba.usuario.comando.manejador.producto;

import com.ceiba.ComandoRespuesta;
import com.ceiba.usuario.comando.ComandoProducto;
import com.ceiba.usuario.comando.fabrica.producto.FabricaProducto;
import com.ceiba.usuario.modelo.entidad.Producto;
import com.ceiba.usuario.servicio.inventario.ServicioCrearInventario;
import com.ceiba.usuario.servicio.producto.ServicioCrearProducto;
import org.springframework.stereotype.Component;

@Component
public class ManejadorAgregarProducto {

    private final FabricaProducto fabricaProducto;
    private final ServicioCrearProducto servicioCrearProducto;
    private final ServicioCrearInventario servicioCrearInventario;

    public ManejadorAgregarProducto(FabricaProducto fabricaProducto, ServicioCrearProducto servicioCrearProducto, ServicioCrearInventario servicioCrearInventario) {
        this.fabricaProducto = fabricaProducto;
        this.servicioCrearProducto = servicioCrearProducto;
        this.servicioCrearInventario = servicioCrearInventario;
    }

    public ComandoRespuesta<Long> ejecutar(ComandoProducto comandoProducto) {
        Producto producto = fabricaProducto.crear(comandoProducto);
        Long idProducto = servicioCrearProducto.ejecutar(producto);
        servicioCrearInventario.ejecutar(idProducto);
        return new ComandoRespuesta<>(idProducto);
    }

}
