package com.ceiba.producto.servcio.testDataBuilder;

import com.ceiba.usuario.modelo.entidad.Producto;

import java.util.UUID;

public class ProductoTestDataBuilder {
    private Long id;
    private String nombre;
    private Float precio;

    public  ProductoTestDataBuilder() {
        nombre = UUID.randomUUID().toString();
        precio = 200F;
    }

    public ProductoTestDataBuilder conId(Long id) {
        this.id = id;
        return this;
    }

    public ProductoTestDataBuilder conPrecio(Float precio) {
        this.precio = precio;
        return this;
    }

    public Producto builder() {
        return new Producto(id, nombre, precio);
    }
}
