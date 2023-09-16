package com.hang.spring.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

/**
 * @ClassName mySspect
 * @Description TODO
 * @Author QiuLiHang
 * @DATE 2023/9/13 013 18:57
 * @Version 1.0
 */
@Aspect // 切面类 = 切点 + 增强
@Component
public class MyAspect {
    @Pointcut(value = "execution(* com.hang.spring.function.FunctionAspect.*(..))")
    public void pointCut() {

    }

    // 前置增强
    @Before(value = "pointCut()")
    public void before(JoinPoint joinPoint) {
        Signature signature = joinPoint.getSignature();// 获取签名
        System.out.println("signature = " + signature);
        Object[] args = joinPoint.getArgs();// 获取参数列表
        System.out.println("args = " + args);
    }

    // 后置增强
    @After(value = "pointCut()")
    public void after() {
        System.out.println("after");
    }

    // 返回前增强
    @AfterReturning(value = "pointCut()", returning = "ret")
    public void afterReturning(JoinPoint joinPoint, Object ret) {
        System.out.println(ret + " after return");
    }

    // 异常增强
    @AfterThrowing(value = "pointCut()", throwing = "throwss")
    public void afterThrowing(JoinPoint joinPoint, Throwable throwss) {
        System.out.println("throwss: " + throwss);
    }

    /**
     * 环绕增强和普通增强不同
     * 1. 连接点对象不同,业务方法需要手动执行
     * 2. 增强方法的返回值,就是业务方法的返回值
     *
     * @param proceedingJoinPoint
     * @result 模拟性能监控业务处理
     */
    @Around(value = "pointCut()")
    public Object around(ProceedingJoinPoint proceedingJoinPoint) {
        Object ret = null;
        try {
//            before(proceedingJoinPoint);
            System.out.println("===around===");
            long time = System.currentTimeMillis();
            ret = proceedingJoinPoint.proceed();
            System.out.printf("共耗时: %d", System.currentTimeMillis() - time);
//            afterReturning(proceedingJoinPoint,ret);
        } catch (Throwable e) {
//            afterThrowing(proceedingJoinPoint, e);
        } finally {
//            after();
        }
        return ret;
    }


}
