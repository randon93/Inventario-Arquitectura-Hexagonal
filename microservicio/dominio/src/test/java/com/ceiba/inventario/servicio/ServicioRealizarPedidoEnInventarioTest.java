package com.ceiba.inventario.servicio;

import com.ceiba.BasePrueba;
import com.ceiba.dominio.excepcion.ExcepcionLongitudValor;
import com.ceiba.inventario.servicio.testDataBuilder.InventarioTestDataBuilder;
import com.ceiba.usuario.puerto.dao.DaoInventario;
import com.ceiba.usuario.puerto.repositorio.RepositorioInventario;
import com.ceiba.usuario.servicio.inventario.ServicioRealizarPedidoEnInventario;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import java.time.Clock;
import java.time.LocalDate;
import java.time.Month;
import java.time.ZoneId;

@RunWith(MockitoJUnitRunner.class)
public class ServicioRealizarPedidoEnInventarioTest {

    @Mock
    private RepositorioInventario repositorioInventario;

    @Mock
    private DaoInventario daoInventario;

    @Mock
    private Clock fechaActual;

    @InjectMocks
    private ServicioRealizarPedidoEnInventario servicioRealizarPedidoEnInventario;

    @Test
    public void validarError() {
        LocalDate localDate = LocalDate.of(2020, Month.DECEMBER, 30);
        Long producto = 1l;
        Integer pedido = 1;
        Mockito.when(fechaActual.getZone()).thenReturn(ZoneId.systemDefault());
        Mockito.when(fechaActual.instant()).thenReturn(localDate.atStartOfDay(ZoneId.systemDefault()).toInstant());

        BasePrueba.assertThrows(
                () -> servicioRealizarPedidoEnInventario.ejecutar(producto, pedido),
                ExcepcionLongitudValor.class,
                "la cantidad de dias asignados superan los dias que tiene el mes"
        );
    }

    @Test
    public void validarExito() {
        LocalDate localDate = LocalDate.of(2020, Month.DECEMBER, 21);
        Long producto = 1l;
        Integer pedido = 1;
        InventarioTestDataBuilder inventario =  new InventarioTestDataBuilder().conProducto(1l).conCantidad(3).conId(2l);
        Mockito.when(fechaActual.getZone()).thenReturn(ZoneId.systemDefault());
        Mockito.when(fechaActual.instant()).thenReturn(localDate.atStartOfDay(ZoneId.systemDefault()).toInstant());
        Mockito.when(daoInventario.buscarPorIdProducto(Mockito.anyLong())).thenReturn(inventario.build());
        servicioRealizarPedidoEnInventario.ejecutar(producto, pedido);
    }


}
