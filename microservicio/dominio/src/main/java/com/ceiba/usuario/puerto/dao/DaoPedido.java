package com.ceiba.usuario.puerto.dao;

import com.ceiba.usuario.modelo.dto.DtoFactura;
import com.ceiba.usuario.modelo.dto.DtoPedido;

import java.util.List;

public interface DaoPedido {

    List<DtoPedido> listar();

    DtoPedido buscarPorId(Long idProducto);
}
