-- MySQL dump 10.13  Distrib 5.7.25, for macos10.14 (x86_64)
--
-- Host: localhost    Database: jta_test_1
-- ------------------------------------------------------
-- Server version	5.7.25

use jta_test_1;
drop table if exists account;

create table account(
    `id` int(10) not null auto_increment,
    `name` varchar(10) not null,
    `asset` int(10) not null default 0,
    `create_time` timestamp not null default current_timestamp,
    `update_time` timestamp not null default current_timestamp on update current_timestamp,
    primary key (`id`)
) engine=innoDB default charset=utf8;
insert into account values (null,"account1",100,null,null);


use jta_test_2;
drop table if exists account;
create table account(
    `id` int(10) not null auto_increment,
    `name` varchar(10) not null,
    `asset` int(10) not null default 0,
    `create_time` timestamp not null default current_timestamp,
    `update_time` timestamp not null default current_timestamp on update current_timestamp,
    primary key (`id`)
)engine=innoDB default charset=utf8;;
insert into account values (null,"account2",100,null,null);



