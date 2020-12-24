package com.ceiba.usuario.comando.inventario;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ComandoInventario {

    private Long id;
    private Long producto;
    private Integer cantidad;
    private LocalDateTime fechaRecarga;
    private Boolean bloqueado;
    private Boolean recargaStock;
}
