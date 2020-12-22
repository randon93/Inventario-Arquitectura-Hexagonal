package com.ceiba.usuario.modelo.entidad;

import com.ceiba.dominio.ValidadorArgumento;
import com.ceiba.dominio.excepcion.ExcepcionCantidadInsuficiente;
import lombok.Getter;

import static com.ceiba.dominio.ValidadorArgumento.validarPositivo;
import static com.ceiba.dominio.ValidadorArgumento.validarObligatorio;

import java.time.LocalDateTime;

@Getter
public class Inventario {

    private static final String BLOQUEADO_POR_ADMINISTRACION = "No se puede realizar movimientos con este producto.";
    private static final String PRODUCTO_LLEGO_A_SU_STOCK_MINIMO = "Producto no tiene existencia.";
    private static final String PRODUCTO_VACIO = "El inventario debe de tener un producto.";
    private static final String CANTIDAD_VACIO = "Almenos debe de existir 1 ejemplar del producto.";
    private static final String CANTIDAD_NEGATIVA = "Porfavor la cantidad del producto debe de ser positiva.";

    private Long id;
    private Long producto;
    private Integer cantidad;
    private Boolean recargaStock;
    private LocalDateTime fechaRecarga;
    private Boolean bloqueado;

    public Inventario(Long id, Long producto, Integer cantidad, Boolean recargaStock, LocalDateTime fechaRecarga, Boolean bloqueado) {
        validarObligatorio(producto, PRODUCTO_VACIO);
        validarObligatorio(cantidad, CANTIDAD_VACIO);
        validarPositivo(cantidad.doubleValue(), CANTIDAD_NEGATIVA);
        this.id = id;
        this.producto = producto;
        this.cantidad = cantidad;
        this.recargaStock = recargaStock;
        this.fechaRecarga = fechaRecarga;
        this.bloqueado = bloqueado;
    }

    public void validarPedido(int cantidadPedido, int cantMinima) {
        bloqueadoPor();
        Integer nuevaCantidad = this.cantidad - cantidadPedido;
        ValidadorArgumento.validarPositivo(
                nuevaCantidad.doubleValue(),
                "No se tiene la cantidad solicitada, ( se cuenta con: " + this.cantidad + " unidades)."
        );
        if (nuevaCantidad <= cantMinima && nuevaCantidad >= 1) {
            this.bloqueado = true;
            this.recargaStock = true;
        }
        if (nuevaCantidad <= 5) {
            this.recargaStock = true;
        }
        this.cantidad = nuevaCantidad;
    }

    private void bloqueadoPor() {
        if (this.bloqueado && this.recargaStock) {
            throw new ExcepcionCantidadInsuficiente(PRODUCTO_LLEGO_A_SU_STOCK_MINIMO);
        }
    }

    public void actualizarStock(Integer cantidad) {
       validarPositivo(cantidad.doubleValue(), CANTIDAD_NEGATIVA);
       this.cantidad = this.cantidad + cantidad;
       if (this.cantidad > 5) {
           this.recargaStock = false;
           this.bloqueado = false;
           this.fechaRecarga = LocalDateTime.now();
           return;
       }
       if(this.cantidad <= 2) {
           this.recargaStock = true;
           this.bloqueado = true;
           this.fechaRecarga = LocalDateTime.now();
           return;
       }
        if (this.cantidad <= 5) {
            this.recargaStock = true;
            this.bloqueado = false;
            this.fechaRecarga = LocalDateTime.now();
        }
    }
}
