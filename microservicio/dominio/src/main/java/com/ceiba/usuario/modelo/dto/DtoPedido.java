package com.ceiba.usuario.modelo.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class DtoPedido {
    private Long id;
    private Long usuario;
    private Integer cantidad;
    private Long producto;
    private Double precioTotal;
}
