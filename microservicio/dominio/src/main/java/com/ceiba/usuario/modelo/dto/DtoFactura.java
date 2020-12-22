package com.ceiba.usuario.modelo.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class DtoFactura {
    private Long codigoPedido;
    private Long codigoUsuario;
    private String nombreUsuario;
    private Long codigoProducto;
    private String nombreProducto;
    private Integer cantidad;
    private Double precioUnitario;
    private Double precioTotal;
}
