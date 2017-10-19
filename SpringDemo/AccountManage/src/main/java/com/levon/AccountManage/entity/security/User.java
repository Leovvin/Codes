package com.levon.AccountManage.entity.security;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Entity
@Table(name = "users")
public class User implements Serializable {
    @Id
    @GeneratedValue
    Long id;
    String name;
    String password;
    boolean enables;
    @ManyToMany(fetch=FetchType.EAGER)
    @JoinTable(name = "user_roles"
        ,joinColumns = {@JoinColumn(name = "user_id",referencedColumnName = "id")}
        ,inverseJoinColumns = {@JoinColumn(name = "role_id",referencedColumnName = "id")})
    Set<Role> roles;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }

    public boolean isEnables() {
        return enables;
    }

    public void setEnables(boolean enables) {
        this.enables = enables;
    }
}