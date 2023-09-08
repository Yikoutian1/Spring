package com.hang.spring.reflect;

/**
 * @ClassName Car
 * @Description TODO
 * @Author QiuLiHang
 * @DATE 2023/9/8 008 10:47
 * @Version 1.0
 */

public class Car {
    // 属性
    private String name;
    // 使用年龄
    private int age;

    private String color;
    // 普通方法 (测试强制访问)
    private void run() {
        System.out.println("私有方法-run-- ");
    }

    // 构造器
    public Car() {
    }

    private Car(String name, int age, String color) {
        this.name = name;
        this.age = age;
        this.color = color;
    }

    // get set方法
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
    @Override
    public String toString() {
        return "Car{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", color='" + color + '\'' +
                '}';
    }
}
