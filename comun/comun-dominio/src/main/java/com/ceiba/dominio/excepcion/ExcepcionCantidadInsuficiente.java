package com.ceiba.dominio.excepcion;

public class ExcepcionCantidadInsuficiente extends RuntimeException{

    private static final long serialVersionUID = 1L;

    public ExcepcionCantidadInsuficiente(String mensaje) {
        super(mensaje);
    }
}
