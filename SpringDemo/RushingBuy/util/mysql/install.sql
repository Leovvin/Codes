-- table create
drop database if exists RushingBuy;
create database RushingBuy default character set utf8;
use RushingBuy;
drop table if exists goods;
create table goods(id bigint,name varchar(20) not null,num int not null,price double not null,primary key(id));

-- data insert
insert into goods values (1,'bike',100,100),(2,'motor',10,1000);
show tables;
notee
