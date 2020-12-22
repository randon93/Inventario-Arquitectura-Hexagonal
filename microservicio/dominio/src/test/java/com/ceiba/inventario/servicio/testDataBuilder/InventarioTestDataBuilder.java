package com.ceiba.inventario.servicio.testDataBuilder;

import com.ceiba.usuario.modelo.entidad.Inventario;

import java.time.LocalDateTime;

public class InventarioTestDataBuilder {

    private Long id;
    private Long producto;
    private Integer cantidad;
    private Boolean recargaStock;
    private LocalDateTime fechaRecarga;
    private Boolean bloqueado;

    public InventarioTestDataBuilder() {
        this.producto = 1l;
        this.cantidad = 5;
        this.recargaStock = false;
        this.fechaRecarga = LocalDateTime.now();
        this.bloqueado = false;
    }

    public InventarioTestDataBuilder conId(Long id) {
        this.id = id;
        return this;
    }

    public InventarioTestDataBuilder conCantidad(Integer cant) {
        this.cantidad = cant;
        return this;
    }

    public InventarioTestDataBuilder conProducto(Long id) {
        this.producto = id;
        return this;
    }

    public InventarioTestDataBuilder bloqueado() {
        this.bloqueado = true;
        return this;
    }

    public InventarioTestDataBuilder necesitaRecarga() {
        this.recargaStock = true;
        return this;
    }

    public Inventario build() {
        return new Inventario(id, producto, cantidad, recargaStock, fechaRecarga, bloqueado);
    }
}
