package com.ceiba.producto.servcio;

import com.ceiba.BasePrueba;
import com.ceiba.dominio.excepcion.ExcepcionObjectoNoEncontrado;
import com.ceiba.dominio.excepcion.ExcepcionValorInvalido;
import com.ceiba.producto.servcio.testDataBuilder.ProductoTestDataBuilder;
import com.ceiba.usuario.modelo.entidad.Producto;
import com.ceiba.usuario.puerto.repositorio.RepositorioProducto;
import com.ceiba.usuario.servicio.producto.ServicioActualizarProducto;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class ServicioActualizarProductoTest {

    @InjectMocks
    private ServicioActualizarProducto servicioActualizarProducto;

    @Mock
    private RepositorioProducto repositorioProducto;

    @Test
    public void validadrPrecioNegatvoTest() {
        ProductoTestDataBuilder productoTestDataBuilder = new ProductoTestDataBuilder().conPrecio(-1F);
        BasePrueba.assertThrows(
                () -> productoTestDataBuilder.builder(), ExcepcionValorInvalido.class, "Por favor ingrese un precio mayor a CERO (0), Gracias.");
    }

    @Test
    public void validarExistenciaPreviaTest() {
        Producto producto = new ProductoTestDataBuilder().conPrecio(200f).builder();

        Mockito.when(repositorioProducto.existe(Mockito.anyLong())).thenReturn(false);

        BasePrueba.assertThrows(() -> servicioActualizarProducto.ejecutar(producto), ExcepcionObjectoNoEncontrado.class, "EL producto no existe");
    }

}
