package com.ceiba.inventario.servicio;

import com.ceiba.BasePrueba;
import com.ceiba.dominio.excepcion.ExcepcionDuplicidad;
import com.ceiba.dominio.excepcion.ExcepcionObjectoNoEncontrado;
import com.ceiba.inventario.servicio.testDataBuilder.InventarioTestDataBuilder;
import com.ceiba.usuario.puerto.repositorio.RepositorioInventario;
import com.ceiba.usuario.servicio.inventario.ServicioCrearInventario;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class ServicioCrearInventarioTest {

    @Mock
    private RepositorioInventario repositorioInventario;

    @InjectMocks
    private ServicioCrearInventario servicioCrearInventario;

    @Test
    public void validarExistenciPrecia() {
        Long productoId = 4l;

        Mockito.when(repositorioInventario.existe(Mockito.anyLong())).thenReturn(true);

        BasePrueba.assertThrows(
                () -> servicioCrearInventario.ejecutar(productoId),
                        ExcepcionDuplicidad.class,
                        "El producto ya existe en el inventario");
    }

}
