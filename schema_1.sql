create database if not exists db_inerxia;
use db_inerxia;
create table contacto(
	id int auto_increment not null,
    nombre varchar(100) not null,
    apellido varchar(100) not null,
    email varchar(100) not null, 
    asunto varchar(100) not null,
    mensaje text not null,
    fecha_envio datetime,
    primary key (id)
);

alter table contacto add estado enum('atendido','esperando','cancelado') after mensaje;
alter table contacto change column estado estado enum('atendido', 'esperando', 'cancelado')  default 'esperando';
