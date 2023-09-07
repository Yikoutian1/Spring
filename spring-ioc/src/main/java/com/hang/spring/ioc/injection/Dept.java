package com.hang.spring.ioc.injection;

import java.util.List;

/**
 * @ClassName Dept
 * @Description 部门类
 * @Author QiuLiHang
 * @DATE 2023/9/7 007 9:43
 * @Version 1.0
 */

public class Dept {

    private String dName;
    // 部门有多个员工
    private List<Employee> employee;

    public void info() {
        System.out.println("部门名称：" + dName);
    }




    public String getdName() {
        return dName;
    }

    public Dept() {
    }

    public Dept(String dName, List<Employee> employee) {
        this.dName = dName;
        this.employee = employee;
    }

    public void setdName(String dName) {
        this.dName = dName;
    }

    public List<Employee> getEmployee() {
        return employee;
    }

    public void setEmployee(List<Employee> employee) {
        this.employee = employee;
    }
}
