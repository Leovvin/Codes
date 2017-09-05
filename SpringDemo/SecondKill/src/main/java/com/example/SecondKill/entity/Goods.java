package com.example.SecondKill.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Goods {

    @Id
    @GeneratedValue
    long id;
    String name;
    int num;

    public String getName() {
        return name;
    }

    public int getNum() {
        return num;
    }

    public double getPrice() {
        return price;
    }

    double price;

}
