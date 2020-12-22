package com.ceiba.usuario.comando.manejador.usuario;

import com.ceiba.manejador.ManejadorComando;
import com.ceiba.usuario.servicio.usuario.ServicioEliminarUsuario;
import org.springframework.stereotype.Component;


@Component
public class ManejadorEliminarUsuario implements ManejadorComando<Long> {

    private final ServicioEliminarUsuario servicioEliminarUsuario;

    public ManejadorEliminarUsuario(ServicioEliminarUsuario servicioEliminarUsuario) {
        this.servicioEliminarUsuario = servicioEliminarUsuario;
    }

    public void ejecutar(Long idUsuario) {
        this.servicioEliminarUsuario.ejecutar(idUsuario);
    }
}
