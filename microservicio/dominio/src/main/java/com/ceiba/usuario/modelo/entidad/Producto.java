package com.ceiba.usuario.modelo.entidad;

import com.ceiba.dominio.ValidadorArgumento;
import lombok.Getter;

@Getter
public class Producto {

    private static final String PRODUCTO_SIN_NOMBRE = "EL producto no puede estar sin nombre";
    private static final String PRODUCTO_SIN_PRECIO = "EL producto no puede estar sin precio";
    private static final String PRECIO_DEBE_SER_MAYOR_A_CERO = "Por favor ingrese un precio mayor a CERO (0), Gracias.";

    private Long id;
    private String nombre;
    private Float precio;

    public Producto(Long id, String nombre, Float precio) {
        ValidadorArgumento.validarObligatorio(nombre, PRODUCTO_SIN_NOMBRE);
        ValidadorArgumento.validarPositivo(precio.doubleValue(), PRECIO_DEBE_SER_MAYOR_A_CERO);
        ValidadorArgumento.validarObligatorio(precio, PRODUCTO_SIN_PRECIO);
        this.id = id;
        this.nombre = nombre;
        this.precio = precio;
    }
}
