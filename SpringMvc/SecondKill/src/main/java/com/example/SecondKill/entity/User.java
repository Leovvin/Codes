package com.example.SecondKill.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class User {
    @Id
    long id;
    String name;

    public String getName() {
        return name;
    }
}
