create database if not exists SecondKill default character set utf8;
use SecondKill;
drop table if exists user;
create table user(id bigint,name varchar(20));
drop table if exists goods;
create table goods(id bigint,name varchar(20),num int,price double);
