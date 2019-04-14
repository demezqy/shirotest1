package com.timisakura.pojo;

import java.util.List;

public class User {
    private Integer userid;

    private String name;

    private String password;
    private List<Permission> permissions;

    public List<Permission> getPermissions() {
        return permissions;
    }

    @Override
    public String toString() {
        return "User{" +
                "userid=" + userid +
                ", name='" + name + '\'' +
                ", password='" + password + '\'' +
                ", permissions=" + permissions +
                '}';
    }

    public void setPermissions(List<Permission> permissions) {
        this.permissions = permissions;
    }

    public User(Integer userid, String name, String password) {
        this.userid = userid;
        this.name = name;
        this.password = password;
    }

    public User() {
        super();
    }

    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password == null ? null : password.trim(); }
}
