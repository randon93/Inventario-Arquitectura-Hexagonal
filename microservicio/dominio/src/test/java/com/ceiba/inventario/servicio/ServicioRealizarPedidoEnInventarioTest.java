package com.ceiba.inventario.servicio;

import com.ceiba.BasePrueba;
import com.ceiba.dominio.excepcion.ExcepcionLongitudValor;
import com.ceiba.inventario.servicio.testDataBuilder.InventarioTestDataBuilder;
import com.ceiba.pedido.servicio.testDataBuilder.PedidoTestDataBuilder;
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
        Mockito.when(fechaActual.getZone()).thenReturn(ZoneId.systemDefault());
        Mockito.when(fechaActual.instant()).thenReturn(localDate.atStartOfDay(ZoneId.systemDefault()).toInstant());
        InventarioTestDataBuilder inventario =  new InventarioTestDataBuilder().conProducto(1l).conCantidad(3).conId(2l);
        PedidoTestDataBuilder pedido = new PedidoTestDataBuilder().conProducto(1l).conCantidad(1).conUsuario(1l);
        BasePrueba.assertThrows(
                () -> servicioRealizarPedidoEnInventario.ejecutar(inventario.build(), pedido.build()),
                ExcepcionLongitudValor.class,
                "la cantidad de dias asignados superan los dias que tiene el mes"
        );
    }

    @Test
    public void validarExito() {
        LocalDate localDate = LocalDate.of(2020, Month.DECEMBER, 21);
        InventarioTestDataBuilder inventario =  new InventarioTestDataBuilder().conProducto(1l).conCantidad(3).conId(2l);
        PedidoTestDataBuilder pedido = new PedidoTestDataBuilder().conProducto(1l).conCantidad(1).conUsuario(1l);
        Mockito.when(fechaActual.getZone()).thenReturn(ZoneId.systemDefault());
        Mockito.when(fechaActual.instant()).thenReturn(localDate.atStartOfDay(ZoneId.systemDefault()).toInstant());
        servicioRealizarPedidoEnInventario.ejecutar(inventario.build(), pedido.build());
    }


}
