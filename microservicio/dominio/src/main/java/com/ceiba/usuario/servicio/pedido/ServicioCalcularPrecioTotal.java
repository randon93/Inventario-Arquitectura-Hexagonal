package com.ceiba.usuario.servicio.pedido;


import com.ceiba.usuario.modelo.dto.DtoInventario;
import com.ceiba.usuario.modelo.dto.DtoProducto;
import com.ceiba.usuario.modelo.entidad.Pedido;
import com.ceiba.usuario.puerto.dao.DaoInventario;
import com.ceiba.usuario.puerto.dao.DaoProducto;
import com.ceiba.usuario.puerto.repositorio.RepositorioPedido;

public class ServicioCalcularPrecioTotal {

    private final RepositorioPedido repositorioPedido;
    private final DaoProducto daoProducto;
    private final DaoInventario daoInventario;

    public ServicioCalcularPrecioTotal(RepositorioPedido repositorioPedido, DaoProducto daoProducto, DaoInventario daoInventario) {
        this.repositorioPedido = repositorioPedido;
        this.daoProducto = daoProducto;
        this.daoInventario = daoInventario;
    }

    public Double ejecutar(Pedido pedido) {
        DtoProducto dto = daoProducto.buscarPorId(pedido.getProducto());
        DtoInventario inventario = daoInventario.buscarPorIdProducto(pedido.getProducto());
        pedido.calcularPrecioTotal(dto.getPrecio().doubleValue(), inventario.getCantidad());
        repositorioPedido.actualizar(pedido);
        return pedido.getPrecioTotal();
    }
}
