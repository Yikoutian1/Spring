package com.hang.spring.main;

import com.hang.spring.config.SpringAopConfig;
import com.hang.spring.function.FunctionAspect;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;

/**
 * @ClassName Main
 * @Description TODO
 * @Author QiuLiHang
 * @DATE 2023/9/13 013 19:22
 * @Version 1.0
 */
@Controller
public class Main {
    public static void main(String[] args) {
        ApplicationContext context =
                new AnnotationConfigApplicationContext(SpringAopConfig.class);
        FunctionAspect bean = context.getBean(FunctionAspect.class);
        bean.add(1,2);
        System.out.println(bean);
    }
}
