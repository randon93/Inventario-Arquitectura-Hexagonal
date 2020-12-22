package com.ceiba.usuario.comando;

import com.ceiba.usuario.modelo.entidad.Producto;
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
}
