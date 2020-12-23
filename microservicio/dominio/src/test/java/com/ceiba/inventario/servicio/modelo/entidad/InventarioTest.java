package com.ceiba.inventario.servicio.modelo.entidad;

import com.ceiba.BasePrueba;
import com.ceiba.dominio.excepcion.ExcepcionCantidadInsuficiente;
import com.ceiba.dominio.excepcion.ExcepcionValorInvalido;
import com.ceiba.inventario.servicio.testDataBuilder.InventarioTestDataBuilder;
import com.ceiba.usuario.modelo.entidad.Inventario;
import org.junit.Assert;
import org.junit.Test;

import java.time.LocalDateTime;

public class InventarioTest {

    private static final Integer CANTIDAD_MINIMA = 2;

    @Test
    public void validarPedidoConStockIgualMenosA5() {
        Inventario inventario = new InventarioTestDataBuilder()
                .conCantidad(5)
                .build();
        inventario.validarPedido(1, CANTIDAD_MINIMA);
        Assert.assertEquals(inventario.getCantidad(), 4, 0);
        Assert.assertEquals(inventario.getRecargaStock(), true);
        Assert.assertEquals(inventario.getBloqueado(), false);
    }

    @Test
    public void validarPedidoConStockMayorA5() {
        Inventario inventario = new InventarioTestDataBuilder()
                .conCantidad(10)
                .build();
        inventario.validarPedido(2, CANTIDAD_MINIMA);
        Assert.assertEquals(inventario.getCantidad(), 8, 0);
        Assert.assertEquals(inventario.getRecargaStock(), false);
        Assert.assertEquals(inventario.getBloqueado(), false);
    }

    @Test
    public void validarPedidoConStockEntre1YCantidadMInima() {
        Inventario inventario = new InventarioTestDataBuilder()
                .conCantidad(3)
                .build();
        inventario.validarPedido(1, CANTIDAD_MINIMA);
        Assert.assertEquals(inventario.getCantidad(), 2, 0);
        Assert.assertEquals(inventario.getRecargaStock(), true);
        Assert.assertEquals(inventario.getBloqueado(), true);
    }

    @Test
    public void validarPedidoInventarioBloqueado() {
        Inventario inventario = new InventarioTestDataBuilder()
                .conCantidad(1)
                .bloqueado()
                .necesitaRecarga()
                .build();

        BasePrueba.assertThrows(
                () -> inventario.validarPedido(1, CANTIDAD_MINIMA),
                ExcepcionCantidadInsuficiente.class,
                "Producto no tiene existencia."
        );
    }

    @Test
    public void actualizarStockMayorA5() {
        Inventario inventario = new InventarioTestDataBuilder()
                .conCantidad(5)
                .build();

        inventario.actualizarStock(1);
        Assert.assertEquals(inventario.getCantidad(), 6, 0);
        Assert.assertEquals(inventario.getRecargaStock(), false);
        Assert.assertEquals(inventario.getBloqueado(), false);
        Assert.assertEquals(
                inventario.getFechaRecarga().toLocalDate(),
                LocalDateTime.now().toLocalDate()
        );
    }

    @Test
    public void actualizarStockMenorIgualA5() {
        Inventario inventario = new InventarioTestDataBuilder()
                .conCantidad(4)
                .build();

        inventario.actualizarStock(1);
        Assert.assertEquals(inventario.getCantidad(), 5, 0);
        Assert.assertEquals(inventario.getRecargaStock(), true);
        Assert.assertEquals(inventario.getBloqueado(), false);
        Assert.assertEquals(
                inventario.getFechaRecarga().toLocalDate(),
                LocalDateTime.now().toLocalDate()
        );
    }

    @Test
    public void actualizarStockMenorIgual2() {
        Inventario inventario = new InventarioTestDataBuilder()
                .conCantidad(1)
                .build();

        inventario.actualizarStock(1);
        Assert.assertEquals(inventario.getCantidad(), 2, 0);
        Assert.assertEquals(inventario.getRecargaStock(), true);
        Assert.assertEquals(inventario.getBloqueado(), true);
        Assert.assertEquals(
                inventario.getFechaRecarga().toLocalDate(),
                LocalDateTime.now().toLocalDate()
        );
    }

    @Test
    public void actualizarStockConCantidadMenorIgualCero() {
        Inventario inventario = new InventarioTestDataBuilder()
                .conCantidad(1)
                .build();

        BasePrueba.assertThrows(
                () -> inventario.actualizarStock(0),
                ExcepcionValorInvalido.class,
                "Porfavor la cantidad del producto debe de ser positiva."
        );
    }
}
