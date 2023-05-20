package com.itheima.pojo;

public class Course {

    private int id  ;
    private String name;
    private int hour;
    private int sid ;
    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getHour() {
        return hour;
    }

    public int getSid() {
        return sid;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setHour(int hour) {
        this.hour = hour;
    }

    public void setSid(int sid) {
        this.sid = sid;
    }

    @Override
    public String toString() {
        return "course{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", hour=" + hour +
                ", sid=" + sid +
                '}';
    }
}
