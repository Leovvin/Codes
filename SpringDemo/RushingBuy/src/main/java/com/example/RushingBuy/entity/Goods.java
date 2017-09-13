package com.example.RushingBuy.entity;

import org.springframework.data.jpa.domain.AbstractPersistable;

import javax.persistence.*;

@Entity
public class Goods extends AbstractPersistable<Long> {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;
    String name;
    int num;
    double price;

    public String getName() {
        return name;
    }

    public int getNum() {
        return num;
    }

    public double getPrice() {
        return price;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
