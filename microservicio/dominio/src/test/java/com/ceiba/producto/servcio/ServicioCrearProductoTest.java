package com.ceiba.producto.servcio;

import com.ceiba.BasePrueba;
import com.ceiba.dominio.excepcion.ExcepcionObjectoNoEncontrado;
import com.ceiba.dominio.excepcion.ExcepcionValorInvalido;
import com.ceiba.producto.servcio.testDataBuilder.ProductoTestDataBuilder;
import com.ceiba.usuario.modelo.entidad.Producto;
import com.ceiba.usuario.puerto.repositorio.RepositorioProducto;
import com.ceiba.usuario.servicio.producto.ServicioCrearProducto;
import org.junit.Test;
import org.mockito.Mockito;

public class ServicioCrearProductoTest {

    @Test
    public void validadrPrecioNegatvoTest() {
        ProductoTestDataBuilder productoTestDataBuilder = new ProductoTestDataBuilder().conPrecio(-1F);
        BasePrueba.assertThrows(
                () -> productoTestDataBuilder.builder(), ExcepcionValorInvalido.class, "Por favor ingrese un precio mayor a CERO (0), Gracias.");
    }

    @Test
    public void validarExistenciaPreviaTest() {
        Producto producto = new ProductoTestDataBuilder().builder();
        RepositorioProducto repositorioProducto = Mockito.mock(RepositorioProducto.class);
        Mockito.when(repositorioProducto.existe(Mockito.anyString())).thenReturn(true);
        ServicioCrearProducto servicioCrearProducto = new ServicioCrearProducto(repositorioProducto);
        BasePrueba.assertThrows(() -> servicioCrearProducto.ejecutar(producto), ExcepcionObjectoNoEncontrado.class, "El producto ya existe");
    }



}
