package com.hang.spring.ioc.life;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

/**
 * @ClassName BeanPost
 * @Description 后置处理器
 * @Author QiuLiHang
 * @DATE 2023/9/7 007 19:56
 * @Version 1.0
 */

public class BeanPost implements BeanPostProcessor {
    /**
     * 后置处理器
     *
     * @param bean
     * @param beanName
     * @return
     * @throws BeansException
     */

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        System.out.println("3. bean后置处理器,初始化之前执行");
        System.out.println(beanName + "::" + bean);
        return bean;
    }

    /**
     * 前置处理器
     *
     * @param bean
     * @param beanName
     * @return
     * @throws BeansException
     */
    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        System.out.println("5. bean后置处理器,初始化之后执行");
        System.out.println(beanName + "::" + bean);
        return bean;
    }
}
