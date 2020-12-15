drop database if exists demo;
create database demo;
use demo;
create table account(
    id int(10) not null auto_increment,
    name varchar(10) not null,
    create_time timestamp not null default current_timestamp,
    update_time timestamp not null default current_timestamp on update current_timestamp,
    primary key (id)
)engine=innoDB;

insert into account values (null,"ll",null,null);