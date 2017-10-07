package com.levon.AccountManage.entity;


import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "user_roles")
public class UserRole implements Serializable {
    @Id
    long id;
    long userId;
    long roleId;
    @ManyToOne
    @JoinColumn(name = "userId")
    User user;
    @ManyToOne
    @JoinColumn(name = "roleId")
    Role role;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public long getRoleId() {
        return roleId;
    }

    public void setRoleId(long roleId) {
        this.roleId = roleId;
    }
}
