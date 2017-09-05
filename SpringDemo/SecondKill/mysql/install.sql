-- table create
create database if not exists SecondKill default character set utf8;
use SecondKill;
drop table if exists goods;
create table goods(id bigint,name varchar(20),num int,price double,primary key(id));

-- data insert
insert into goods values (1,'bike',100,100),(2,'motor',10,1000);
select * from goods;
notee
