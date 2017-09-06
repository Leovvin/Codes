-- table create
create database if not exists AccountManage default character set utf8;
use AccountManage;
drop table if exists account;
create table account(id bigint,name varchar(20),password varchar(20),primary key(id));
drop table if exists role;
create table role(id bigint,name varchar(20),primary key(id));
drop table if exists privilege;
create table privilege(id bigint,privilege int,desc varchar(20),primary key(id));
-- data insert
insert into goods values (1,'bike',100,100),(2,'motor',10,1000);
select * from goods;
notee
