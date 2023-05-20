package com.itheima.pojo;

public class School {
    private int id;
    private String schoolname;

    public int getId() {
        return id;
    }

    public String getSchoolname() {
        return schoolname;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setSchoolname(String schoolname) {
        this.schoolname = schoolname;
    }

    @Override
    public String toString() {
        return "school{" +
                "id=" + id +
                ", schoolname='" + schoolname + '\'' +
                '}';
    }
}

