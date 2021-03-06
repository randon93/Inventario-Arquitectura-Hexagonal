package com.ceiba.inventario.servicio;

import com.ceiba.usuario.comando.inventario.ComandoInventario;

import java.time.LocalDateTime;

public class ComandoInventarioTestDataBuilder {

    private Long id;
    private Long producto;
    private Integer cantidad;
    private Boolean recargaStock;
    private LocalDateTime fechaRecarga;
    private Boolean bloqueado;

    public ComandoInventarioTestDataBuilder() {
        bloqueado = false;
        recargaStock = false;
        fechaRecarga = LocalDateTime.now();
        cantidad = 123;
        producto = 1L;
        id = 1l;
    }

    public ComandoInventario build() {
        return new ComandoInventario(
                id, producto, cantidad,fechaRecarga, bloqueado,recargaStock
        );
    }
}
