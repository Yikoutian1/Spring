package com.hang.spring.reflect;

import org.junit.jupiter.api.Test;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @ClassName TestReflect
 * @Description TODO
 * @Author QiuLiHang
 * @DATE 2023/9/8 008 11:00
 * @Version 1.0
 */

public class TestReflect {
    // 1. 获取class对象的多种方式
    @Test
    public void testGetClass() throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        // 1. 类名.class
        Class<Car> clazz1 = Car.class;
        // 2. 对象.getClass()
        Class<? extends Car> clazz2 = new Car().getClass();
        // 3. Class.forName("全路径")
        Class<?> clazz3 = Class.forName("com.hang.spring.reflect.Car");
        // 实例化 newInstance
        Car car = (Car) clazz3.getDeclaredConstructor().newInstance();
        System.out.println(car);
    }

    // 2. 获取构造方法
    @Test
    public void testGetConstructor() throws Exception {
        Class<Car> clazz = Car.class;
        // 获取所有构造
        // getDeclaredConstructors (获取private和public的)
        // getConstructors         (只能获取public的)
        Constructor<?>[] constructors = clazz.getDeclaredConstructors();
//        方法名称: com.hang.spring.reflect.Car,参数个数: 0
//        方法名称: com.hang.spring.reflect.Car,参数个数: 3
        for (Constructor<?> constructor : constructors) {
            System.out.println("方法名称: " + constructor.getName() + ",参数个数: " + constructor.getParameterCount());
        }

        // 指定有参数的构造创建对象
        // 1. 访问 构造public的
//        Constructor<Car> c1 =
//                clazz.getConstructor(String.class, int.class, String.class);
//        Car car1 = c1.newInstance("宝马", 10, "黑色");
//        System.out.println(car1);
        // Car{name='宝马', age=10, color='黑色'}
        // 2. 访问 构造private的
        Constructor<Car> c2 = clazz.getDeclaredConstructor(String.class, int.class, String.class);
        c2.setAccessible(true); // 访问私有构造
        Car car2 = c2.newInstance("奥迪", 20, "白色");
        System.out.println(car2);
        // Car{name='奥迪', age=20, color='白色'}
    }

    // 3. 获取属性 Field
    @Test
    public void testGetField() throws Exception {
        Class<Car> clazz = Car.class;
        Car car = clazz.getDeclaredConstructor().newInstance();
        // 获取所有public属性
//        Field[] fields = clazz.getFields();
        // 获取所有属性 (包括私有属性)
        Field[] declaredFields = clazz.getDeclaredFields();
        for (Field field : declaredFields) {
            // 设置name属性
            if ("name".equals(field.getName())) {
                // 设置允许访问
                field.setAccessible(true);
                field.set(car, "五菱");
            }
            System.out.println(car);
        }

    }

    // 4. 获取方法(public private)
    @Test
    public void testGetFunc() throws Exception {
        Class<Car> clazz = Car.class;
        Constructor<Car> c2 = clazz.getDeclaredConstructor(String.class, int.class, String.class);
        c2.setAccessible(true); // 访问私有构造
        Car car = c2.newInstance("测试", 8, "白色");
        // 1. public方法 拿不到private方法
        Method[] methods = clazz.getMethods();
        for (Method m1 : methods) {
//            System.out.println(m1.getName());
            // 执行方法 invoke
            if ("toString".equals(m1.getName())) {
                // invoke(传入对象) 执行 得到方法返回对象
                String invoke = (String) m1.invoke(car);
                System.out.println("toString方法:" + invoke);
                // toString方法:Car{name='测试', age=8, color='白色'}
            }
        }
        System.out.println("==================");
        // 2. private方法
        Method[] declaredMethods = clazz.getDeclaredMethods();
        for (Method m2 : declaredMethods) {
            // 执行private方法 run
            if("run".equals(m2.getName())){
                m2.setAccessible(true);
                // run方法没有返回结果
                m2.invoke(car);
                // 私有方法-run--
            }

        }
    }
}
