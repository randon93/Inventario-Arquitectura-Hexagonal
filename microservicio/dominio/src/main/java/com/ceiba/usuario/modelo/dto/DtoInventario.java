package com.ceiba.usuario.modelo.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
@AllArgsConstructor
public class DtoInventario {

    private Long id;
    private Long producto;
    private String nombreProducto;
    private Integer cantidad;
    private LocalDateTime fechaRecarga;
    private Boolean recargaStock;
    private Boolean bloqueado;

}
