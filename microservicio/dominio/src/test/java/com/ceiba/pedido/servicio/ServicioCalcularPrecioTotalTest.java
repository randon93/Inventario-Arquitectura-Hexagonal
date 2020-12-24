package com.ceiba.pedido.servicio;

import com.ceiba.pedido.servicio.testDataBuilder.PedidoTestDataBuilder;
import com.ceiba.usuario.modelo.dto.DtoInventario;
import com.ceiba.usuario.modelo.dto.DtoProducto;
import com.ceiba.usuario.modelo.entidad.Inventario;
import com.ceiba.usuario.modelo.entidad.Pedido;
import com.ceiba.usuario.puerto.dao.DaoInventario;
import com.ceiba.usuario.puerto.dao.DaoProducto;
import com.ceiba.usuario.puerto.repositorio.RepositorioPedido;
import com.ceiba.usuario.servicio.pedido.ServicioCalcularPrecioTotal;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class ServicioCalcularPrecioTotalTest {

    @Mock
    private RepositorioPedido repositorioPedido;

    @Mock
    private DaoProducto daoProducto;

    @Mock
    private DaoInventario daoInventario;

    @InjectMocks
    private ServicioCalcularPrecioTotal servicioCalcularPrecioTotal;

    @Test
    public void calcularPrecioTest() {
        //ini parametros
        DtoProducto producto = Mockito.mock(DtoProducto.class);
        DtoInventario inventario = Mockito.mock(DtoInventario.class);
        Pedido pedido = new PedidoTestDataBuilder().build();
        Float precio = 5f;
        Integer cantidadStock = 3;

        //Asignacion parametros
        Mockito.when(daoProducto.buscarPorId(Mockito.anyLong())).thenReturn(producto);
        Mockito.when(daoInventario.buscarPorIdProducto(Mockito.anyLong())).thenReturn(inventario);
        Mockito.when(producto.getPrecio()).thenReturn(precio);
        Mockito.when(inventario.getCantidad()).thenReturn(cantidadStock);

        //Verificacion resultados
        Double total = servicioCalcularPrecioTotal.ejecutar(pedido);
        Assert.assertEquals(total, 5d, 0d);
    }
}
