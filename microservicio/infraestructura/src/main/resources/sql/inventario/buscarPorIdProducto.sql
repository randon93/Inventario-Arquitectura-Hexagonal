select inve.id, inve.producto, inve.cantidad, inve.recarga_stock, inve.fecha_recarga,
inve.bloqueado, pro.nombre as nombre_producto
from inventario inve INNER JOIN producto pro ON inve.producto = pro.id where inve.producto = :id