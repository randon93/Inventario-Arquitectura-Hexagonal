package com.ceiba.usuario.comando.inventario;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ComandoActualizarInventario {
    private Long id;
    private Long producto;
    private Integer cantidad;
}
