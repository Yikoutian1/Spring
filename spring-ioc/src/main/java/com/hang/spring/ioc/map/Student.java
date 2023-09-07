package com.hang.spring.ioc.map;

import java.util.List;
import java.util.Map;

/**
 * @ClassName Student
 * @Description TODO
 * @Author QiuLiHang
 * @DATE 2023/9/7 007 11:02
 * @Version 1.0
 */

public class Student {
    // list
    private List<Lesson> list;
    // 一个学生对应多个老师map
    private Map<String, Teacher> map;

    public List<Lesson> getList() {
        return list;
    }

    public void setList(List<Lesson> list) {
        this.list = list;
    }

    private String sid;
    private String sName;


    public void run() {
        System.out.println("学生的编号:" + sid + ",学生的名字:" + sName);
        System.out.println(map);
        System.out.println(list);
    }

    public String getSid() {
        return sid;
    }

    public Student() {
    }

    public Student(String sid, String sName) {
        this.sid = sid;
        this.sName = sName;
    }

    @Override
    public String toString() {
        return "Student{" +
                "map=" + map +
                ", sid='" + sid + '\'' +
                ", sName='" + sName + '\'' +
                '}';
    }

    public void setSid(String sid) {
        this.sid = sid;
    }

    public String getsName() {
        return sName;
    }

    public void setsName(String sName) {
        this.sName = sName;
    }

    public Map<String, Teacher> getMap() {
        return map;
    }

    public void setMap(Map<String, Teacher> map) {
        this.map = map;
    }
}
