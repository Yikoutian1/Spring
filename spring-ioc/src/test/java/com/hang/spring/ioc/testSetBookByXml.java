package com.hang.spring.ioc;

import com.hang.spring.ioc.injection.Book;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @ClassName testSetBookByXml
 * @Description TODO
 * @Author QiuLiHang
 * @DATE 2023/9/6 006 21:07
 * @Version 1.0
 */

public class testSetBookByXml {
    /**
     * 通过set方法注入
     */
    @Test
    public void testSetter(){
        ApplicationContext context =
                new ClassPathXmlApplicationContext("inject-set-construct.xml");
        Book bean = context.getBean("book",Book.class);
        System.out.println("bean = " + bean);
        System.out.println("====通过Set已经注入成功===");
    }
    /**
     * 通过构造器注入
     */
    @Test
    public void testConstruct(){
        ApplicationContext context =
                new ClassPathXmlApplicationContext("inject-set-construct.xml");
        // TODO: 此时一个实例有多个映射, 我们通过类和id映射,确保唯一
        Book bean = context.getBean("bookCon",Book.class);
        System.out.println("bean = " + bean);
        System.out.println("====通过构造器已经注入成功===");
    }
}
