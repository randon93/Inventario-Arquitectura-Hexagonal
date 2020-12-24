package com.ceiba.usuario.consulta.inventario;

import com.ceiba.usuario.comando.fabrica.inventario.FabricaInventario;
import com.ceiba.usuario.modelo.dto.DtoInventario;
import com.ceiba.usuario.puerto.dao.DaoInventario;
import org.springframework.stereotype.Component;

@Component
public class ManejadorBucarInventarioPorId {

    private final DaoInventario daoInventario;
    private final FabricaInventario fabricaInventario;

    public ManejadorBucarInventarioPorId(DaoInventario daoInventario, FabricaInventario fabricaInventario) {
        this.daoInventario = daoInventario;
        this.fabricaInventario = fabricaInventario;
    }

    public DtoInventario ejecutar(Long id) {
        return daoInventario.buscarPorId(id);
    }
}
