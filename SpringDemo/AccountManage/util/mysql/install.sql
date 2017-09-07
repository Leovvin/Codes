-- table create
drop database if exists AccountManage;
create database AccountManage default character set utf8;
use AccountManage;
drop table if exists User;
create table User(id bigint,name varchar(20) not null,password varchar(20) not null,primary key(id));
drop table if exists Role;
create table Role(id bigint,name varchar(20) not null,des varchar(100),primary key(id));
drop table if exists Privilege;
create table Privilege(id bigint,type int not null,des varchar(100) not null,primary key(id));
drop table if exists UserRole;
create table UserRole(id bigint,userId bigint not null,roleId bigint not null,primary key(id));
drop table if exists RolePrivilege;
create table RolePrivilege(id bigint,roleId bigint not null,privilegeId bigint not null,primary key(id));
drop table if exists Page;
create table Page(id bigint,name varchar(20),url varchar(20),primary key(id));
drop table if exists PagePrivilege;
create table PagePrivilege(id bigint,pageId bigint not null,privilegeId bigint not null,primary key(id));


-- data insert
insert into User values (1,'admin','admin');
insert into Role values (1,'admin','administrator');
show tables;
notee
