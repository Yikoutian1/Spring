package com.hang.spring.aop.annoaop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

import java.util.Arrays;

/**
 * @ClassName LogAspect
 * @Description 切面类
 * @Author QiuLiHang
 * @DATE 2023/9/8 008 20:57
 * @Version 1.0
 */
@Aspect    // 切面类
@Component // ioc容器
public class LogAspect {
    // 设置切入点和通知类型
    // 通知类型: 五种
    // 前置  @Before(value="切入点表达式配置切入点")
    // 切入点表达式:(其中例如方法名 参数列表可以用 * 表示任意代替,  . 代表一个)
    // execution(访问修饰符 增强方法返回类型 增强方法所在类型的全类名 方法名(参数列表))
    @Before(value = "execution(* com.hang.spring.aop.annoaop.CalculatorImpl.*(..))")
    public void beforeMethod(JoinPoint joinPoint) {
        String methodName = joinPoint.getSignature().getName();
        String args = Arrays.toString(joinPoint.getArgs());
        System.out.println("Logger-->前置通知，方法名：" + methodName + "，参数：" + args);
    }

    // 后置  @After()
    @After(value = "execution(* com.hang.spring.aop.annoaop.CalculatorImpl.*(..))")
    public void afterMethod(JoinPoint joinPoint) {
        // 增强方法的名称
        String methodName = joinPoint.getSignature().getName();
        System.out.println("Logger-->后置通知,方法名称: " + methodName);
    }

    // 返回  @AfterReturning()   -> 参数有一个returning接收
    @AfterReturning(value = "execution(* com.hang.spring.aop.annoaop.CalculatorImpl.*(..))", returning = "result")
    public void afterReturning(JoinPoint joinPoint, Object result) {
        String methodName = joinPoint.getSignature().getName();
        System.out.println("Logger-->返回通知,方法名称: " + methodName + ",结果为:" + result);
    }

    // 异常  @AfterThrowing()  -> throwing
    @AfterThrowing(value = "execution(* com.hang.spring.aop.annoaop.CalculatorImpl.*(..))", throwing = "exception")
    public void afterThrowing(JoinPoint joinPoint, Throwable exception) {
        String methodName = joinPoint.getSignature().getName();
        System.out.println("Logger-->异常,方法名称: " + methodName + ",异常信息为:" + exception);
    }

    // 环绕  @Around()
    @Around(value = "execution(* com.hang.spring.aop.annoaop.CalculatorImpl.*(..))")
    public Object aroundMethod(ProceedingJoinPoint joinPoint) {
        String methodName = joinPoint.getSignature().getName();
        String args = Arrays.toString(joinPoint.getArgs());
        Object result = null;
        try {
            System.out.println("环绕通知-->目标对象方法执行之前");
            //目标方法的执行，目标方法的返回值一定要返回给外界调用者
            result = joinPoint.proceed();
            System.out.println("环绕通知-->目标对象方法返回值之后, 返回值:" + result);
        } catch (Throwable throwable) {
            throwable.printStackTrace();
            System.out.println("环绕通知-->目标对象方法出现异常时");
        } finally {
            System.out.println("环绕通知-->目标对象方法执行完毕");
        }
        return result;
    }

}
