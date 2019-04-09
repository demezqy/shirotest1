package com.timisakura.pojo;

public class Department {
    private Integer id;

    private String sn;

    private String name;

    private Integer managerId;

    private Integer parentId;

    private Boolean state;

    public Department(Integer id, String sn, String name, Integer managerId, Integer parentId, Boolean state) {
        this.id = id;
        this.sn = sn;
        this.name = name;
        this.managerId = managerId;
        this.parentId = parentId;
        this.state = state;
    }

    public Department() {
        super();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getSn() {
        return sn;
    }

    public void setSn(String sn) {
        this.sn = sn == null ? null : sn.trim();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public Integer getManagerId() {
        return managerId;
    }

    public void setManagerId(Integer managerId) {
        this.managerId = managerId;
    }

    public Integer getParentId() {
        return parentId;
    }

    public void setParentId(Integer parentId) {
        this.parentId = parentId;
    }

    public Boolean getState() {
        return state;
    }

    public void setState(Boolean state) {
        this.state = state;
    }

    @Override
    public String toString() {
        return "Department{" +
                "id=" + id +
                ", sn='" + sn + '\'' +
                ", name='" + name + '\'' +
                ", managerId=" + managerId +
                ", parentId=" + parentId +
                ", state=" + state +
                '}';
    }
}