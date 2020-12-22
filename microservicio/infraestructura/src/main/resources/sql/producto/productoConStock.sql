select count(1) from
producto pr INNER JOIN inventario inv
 ON pr.id = inv.producto
WHERE inv.cantidad > 2 AND inv.producto = :id;