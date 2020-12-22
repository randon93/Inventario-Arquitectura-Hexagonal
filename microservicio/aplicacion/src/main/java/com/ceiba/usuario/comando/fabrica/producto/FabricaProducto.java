package com.ceiba.usuario.comando.fabrica.producto;

import com.ceiba.usuario.comando.ComandoProducto;
import com.ceiba.usuario.modelo.dto.DtoProducto;
import com.ceiba.usuario.modelo.entidad.Producto;
import org.springframework.stereotype.Component;

@Component
public class FabricaProducto {

    public Producto crear(ComandoProducto comandoProducto) {
        return new Producto(
                comandoProducto.getId(),
                comandoProducto.getNombre(),
                comandoProducto.getPrecio()
        );
    }

    public Producto crear(DtoProducto dtoProducto) {
        return new Producto(
                dtoProducto.getId(),
                dtoProducto.getNombre(),
                dtoProducto.getPrecio()
        );
    }
}
