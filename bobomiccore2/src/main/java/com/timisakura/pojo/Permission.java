package com.timisakura.pojo;

public class Permission {
    private Integer id;

    private String name;

    private String resource;

    public Permission(Integer id, String name, String resource) {
        this.id = id;
        this.name = name;
        this.resource = resource;
    }

    public Permission() {
        super();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getResource() {
        return resource;
    }

    public void setResource(String resource) {
        this.resource = resource == null ? null : resource.trim();
    }
}