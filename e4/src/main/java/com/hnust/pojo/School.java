package com.hnust.pojo;

public class School {
    private Integer  id;
    private String  schoolname;

    public School() {
    }

    public School(Integer id, String schoolname) {
        this.id = id;
        this.schoolname = schoolname;
    }

    /**
     * 获取
     * @return id
     */
    public Integer getId() {
        return id;
    }

    /**
     * 设置
     * @param id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 获取
     * @return schoolname
     */
    public String getSchoolname() {
        return schoolname;
    }

    /**
     * 设置
     * @param schoolname
     */
    public void setSchoolname(String schoolname) {
        this.schoolname = schoolname;
    }

    public String toString() {
        return "School{id = " + id + ", schoolname = " + schoolname + "}";
    }
}
