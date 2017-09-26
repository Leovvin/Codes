-- table create
drop database if exists AccountManage;
create database AccountManage default character set utf8;
use AccountManage;
drop table if exists users;
create table users(
    id bigint,
    name varchar(20) not null unique,
    password varchar(20) not null,
    enables tinyint not null,
    primary key(id)
);
drop table if exists roles;
create table roles(
    id bigint,
    name varchar(20) not null,
    des varchar(100),
    primary key(id)
);
drop table if exists privileges;
create table privileges(
    id bigint,
    type int not null,
    des varchar(100) not null,
    primary key(id)
);
drop table if exists user_roles;
create table user_roles(
    id bigint,
    userId bigint not null,
    roleId bigint not null,
    primary key(id)
);
drop table if exists role_privileges;
create table role_privileges(
    id bigint,
    roleId bigint not null,
    privilegeId bigint not null,
    primary key(id)
);
drop table if exists pages;
create table pages(
    id bigint,
    name varchar(20),
    url varchar(20),
    primary key(id)
);
drop table if exists page_privileges;
create table page_privileges(
    id bigint,
    pageId bigint not null,
    privilegeId bigint not null,
    primary key(id)
);


-- data insert
insert into users values (1,'admin','admin',1);
insert into roles values (1,'admin','administrator');
show tables;
notee
