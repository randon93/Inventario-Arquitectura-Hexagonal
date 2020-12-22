package com.ceiba.producto.servicio;

import com.ceiba.usuario.comando.ComandoProducto;

import java.util.UUID;

public class ComandoProductoTestDataBuilder {

    private Long id;
    private String nombre;
    private Float precio;

    public ComandoProductoTestDataBuilder() {
        nombre = "BATMAN";
        precio = 5000f;
        id = 1l;
    }

    public ComandoProducto build() {
        return new ComandoProducto(id, nombre, precio);
    }
}
