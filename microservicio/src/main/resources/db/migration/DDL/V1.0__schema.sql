create table usuario (
 id int(11) not null auto_increment,
 nombre varchar(100) not null,
 clave varchar(45) not null,
 fecha_creacion datetime null,
 primary key (id)
);

create table producto (
 id int(11) not null auto_increment,
 nombre varchar(100) not null,
 precio int(45) not null,
 primary key (id)
);

create table inventario (
 id int(11) not null auto_increment,
 producto int(11) not null,
 fecha_recarga datetime null,
 recarga_stock tinyint(1) not null,
 bloqueado tinyint(1) not null,
 cantidad int(5) not null,
 UNIQUE (producto),
 primary key (id)
 );

 create table pedido(
 id int(11) not null auto_increment,
 usuario int(11) not null,
 cantidad int(4) not null,
 producto int(11) not null,
 precio_total int(11),
 primary key (id)
 );
