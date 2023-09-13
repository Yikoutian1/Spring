package com.hang.spring.proxy;

import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;
import org.springframework.cglib.proxy.Proxy;

import java.lang.reflect.Method;

/**
 * @ClassName CglibProxy
 * @Description TODO
 * @Author QiuLiHang
 * @DATE 2023/9/13 013 20:31
 * @Version 1.0
 */
@SuppressWarnings("all")

// Cglib 动态字节码技术,基于继承实现
public class CglibProxy {
    public static <T> T proxy(T t) {
        Enhancer enhancer = new Enhancer();
        // 设置父类 把传过来的类 实现一遍
        enhancer.setSuperclass(t.getClass());
        // 设置回调 方法拦截对象
        enhancer.setCallback(new MethodInterceptor() {
            @Override
            public Object intercept(Object obj, Method method, Object[] args, MethodProxy methodProxy) throws Throwable {
                Object invoke = methodProxy.invoke(t, args);
                return invoke;
            }
        });
        return (T) enhancer.create();
    }
}
