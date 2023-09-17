package com.hang.spring.bean;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.SourceLocation;
import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;
import java.util.*;

/**
 * @ClassName AopApplicationContext
 * @Description TODO
 * @Author QiuLiHang
 * @DATE 2023/9/16 016 18:50
 * @Version 1.0
 */

public class AopApplicationContext extends AnnotationConfigApplicationContext {
    public AopApplicationContext(Class<?> clazz) throws Exception {
        super(clazz);
        // 1. 扫描所有的组件,查找切类
        Map<String, AspectInfo> aspectInfoMap = new HashMap<>();
        for (Map.Entry<String, BeanInfo> entry : IOC.entrySet()) {
            String name = entry.getKey();
            BeanInfo beanInfo = entry.getValue();
            // 2.1 获取的beanInfo对象类是否是一个切面类
            Aspect aspect = beanInfo.bean.getClass().getAnnotation(Aspect.class);
            if (Objects.isNull(aspect)) {
                continue;
            }
            // 2.2 分析切面类, 1个切点:N个增强方法 => map
            Method[] declaredMethods = beanInfo.bean.getClass().getDeclaredMethods();
            for (Method method : declaredMethods) {
                String pointcutExp = null;
                Before before = method.getAnnotation(Before.class);
                if (Objects.nonNull(before)) {
                    pointcutExp = before.value();
                } else {
                    continue;
                }
                // 判断切点表达式是否引用了方法名切点 pointcut()
                if (pointcutExp.matches("\\w+\\(\\)")) {
                    String pointcutMethodName = pointcutExp.replaceAll("(\\w+)\\(\\)", "$1");
                    Method pointcutMethod = beanInfo.bean.getClass().getDeclaredMethod(pointcutMethodName);
                    pointcutExp = pointcutMethod.getAnnotation(Pointcut.class).value();
                }
                // 创建切点信息对象
                AspectInfo aspectInfo = aspectInfoMap.get(pointcutExp);
                if (Objects.isNull(aspectInfo)) {
                    aspectInfo = new AspectInfo();
                    aspectInfo.pointcutExp = pointcutExp;
                    // 将切面组件对象保存到info中
                    aspectInfo.aspectObject = beanInfo.bean;
                    aspectInfoMap.put(pointcutExp, aspectInfo);
                }
                // 添加该点的增强方法
                if (before != null) {
                    aspectInfo.befores.add(method);
                }
            }
        }
        // 打印
        aspectInfoMap.values().forEach(System.out::println);
        // 判断组件是否包含连接点的方法
        for (Map.Entry<String, BeanInfo> entry : IOC.entrySet()) {
            BeanInfo beanInfo = entry.getValue();
            Method[] declaredMethods = beanInfo.bean.getClass().getDeclaredMethods();
            for (Method method : declaredMethods) {
                // 方法签名字符串
                String methodString = method.toString();
                // 切点表达式判断
                boolean isProxy = false;
                for (String pointcutExp : aspectInfoMap.keySet()) {
                    // 切点表达式判断,转正则表达式
                    if (isAdvice(pointcutExp, methodString)) {
                        // 包含连接点方法
                        System.out.println("methodString = " + methodString);
                        isProxy = true;
                        break;
                    }
                }
                if (isProxy) {
                    // 进行动态代理 => Cglib
                    Enhancer enhancer = new Enhancer();
                    Object bean = beanInfo.bean;
                    enhancer.setSuperclass(bean.getClass());
                    enhancer.setCallback(new MethodInterceptor() {
                        @Override
                        public Object intercept(Object obj, Method method, Object[] args, MethodProxy methodProxy) throws Throwable {
                            try {
                                // 判断当前方法是否拦截(前置)
                                for (AspectInfo aspectInfo : aspectInfoMap.values()) {
                                    if (isAdvice(aspectInfo.pointcutExp, method.toString())) {
                                        for (Method before : aspectInfo.befores) {
                                            // 执行前置增强
                                            before.invoke(aspectInfo.aspectObject, new JoinPoint() {
                                                @Override
                                                public String toShortString() {
                                                    return null;
                                                }

                                                @Override
                                                public String toLongString() {
                                                    return null;
                                                }

                                                @Override
                                                public Object getThis() {
                                                    return null;
                                                }

                                                @Override
                                                public Object getTarget() {
                                                    return null;
                                                }

                                                @Override
                                                public Object[] getArgs() {
                                                    return new Object[0];
                                                }

                                                @Override
                                                public Signature getSignature() {
                                                    return null;
                                                }

                                                @Override
                                                public SourceLocation getSourceLocation() {
                                                    return null;
                                                }

                                                @Override
                                                public String getKind() {
                                                    return null;
                                                }

                                                @Override
                                                public StaticPart getStaticPart() {
                                                    return null;
                                                }
                                            });
                                        }
                                    }
                                }
                                Object invoke = methodProxy.invoke(bean, args);
                                for (AspectInfo aspectInfo : aspectInfoMap.values()) {
                                    if (isAdvice(aspectInfo.pointcutExp, method.toString())) {
                                        for (Method afterReturning : aspectInfo.afterReturnings) {
                                            // 执行返回增强
                                            afterReturning.invoke(aspectInfo.aspectObject, new JoinPoint() {
                                                @Override
                                                public String toShortString() {
                                                    return null;
                                                }

                                                @Override
                                                public String toLongString() {
                                                    return null;
                                                }

                                                @Override
                                                public Object getThis() {
                                                    return null;
                                                }

                                                @Override
                                                public Object getTarget() {
                                                    return null;
                                                }

                                                @Override
                                                public Object[] getArgs() {
                                                    return new Object[0];
                                                }

                                                @Override
                                                public Signature getSignature() {
                                                    return null;
                                                }

                                                @Override
                                                public SourceLocation getSourceLocation() {
                                                    return null;
                                                }

                                                @Override
                                                public String getKind() {
                                                    return null;
                                                }

                                                @Override
                                                public StaticPart getStaticPart() {
                                                    return null;
                                                }
                                            });
                                        }
                                    }
                                }
                                return invoke;
                            } catch (Throwable e) {
                                for (AspectInfo aspectInfo : aspectInfoMap.values()) {
                                    if (isAdvice(aspectInfo.pointcutExp, method.toString())) {
                                        for (Method afterThrowing : aspectInfo.afterThrowings) {
                                            // 执行返回增强
                                            afterThrowing.invoke(aspectInfo.aspectObject, new JoinPoint() {
                                                @Override
                                                public String toShortString() {
                                                    return null;
                                                }

                                                @Override
                                                public String toLongString() {
                                                    return null;
                                                }

                                                @Override
                                                public Object getThis() {
                                                    return null;
                                                }

                                                @Override
                                                public Object getTarget() {
                                                    return null;
                                                }

                                                @Override
                                                public Object[] getArgs() {
                                                    return new Object[0];
                                                }

                                                @Override
                                                public Signature getSignature() {
                                                    return null;
                                                }

                                                @Override
                                                public SourceLocation getSourceLocation() {
                                                    return null;
                                                }

                                                @Override
                                                public String getKind() {
                                                    return null;
                                                }

                                                @Override
                                                public StaticPart getStaticPart() {
                                                    return null;
                                                }
                                            });
                                        }
                                    }
                                }
                            } finally {
                                for (AspectInfo aspectInfo : aspectInfoMap.values()) {
                                    if (isAdvice(aspectInfo.pointcutExp, method.toString())) {
                                        for (Method after : aspectInfo.afters) {
                                            // 执行返回增强
                                            after.invoke(aspectInfo.aspectObject, new JoinPoint() {
                                                @Override
                                                public String toShortString() {
                                                    return null;
                                                }

                                                @Override
                                                public String toLongString() {
                                                    return null;
                                                }

                                                @Override
                                                public Object getThis() {
                                                    return null;
                                                }

                                                @Override
                                                public Object getTarget() {
                                                    return null;
                                                }

                                                @Override
                                                public Object[] getArgs() {
                                                    return new Object[0];
                                                }

                                                @Override
                                                public Signature getSignature() {
                                                    return null;
                                                }

                                                @Override
                                                public SourceLocation getSourceLocation() {
                                                    return null;
                                                }

                                                @Override
                                                public String getKind() {
                                                    return null;
                                                }

                                                @Override
                                                public StaticPart getStaticPart() {
                                                    return null;
                                                }
                                            });
                                        }
                                    }
                                }
                            }
                            return null;
                        }
                    });
                    // 生成代理对象
                    Object proxyBean = enhancer.create();
                    // 用代理替换原有的bean
                    beanInfo.bean = proxyBean;
                }
            }
        }
    }

    boolean isAdvice(String pointcutExp, String methodString) {
        String regExp = pointcutExp.replaceAll("\\.{2}", ".+");
        regExp = regExp.replaceAll("\\*", ".+")
                .replaceAll("execution\\((.+)\\)", "$1");
        return methodString.matches(regExp);
    }
}

// 切点信息对象
class AspectInfo {
    Object aspectObject; // 切点的组件对象
    String pointcutExp;
    List<Method> befores = new ArrayList<>();
    List<Method> afters = new ArrayList<>();
    List<Method> afterThrowings = new ArrayList<>();
    List<Method> afterReturnings = new ArrayList<>();
    List<Method> arounds = new ArrayList<>();

    @Override
    public String toString() {
        return "AspectInfo{" +
                "pointcutExp='" + pointcutExp + '\'' +
                ", befores=" + befores +
                ", afters=" + afters +
                ", afterThrowings=" + afterThrowings +
                ", afterReturnings=" + afterReturnings +
                ", arounds=" + arounds +
                '}';
    }
}
