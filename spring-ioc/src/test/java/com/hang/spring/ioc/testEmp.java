package com.hang.spring.ioc;

import com.hang.spring.ioc.injection.Dept;
import com.hang.spring.ioc.injection.Employee;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @ClassName testEmp
 * @Description TODO
 * @Author QiuLiHang
 * @DATE 2023/9/7 007 10:12
 * @Version 1.0
 */

public class testEmp {
    /**
     * 集合赋值(内部bean)
     */
    @Test
    public void testList() {
        ApplicationContext context =
                new ClassPathXmlApplicationContext("inject-list.xml");
        Dept dept = context.getBean("dept1", Dept.class);
        dept.info();
        // TODO 成功注入: console如下
        //部门名称：集合属性注入 部门
//        Name:name1(内部bean),Age:18
//        Name:name2(内部bean),Age:18
//        Name:name3(内部bean),Age:18
    }
    /**
     * 集合赋值(外部bean)
     */
    @Test
    public void testList2() {
        ApplicationContext context =
                new ClassPathXmlApplicationContext("inject-list.xml");
        Dept dept = context.getBean("dept2", Dept.class);
        dept.info();
        // TODO 成功注入: console如下
        //部门名称：集合属性注入 部门
//        Name:name4(外部bean),Age:18
//        Name:name5(外部bean),Age:18
//        Name:name6(外部bean),Age:18
    }
    /**
     * 数组赋值
     */
    @Test
    public void testEmp4() {
        ApplicationContext context =
                new ClassPathXmlApplicationContext("inject-list.xml");
        // 员工对象
        Employee employee = context.getBean("emp", Employee.class);
        employee.work();
        // TODO 成功注入: console如下
        // 数组正在工作,年龄为:18
        // 部门名称：部门
        // [吃饭, 睡觉, 打游戏]
    }

    /**
     * 外部bean
     */
    @Test
    public void testEmp() {
        ApplicationContext context =
                new ClassPathXmlApplicationContext("inject-property.xml");
        // 员工对象
        Employee employee = context.getBean("employee", Employee.class);
        employee.work();
        // TODO 成功注入: console如下
        // 普通属性注入正在工作,年龄为:18
        // 部门名称：引入外部bean 部门
    }

    /**
     * 内部bean
     */
    @Test
    public void testEmp2() {
        ApplicationContext context =
                new ClassPathXmlApplicationContext("inject-property.xml");
        // 员工对象
        Employee employee = context.getBean("employee2", Employee.class);
        employee.work();
        // TODO 成功注入: console如下
        // 普通属性注入正在工作,年龄为:18
        // 部门名称：内部bean注入 部门
    }

    /**
     * 级联赋值
     */
    @Test
    public void testEmp3() {
        ApplicationContext context =
                new ClassPathXmlApplicationContext("inject-property.xml");
        // 员工对象
        Employee employee = context.getBean("employee3", Employee.class);
        employee.work();
        // TODO 成功注入: console如下
        // 普通属性注入正在工作,年龄为:18
        // 部门名称：这是级联赋值后的值
    }
}
