package com.ceiba.usuario.modelo.entidad;

import lombok.Getter;

import static com.ceiba.dominio.ValidadorArgumento.validarObligatorio;

@Getter
public class Pedido {

    private final static String EL_PEDIDO_DEBE_TENER_USUARIO = "Usuario en el pedido vacio.";
    private final static String EL_PEDIDO_DEBE_TENER_CANTIDAD_PRODUCTO = "Cantidad en el pedido vacia.";
    private final static String EL_PEDIDO_DEBE_TENER_PRODUCTO = "Producto en el pedido vacio.";
    private final static Integer DESCUENTO_POR_CANTIDAD_STOCK = 16;
    private final static Integer CANTIDAD_EN_STOCK_PARA_APLICAR_DESCUENTO = 15;

    private Long id;
    private Long usuario;
    private Integer cantidad;
    private Long producto;
    private Double precioTotal;

    public Pedido(Long id, Long usuario, Integer cantidad, Long producto) {
        validarObligatorio(usuario, EL_PEDIDO_DEBE_TENER_USUARIO);
        validarObligatorio(cantidad, EL_PEDIDO_DEBE_TENER_CANTIDAD_PRODUCTO);
        validarObligatorio(producto, EL_PEDIDO_DEBE_TENER_PRODUCTO);

        this.id = id;
        this.usuario = usuario;
        this.cantidad = cantidad;
        this.producto = producto;
    }

    public void calcularPrecioTotal(Double precioProducto, Integer cantidadStock) {
        Double precioConDescuento;
        Double precioReal;
            if (cantidadStock >= CANTIDAD_EN_STOCK_PARA_APLICAR_DESCUENTO) {
                double descuento = (precioProducto * DESCUENTO_POR_CANTIDAD_STOCK) / 100;
                precioReal = precioProducto * this.cantidad;
                precioConDescuento = precioReal - descuento;
                this.precioTotal = precioConDescuento;
            }
            else {
                this.precioTotal = precioProducto * this.cantidad;
            }
    }
}
