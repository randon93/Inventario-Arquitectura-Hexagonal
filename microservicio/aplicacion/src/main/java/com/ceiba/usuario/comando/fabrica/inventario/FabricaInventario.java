package com.ceiba.usuario.comando.fabrica.inventario;

import com.ceiba.usuario.comando.ComandoInventario;
import com.ceiba.usuario.modelo.dto.DtoInventario;
import com.ceiba.usuario.modelo.dto.DtoPedido;
import com.ceiba.usuario.modelo.entidad.Inventario;
import com.ceiba.usuario.modelo.entidad.Pedido;
import org.springframework.stereotype.Component;

@Component
public class FabricaInventario {

    public Inventario crear(ComandoInventario inventario) {
        return new Inventario(
                inventario.getId(),
                inventario.getProducto(),
                inventario.getCantidad(),
                inventario.getRecargaStock(),
                inventario.getFechaRecarga(),
                inventario.getBloqueado()
        );
    }


    public Inventario crear(DtoInventario inventario) {
        return new Inventario(
                inventario.getId(),
                inventario.getProducto(),
                inventario.getCantidad(),
                inventario.getRecargaStock(),
                inventario.getFechaRecarga(),
                inventario.getBloqueado()
        );
    }

    public DtoInventario crear(Inventario inventario) {
        return new DtoInventario(
                inventario.getId(),
                inventario.getProducto(),
                "",
                inventario.getCantidad(),
                inventario.getRecargaStock(),
                inventario.getFechaRecarga(),
                inventario.getBloqueado()
        );
    }
}
