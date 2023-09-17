package com.hang.spring.entity;



/**
 * (Spring)表实体类
 *
 * @author makejava
 * @since 2023-09-09 18:59:50
 */

public class Spring {

    private Integer id;

    //姓名
    private String name;
    //年龄
    private Integer age;


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
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    //性别
    private String sex;


    @Override
    public String toString() {
        return "Spring{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", sex='" + sex + '\'' +
                '}';
    }
}

