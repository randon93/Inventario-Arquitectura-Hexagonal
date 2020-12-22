select id, producto, cantidad, recarga_stock, fecha_recarga, bloqueado
from inventario where producto = :id