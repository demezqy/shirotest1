package com.timisakura.pojo;

import java.util.Date;

public class Employee {
    private Integer id;

    private String username;

    private String realname;

    private String password;

    private String tel;

    private String email;

    private Integer deptId;

    private Date inputtime;

    private Boolean state;

    private Boolean admin;

    public Employee(Integer id, String username, String realname, String password, String tel, String email, Integer deptId, Date inputtime, Boolean state, Boolean admin) {
        this.id = id;
        this.username = username;
        this.realname = realname;
        this.password = password;
        this.tel = tel;
        this.email = email;
        this.deptId = deptId;
        this.inputtime = inputtime;
        this.state = state;
        this.admin = admin;
    }

    public Employee() {
        super();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username == null ? null : username.trim();
    }

    public String getRealname() {
        return realname;
    }

    public void setRealname(String realname) {
        this.realname = realname == null ? null : realname.trim();
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel == null ? null : tel.trim();
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email == null ? null : email.trim();
    }

    public Integer getDeptId() {
        return deptId;
    }

    public void setDeptId(Integer deptId) {
        this.deptId = deptId;
    }

    public Date getInputtime() {
        return inputtime;
    }

    public void setInputtime(Date inputtime) {
        this.inputtime = inputtime;
    }

    public Boolean getState() {
        return state;
    }

    public void setState(Boolean state) {
        this.state = state;
    }

    public Boolean getAdmin() {
        return admin;
    }

    public void setAdmin(Boolean admin) {
        this.admin = admin;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", realname='" + realname + '\'' +
                ", password='" + password + '\'' +
                ", tel='" + tel + '\'' +
                ", email='" + email + '\'' +
                ", deptId=" + deptId +
                ", inputtime=" + inputtime +
                ", state=" + state +
                ", admin=" + admin +
                '}';
    }
}