package com.hang.spring.aop.example;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Arrays;

/**
 * @ClassName ProxyFactory
 * @Description 日志统一管理
 * @Author QiuLiHang
 * @DATE 2023/9/8 008 19:31
 * @Version 1.0
 */

public class ProxyFactory {
    // 目标对象
    private Object target;

    public ProxyFactory(Object target) {
        this.target = target;
    }

    // 创建一个方法 返回代理对象(动态代理)
    public Object getProxy() {
        /**
         * Proxy.newProxyInstance()方法
         * 有三个参数:
         * 1. ClassLoader: 加载动态生成代理类的类加载器
         * 2. Class[] interfaces: 所有实现接口的class类型的数组结构
         * 3.InvocationHandler: 设置代理对象实现目标对象方法的过程
         */
        // 1. ClassLoader: 加载动态生成代理类的类加载器
        ClassLoader classLoader = target.getClass().getClassLoader();
        // 2. Class[] interfaces: 所有实现接口的class类型的数组结构
        Class<?>[] interfaces = target.getClass().getInterfaces();
        // 3.InvocationHandler: 设置代理对象实现目标对象方法的过程(实现invoke方法)
        InvocationHandler invocationHandler = new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, // 代理对象
                                 Method method,// 代理对象需要实现的方法(重写)
                                 Object[] args // 对应方法的参数(调用method方法的)
            ) throws Throwable {
                // 调用目标的方法(调用)
                Object result = null;
                // 在调用执行目标方法前后执行动态输出日志增强
                try {
                    System.out.println("[动态代理][日志] " + method.getName() + "，参数：" + Arrays.toString(args));
                    result = method.invoke(target, args);
                    System.out.println("[动态代理][日志] " + method.getName() + "，结果：" + result);
                } catch (Exception e) {
                    e.printStackTrace();
                    System.out.println("[动态代理][日志] " + method.getName() + "，异常：" + e.getMessage());
                } finally {
                    System.out.println("[动态代理][日志] " + method.getName() + "，方法执行完毕");
                }
                return result;
            }
        };
        return Proxy.newProxyInstance(classLoader, interfaces, invocationHandler);
    }
}
