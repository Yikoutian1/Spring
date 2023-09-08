package com.hang.spring.bean;

/**
 * 模拟 spring ApplicationContext
 */
public interface ApplicationContext {
    Object getBean(Class clazz);
}
