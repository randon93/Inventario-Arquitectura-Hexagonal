package com.ceiba.configuracion;

import com.ceiba.usuario.puerto.dao.DaoInventario;
import com.ceiba.usuario.puerto.dao.DaoProducto;
import com.ceiba.usuario.puerto.repositorio.RepositorioInventario;
import com.ceiba.usuario.puerto.repositorio.RepositorioPedido;
import com.ceiba.usuario.puerto.repositorio.RepositorioProducto;
import com.ceiba.usuario.puerto.repositorio.RepositorioUsuario;
import com.ceiba.usuario.servicio.inventario.ServicioActualizarInventario;
import com.ceiba.usuario.servicio.inventario.ServicioCrearInventario;
import com.ceiba.usuario.servicio.inventario.ServicioEliminarInventario;
import com.ceiba.usuario.servicio.inventario.ServicioRealizarPedidoEnInventario;
import com.ceiba.usuario.servicio.pedido.ServicioCalcularPrecioTotal;
import com.ceiba.usuario.servicio.pedido.ServicioCrearPedido;
import com.ceiba.usuario.servicio.producto.ServicioActualizarProducto;
import com.ceiba.usuario.servicio.producto.ServicioCrearProducto;
import com.ceiba.usuario.servicio.producto.ServicioEliminarProducto;
import com.ceiba.usuario.servicio.usuario.ServicioActualizarUsuario;
import com.ceiba.usuario.servicio.usuario.ServicioCrearUsuario;
import com.ceiba.usuario.servicio.usuario.ServicioEliminarUsuario;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import java.time.Clock;
import java.time.LocalDate;
import java.util.Calendar;

@Configuration
public class BeanServicio {

    //Usuario
    @Bean
    public ServicioCrearUsuario servicioCrearUsuario(RepositorioUsuario repositorioUsuario) {
        return new ServicioCrearUsuario(repositorioUsuario);
    }

    @Bean
    public ServicioEliminarUsuario servicioEliminarUsuario(RepositorioUsuario repositorioUsuario) {
        return new ServicioEliminarUsuario(repositorioUsuario);
    }

    @Bean
    public ServicioActualizarUsuario servicioActualizarUsuario(RepositorioUsuario repositorioUsuario) {
        return new ServicioActualizarUsuario(repositorioUsuario);
    }

    //Producto
    @Bean
    public ServicioCrearProducto servicioCrearProducto(RepositorioProducto repositorioProducto) {
        return new ServicioCrearProducto(repositorioProducto);
    }

    @Bean
    public ServicioActualizarProducto servicioActualizarProducto(RepositorioProducto repositorioProducto) {
        return new ServicioActualizarProducto(repositorioProducto);
    }

    @Bean
    public ServicioEliminarProducto servicioEliminarProducto(RepositorioProducto repositorioInventario, DaoProducto daoProducto){
        return new ServicioEliminarProducto(repositorioInventario, daoProducto);
    }

    //Inventario
    @Bean
    public ServicioActualizarInventario servicioActualizarInventario(
            RepositorioInventario repositorioInventario,
            com.ceiba.usuario.puerto.dao.DaoInventario daoInventario) {
        return new ServicioActualizarInventario(repositorioInventario, daoInventario);
    }

    @Bean
    public ServicioRealizarPedidoEnInventario servicioPedidoInventario(RepositorioInventario repositorioInventario, DaoInventario daoInventario, RepositorioUsuario repositorioUsuario, Clock fechaActual) {
        return new ServicioRealizarPedidoEnInventario(repositorioInventario, daoInventario, repositorioUsuario, fechaActual);
    }

    @Bean
    public ServicioCrearInventario servicioCrearInventario(RepositorioInventario repositorioInventario) {
        return new ServicioCrearInventario(repositorioInventario);
    }

    @Bean
    public ServicioEliminarInventario servicioEliminarInventario(
            RepositorioInventario repositorioInventario,
            com.ceiba.usuario.puerto.dao.DaoInventario daoInventario) {
        return new ServicioEliminarInventario(repositorioInventario, daoInventario);
    }

    //Pedido
    @Bean
    public ServicioCrearPedido servicioCrearPedido(RepositorioPedido repositorioPedido) {
        return new ServicioCrearPedido(repositorioPedido);
    }

    @Bean
    public ServicioCalcularPrecioTotal servicioCalcularPrecioTotal(RepositorioPedido repositorioPedido, DaoProducto daoProducto, DaoInventario daoInventario) {
        return new ServicioCalcularPrecioTotal(repositorioPedido, daoProducto, daoInventario);
    }

    @Bean
    public Clock clock() {
        return Clock.systemDefaultZone();
    }
}
