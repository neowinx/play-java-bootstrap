# --- !Ups

insert into persona(id, nombre, apellido) values(1, 'Pedro', 'Paredes');
insert into persona(id, nombre, apellido) values(2, 'Maria', 'Martinez');
insert into persona(id, nombre, apellido) values(3, 'Alcides', 'Amarilla');


# --- !Downs

delete from persona;
