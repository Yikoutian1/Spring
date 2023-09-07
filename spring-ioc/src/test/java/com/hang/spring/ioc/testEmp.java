package com.hang.spring.ioc;

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
     * 外部bean
     */
    @Test
    public void testEmp(){
        ApplicationContext context =
                new ClassPathXmlApplicationContext("inject-list.xml");
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
    public void testEmp2(){
        ApplicationContext context =
                new ClassPathXmlApplicationContext("inject-list.xml");
        // 员工对象
        Employee employee = context.getBean("employee2", Employee.class);
        employee.work();
        // TODO 成功注入: console如下
        // 普通属性注入正在工作,年龄为:18
        // 部门名称：内部bean注入 部门
    }
}
