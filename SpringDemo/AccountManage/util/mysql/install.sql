-- table create
drop database if exists AccountManage;
create database AccountManage default character set utf8;
use AccountManage;
drop table if exists user;
create table user(
    id bigint,
    name varchar(20) not null unique,
    password varchar(20) not null,
    primary key(id)
);
drop table if exists role;
create table role(
    id bigint,
    name varchar(20) not null,
    des varchar(100),
    primary key(id)
);
drop table if exists privilege;
create table privilege(
    id bigint,
    type int not null,
    des varchar(100) not null,
    primary key(id)
);
drop table if exists user_role;
create table user_role(
    id bigint,
    userId bigint not null,
    roleId bigint not null,
    primary key(id)
);
drop table if exists role_privilege;
create table role_privilege(
    id bigint,
    roleId bigint not null,
    privilegeId bigint not null,
    primary key(id)
);
drop table if exists page;
create table page(
    id bigint,
    name varchar(20),
    url varchar(20),
    primary key(id)
);
drop table if exists page_privilege;
create table page_privilege(
    id bigint,
    pageId bigint not null,
    privilegeId bigint not null,
    primary key(id)
);


-- data insert
insert into user values (1,'admin','admin');
insert into role values (1,'admin','administrator');
show tables;
notee
