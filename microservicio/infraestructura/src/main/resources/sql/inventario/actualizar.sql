UPDATE inventario
SET
cantidad = :cantidad,
fecha_recarga = :fechaRecarga,
recarga_stock = :recargaStock,
bloqueado = :bloqueado
WHERE id = :id;