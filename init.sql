create table City(
    id int primary key not null unique,
    name varchar not null ,
    region varchar not null ,
    district varchar not null ,
    population int not null,
    foundation varchar
);

CREATE SEQUENCE id_seq INCREMENT 1
    MINVALUE 1
    MAXVALUE 499
    START WITH 1 CYCLE;

