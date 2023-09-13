package com.hang.spring.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @ClassName JdkProxy
 * @Description TODO
 * @Author QiuLiHang
 * @DATE 2023/9/13 013 20:26
 * @Version 1.0
 */
@SuppressWarnings("all")
// Jdk动态代理 基于接口实现
public class JdkProxy {
    public static <T> T proxy(T t) {
        return (T) Proxy.newProxyInstance(
                t.getClass().getClassLoader()
                , t.getClass().getInterfaces(),
                new InvocationHandler() {
                    @Override
                    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                        // t对象 调用对象
                        Object invoke = method.invoke(t, args);
                        return invoke;
                    }
                });
    }
}
