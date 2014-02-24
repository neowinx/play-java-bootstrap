# --- !Ups

insert into persona(id, nombre, apellido) values (1, 'Pedro', 'Paredes');
insert into persona(id, nombre, apellido, fecha_nacimiento) values (2, 'Maria', 'Martinez', now());
insert into persona(id, nombre, apellido) values (3, 'Alcides', 'Amarilla');


# --- !Downs

delete from persona;
