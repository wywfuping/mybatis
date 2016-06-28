package com.yawei.pojo;


public class Subject {
    private Integer id;
    private Integer majorid;
    private String name;
    private Integer classhour;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getMajorid() {
        return majorid;
    }

    public void setMajorid(Integer majorid) {
        this.majorid = majorid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getClasshour() {
        return classhour;
    }

    public void setClasshour(Integer classhour) {
        this.classhour = classhour;
    }

    @Override
    public String toString() {
        return "Subject{" +
                "id=" + id +
                ", majorid=" + majorid +
                ", name='" + name + '\'' +
                ", classhour=" + classhour +
                '}';
    }
}
