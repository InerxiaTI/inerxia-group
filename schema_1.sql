create database if not exists oepkmxa1ekvbx8i7;
use oepkmxa1ekvbx8i7;
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
-- mysql://v88ppjlc6s8e6fh9:m969jds59ifunm3v@o61qijqeuqnj9chh.cbetxkdyhwsb.us-east-1.rds.amazonaws.com:3306/oepkmxa1ekvbx8i7
-- mysql: // NEWUSER: NEWPASS @ NEWHOST: 3306 / NEWDATABASE