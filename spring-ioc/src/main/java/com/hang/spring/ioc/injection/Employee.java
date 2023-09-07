package com.hang.spring.ioc.injection;

/**
 * @ClassName Employee
 * @Description 员工类
 * @Author QiuLiHang
 * @DATE 2023/9/7 007 9:42
 * @Version 1.0
 */

public class Employee {


    // 员工属于某个部门
    private Dept dept;
    private String eName;
    private Integer age;

    public void work() {
        System.out.println(eName + "正在工作" + ",年龄为:" + age);
        dept.info();
    }


    public Employee() {
    }

    public Employee(Dept dept, String eName, Integer age) {
        this.dept = dept;
        this.eName = eName;
        this.age = age;
    }

    public Dept getDept() {
        return dept;
    }

    public void setDept(Dept dept) {
        this.dept = dept;
    }

    public String geteName() {
        return eName;
    }

    public void seteName(String eName) {
        this.eName = eName;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }


}
