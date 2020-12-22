package com.ceiba.producto.controlador;

import com.ceiba.ComandoRespuesta;
import com.ceiba.usuario.comando.ComandoProducto;
import com.ceiba.usuario.comando.manejador.producto.ManejadorActualizarPrecioProducto;
import com.ceiba.usuario.comando.manejador.producto.ManejadorAgregarProducto;
import com.ceiba.usuario.comando.manejador.producto.ManejadorEliminarProducto;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/producto")
@Api(tags = {"CONTROLADOR COMANDO PRODUCTOS"})
public class ComandoControladorProducto {

    private final ManejadorAgregarProducto manejadorAgregarProducto;
    private final ManejadorActualizarPrecioProducto manejadorActualizarProducto;
    private final ManejadorEliminarProducto manejadorEliminarProducto;

    public ComandoControladorProducto(ManejadorAgregarProducto manejadorAgregarProducto, ManejadorActualizarPrecioProducto manejadorActualizarProducto, ManejadorEliminarProducto manejadorEliminarProducto) {
        this.manejadorAgregarProducto = manejadorAgregarProducto;
        this.manejadorActualizarProducto = manejadorActualizarProducto;
        this.manejadorEliminarProducto = manejadorEliminarProducto;
    }

    @PostMapping
    @ApiOperation("Crear Producto")
    public ComandoRespuesta<Long> crear(@RequestBody ComandoProducto comandoProducto) {
        return manejadorAgregarProducto.ejecutar(comandoProducto);
    }

    @PutMapping
    @ApiOperation("Actualizar Producto")
    public void actualizar(@RequestBody ComandoProducto comandoProducto) {
        manejadorActualizarProducto.ejecutar(comandoProducto);
    }

    @DeleteMapping("/delete/{id}")
    @ApiOperation(("Permite Eliminar un producto si no tiene stock en el inventario"))
    public void eliminar(@PathVariable Long id) {
        manejadorEliminarProducto.ejecutar(id);
    }


}
