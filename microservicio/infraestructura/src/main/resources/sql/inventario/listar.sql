SELECT inv.id, inv.producto, pr.nombre AS nombre_producto, inv.fecha_recarga, inv.recarga_stock, inv.bloqueado, inv.cantidad
 FROM inventario inv INNER JOIN producto pr ON inv.producto = pr.id;