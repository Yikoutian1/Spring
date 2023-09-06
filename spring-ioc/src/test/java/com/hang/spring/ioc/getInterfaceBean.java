package com.hang.spring.ioc;

import com.hang.spring.ioc.bean.UserDao;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @ClassName getBeanByImpl
 * @Description 通过接口获取实现类
 * @Author QiuLiHang
 * @DATE 2023/9/6 006 20:40
 * @Version 1.0
 */

public class getInterfaceBean {
    /**
     * 根据类型获取接口对应的bean
     */
    @Test
    public void getTypeGetImplBean(){
        ApplicationContext context =
                new ClassPathXmlApplicationContext("bean.xml");
        // 根据类型获取接口对应的bean
        // TODO:注意 如果是接口,建议通过id找bean,因为如果多继承,则会找到多个
        // TODO:接口实现类bean唯一才能使用 类映射
        // UserDao user = context.getBean(UserDao.class);
        UserDao user = (UserDao) context.getBean("userDao");
        // 像这种获取就不会出问题
        UserDao user2 = (UserDao) context.getBean("userDao2");
        user.run();
        user2.run();
        System.out.println("获取接口实现类结束");
    }
}
