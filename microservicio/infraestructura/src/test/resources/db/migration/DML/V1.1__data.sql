insert into usuario(nombre,clave,fecha_creacion) values ('test','1234',now());


insert into inventario(producto,fecha_recarga,recarga_stock,bloqueado,cantidad) values (1,now(),0,0,55);


insert into producto(nombre, precio) values ('BATMAN',3);
insert into producto(nombre, precio) values ('SUPERMAN',2);


INSERT INTO pedido(usuario,cantidad,producto, precio_total) VALUES (1,1,1,0);