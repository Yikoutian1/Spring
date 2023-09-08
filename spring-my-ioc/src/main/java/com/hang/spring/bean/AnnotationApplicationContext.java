package com.hang.spring.bean;

import com.hang.spring.annotation.Bean;
import com.hang.spring.annotation.Di;

import java.io.File;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.net.URL;
import java.net.URLDecoder;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/**
 * @ClassName AnnotationApplicationContext
 * @Description 返回bean
 * @Author QiuLiHang
 * @DATE 2023/9/8 008 14:38
 * @Version 1.0
 */

public class AnnotationApplicationContext implements ApplicationContext {
    // 创建一个map集合,放bean对象  bean容器
    private Map<Class, Object> beanFactory = new HashMap<>();
    private static String rootPath;


    /**
     * 返回创建对象
     *
     * @param clazz 类对象
     * @return
     */
    @Override
    public Object getBean(Class clazz) {
        return beanFactory.get(clazz);
    }
    // 创建有参数构造,传递包路径,设置包的扫描规则
    // 当前包和子包,那个类有@Bean注解,把这个类通过反射实例化

    /**
     * 包扫描
     *
     * @param basePackage 包路径
     */
    public AnnotationApplicationContext(String basePackage) throws UnsupportedEncodingException, ClassNotFoundException, InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {
        // com.hang.spring
        // 1. 把.替换成/
        String packagePath = basePackage.replaceAll("\\.", "\\\\");
        // 2. 获取包的绝对路径 Thread.currentThread()当前线程  getContextClassLoader类加载器
        URL resource = Thread.currentThread().getContextClassLoader().getResource(packagePath);
        String filePath = URLDecoder.decode(resource.getFile(), "utf-8");
        // 获取包前面的路径部分,字符串截取 (前面部分)
        rootPath = filePath.substring(0, filePath.length() - packagePath.length());
        // 包扫描
        loadBean(new File(filePath));
        // 属性注入
        loadDi();
    }


    /**
     * 包扫描过程,实例化
     *
     * @param file
     */
    private void loadBean(File file) throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        // 1. 判断当前是否是文件夹
        if (file.isDirectory()) {
            // 2. 获取文件夹里面所有内容
            File[] childrenFiles = file.listFiles();
            // 3. 判断文件夹里面为空,直接返回
            if (childrenFiles == null || childrenFiles.length == 0) {
                return;
            }
            // 4. 如果文件夹不为空,遍历文件夹所有内容
            for (File child : childrenFiles) {
                // 4.1 遍历得到每一个File对象,继续判断,如果还是一个文件夹,继续递归
                if (child.isDirectory()) {
                    // 递归
                    loadBean(child);
                } else {
                    // 4.2 遍历得到File对象不是文件夹,是文件
                    // 4.3 得到包路径+类名称部分
                    String pathWithClass =
                            child.getAbsolutePath().substring(rootPath.length() - 1);
                    // 4.4 判断当前文件夹类型是否.class
                    if (pathWithClass.contains(".class")) {
                        // 4.5 如果是.class类型,把路径\替换成.  把.class去掉
                        // com.hang.spring.service.UserServiceImpl
                        String allName = pathWithClass.replaceAll("\\\\", ".")
                                .replace(".class", "");
                        // 4.6 判断类扫描是否有注解 @Bean,如果有实例化过程
                        // 4.6.1 获取类的class对象
                        Class<?> clazz = Class.forName(allName);
                        // 4.6.2 判断不是接口,才进行实例化
                        if (!clazz.isInterface()) {
                            Bean bean = clazz.getAnnotation(Bean.class);
                            // 4.6.3 判断是否有注解 @Bean
                            if (bean != null) {
                                // 4.6.4 实例化
                                Object instance = clazz.getDeclaredConstructor().newInstance();
                                // 4.7 把对象实例化后,放到map集合beanFactory
                                // 4.7.1 判断当前类 如果有接口,让接口class作为map的key
                                if (clazz.getInterfaces().length > 0) {// 有接口
                                    beanFactory.put(clazz.getInterfaces()[0], instance);
                                } else {
                                    beanFactory.put(clazz, instance);
                                }
                            }
                        }
                    }
                }
            }
        }
    }

    /**
     * 属性注入
     */
    private void loadDi() throws IllegalAccessException {
        // 从beanFactory里面取,实例化对象
        // 1. 遍历beanFactory map集合
        Set<Map.Entry<Class, Object>> entrySet = beanFactory.entrySet();
        for (Map.Entry<Class, Object> entry : entrySet) {
            // 2. 得到map集合每个对象(value),每个对象属性都获取到
            Object value = entry.getValue();
            Class<?> aClass = value.getClass();
            Field[] fields = aClass.getDeclaredFields();
            // 3. 遍历得到的每个对象属性的数组,得到每个属性
            for (Field field : fields) {
                // 4. 判断属性上面是否有@Di的注解
                if (field.getAnnotation(Di.class) != null) {
                    // 5. 如果有@Di注解,把对象设置(注入)
                    // 有可能是私有的,需要设置一些
                    field.setAccessible(true);
                    field.set(value, beanFactory.get(field.getType()));
                }
            }
        }
    }
}

