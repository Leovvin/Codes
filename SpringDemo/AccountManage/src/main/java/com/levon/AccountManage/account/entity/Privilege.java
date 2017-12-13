package com.levon.AccountManage.account.entity;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "privileges")
public class Privilege {
    @Id
    long id;
    int type;
    String description;

    @ManyToMany(fetch= FetchType.LAZY)
    @JoinTable(name = "page_privileges"
        ,joinColumns = {@JoinColumn(name = "privilege_id",referencedColumnName = "id")}
        ,inverseJoinColumns = {@JoinColumn(name = "page_id",referencedColumnName = "id")})
    Set<Page> pages;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
