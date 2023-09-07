package com.hang.spring.ioc.map;

/**
 * @ClassName Teacher
 * @Description TODO
 * @Author QiuLiHang
 * @DATE 2023/9/7 007 11:03
 * @Version 1.0
 */

public class Teacher {
    private String tid;
    private String tname;


    public Teacher() {
    }

    public String getTid() {
        return tid;
    }

    public void setTid(String tid) {
        this.tid = tid;
    }

    public String getTname() {
        return tname;
    }

    public void setTname(String tname) {
        this.tname = tname;
    }

    @Override
    public String toString() {
        return "Teacher{" +
                "tid='" + tid + '\'' +
                ", tname='" + tname + '\'' +
                '}';
    }

    public Teacher(String tid, String tname) {
        this.tid = tid;
        this.tname = tname;
    }
}
