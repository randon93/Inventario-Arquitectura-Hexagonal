package com.ceiba.inventario.servicio;

import com.ceiba.BasePrueba;
import com.ceiba.dominio.excepcion.ExcepcionObjectoNoEncontrado;
import com.ceiba.dominio.excepcion.ExcepcionValorInvalido;
import com.ceiba.inventario.servicio.testDataBuilder.InventarioTestDataBuilder;
import com.ceiba.usuario.modelo.entidad.Inventario;
import com.ceiba.usuario.servicio.inventario.ServicioActualizarInventario;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.runners.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class ServicioActualziarInventarioTest {


    @InjectMocks
    private ServicioActualizarInventario servicioActualizarInventario;

    @Test
    public void actualizarInventarioNoExiste() {
        Long idProducto = 9l;
        Integer cantidadNUeva = 2;
        Inventario inventario = new InventarioTestDataBuilder()
                .conId(9l)
                .conCantidad(cantidadNUeva)
                .conProducto(idProducto)
                .build();

        BasePrueba.assertThrows(
                () -> servicioActualizarInventario.ejecutar(inventario), ExcepcionObjectoNoEncontrado.class, "El inventario del producto no se encontro.");
    }

    @Test
    public void validarCantidadMenorCero() {
        InventarioTestDataBuilder inventario = new InventarioTestDataBuilder()
                .conCantidad(0);
        BasePrueba.assertThrows(() -> inventario.build(), ExcepcionValorInvalido.class, "Porfavor la cantidad del producto debe de ser positiva.");
    }
}
