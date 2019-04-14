package com.timisakura.pojo;

public class UseridPermissionid {
    private Integer id;

    private Integer userId;

    private Integer permissionId;

    public UseridPermissionid(Integer id, Integer userId, Integer permissionId) {
        this.id = id;
        this.userId = userId;
        this.permissionId = permissionId;
    }

    public UseridPermissionid() {
        super();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getPermissionId() {
        return permissionId;
    }

    public void setPermissionId(Integer permissionId) {
        this.permissionId = permissionId;
    }
}