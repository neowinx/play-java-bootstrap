# --- Created by Ebean DDL
# To stop Ebean DDL generation, remove this comment and start using Evolutions

# --- !Ups

create table persona (
  id                        bigint not null,
  nombre                    varchar(255),
  apellido                  varchar(255),
  fecha_nacimiento          timestamp,
  constraint pk_persona primary key (id))
;

create sequence persona_seq;




# --- !Downs

SET REFERENTIAL_INTEGRITY FALSE;

drop table if exists persona;

SET REFERENTIAL_INTEGRITY TRUE;

drop sequence if exists persona_seq;

