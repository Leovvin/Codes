DROP TABLE tb_product if EXISTS ;
create table tb_product(
    product_id int(10) NOT NULL AUTO_INCREMENT ,
    description VARCHAR(32) DEFAULT "",
    create_time TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP ,
    update_time TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP on update CURRENT_TIMESTAMP ,
    PRIMARY KEY (product_id)
);
insert into tb_product (description) values ("apple");
insert into tb_product (description) values ("banana");

drop table tb_inventory if EXISTS ;
create table tb_inventory(
    inventory_id int(10) NOT null AUTO_INCREMENT,
    product_id int(10) not null,
    stock int(10) not NULL DEFAULT 0,
    create_time TIMESTAMP not null DEFAULT CURRENT_TIMESTAMP ,
    update_time TIMESTAMP not NULL DEFAULT CURRENT_TIMESTAMP on update CURRENT_TIMESTAMP ,
    PRIMARY KEY (inventory_id),
    UNIQUE uk_product_id (product_id)
);
insert into tb_inventory (product_id,stock) values (1,1);
insert into tb_inventory (product_id,stock) values (2,1);

drop table if exist tb_order;
create table tb_order (
    order_id int(10) not NULL AUTO_INCREMENT ,
    product_id int(10) not null,
    user_id int(10) not null,
    amount int(10) not null DEFAULT 0,
    status int(5) not NULL DEFAULT 0,
    create_time TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP ,
    update_time TIMESTAMP not NULL DEFAULT CURRENT_TIMESTAMP on update CURRENT_TIMESTAMP ,
    PRIMARY KEY (order_id)
);

drop table if exist tb_user;
create table tb_user(
    user_id INT(10) not null AUTO_INCREMENT ,
    name VARCHAR(10) not NULL DEFAULT "",
    sex TINYINT NOT NULL DEFAULT 1 COMMENT '0 female,1 male',
    phone VARCHAR (20) DEFAULT NULL ,
    create_time TIMESTAMP not NULL DEFAULT CURRENT_TIMESTAMP ,
    update_time TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP on update CURRENT_TIMESTAMP ,
    PRIMARY KEY (user_id)
);
insert into tb_user (name,phone) values ('ll','12388888888');

