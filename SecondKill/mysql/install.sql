create database if not exists SecondKill default character set utf8;
use SecondKill;
create table if not exists tmp(id smallint,val varchar(20));
insert into tmp values (1,'jack'),(2,'robin'),(3,'mark');
select * from tmp;
notee
