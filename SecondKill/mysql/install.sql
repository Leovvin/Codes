create database if not exists SecondKill default character set utf8;
use SecondKill;
create table if not exists user(id smallint,name varchar(20));
create table if not exists goods(id int,name varchar(20),num int);
insert into user values (1,'jack'),(2,'robin'),(3,'mark');
select * from user;
notee
