package com.hang.spring.bean;

import com.hang.spring.anotation.autowired;
import com.hang.spring.anotation.qualifier;
import com.hang.spring.config.IocConfig;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;


import java.io.File;
import java.io.UnsupportedEncodingException;
import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.net.URL;
import java.net.URLDecoder;
import java.util.*;
import java.util.List;

/**
 * @ClassName AnnotationConfigApplicationContext
 * @Description TODO
 * @Author QiuLiHang
 * @DATE 2023/9/11 011 18:54
 * @Version 1.0
 */
public class AnnotationConfigApplicationContext {
    private Class configClass;
    private Object config;
    // protected 子类可以访问
    protected Map<String, BeanInfo> IOC = new HashMap<>();

    public AnnotationConfigApplicationContext(Class<?> clazz) throws Exception {
        this.configClass = clazz;
        Annotation annotation = clazz.getAnnotation(Configuration.class);
        if (annotation == null) {
            throw new RuntimeException("不是spring的配置类" + annotation);
        }
        this.config = clazz.newInstance();
        // 构建 bean 对象
        createBeanByBeanMethod();

        // 包扫描 (组件)
        List<File> componentFile = scanComponent();

        // 根据字节码文件创建对象
        createBeanByClassFile(componentFile);

        // 根据Autowired 自动装载
        createBeanByAutowired(componentFile);


    }

    private void createBeanByAutowired(List<File> componentFile) throws Exception {
        // 获取根目录
        URL url = getClass().getClassLoader().getResource("");
        String filePath = url.toString().substring("file:/".length());
        filePath = URLDecoder.decode(filePath, "utf-8");
        File rootFile = new File(filePath);

        // 变量字节码文件
        for (File component : componentFile) {
            String classpath = component.getAbsolutePath().substring(rootFile.getAbsolutePath().length());
            classpath = classpath.replace(".class", "")
                    .replaceAll("\\\\", ".")
                    .substring(1); // 去掉第一个 . 号
            Class<?> aClass = Class.forName(classpath);
            Field[] fields = aClass.getDeclaredFields();
            // 创建bean
            BeanInfo bi = new BeanInfo();
            // 拿到属性
            for (Field field : fields) {
                // 强制访问
                field.setAccessible(true);
                // 如果有autowired注解
                if (field.getAnnotation(autowired.class) != null) {
                    String name = null;
                    // 如果有 qualifier 注解
                    if (field.getAnnotation(qualifier.class) != null) {
                        // 属性类型
                        Class<?> type = field.getType();
                        name = field.getAnnotation(qualifier.class).value();
                        // 如果不包含该key
                        if (!IOC.containsKey(name)) {
                            bi.bean = type.getConstructor().newInstance();
//                        System.out.println("name = " + name);
                            IOC.put(name, bi);
                        }
                    }
                    // 没有 指定qualifier注解
                    else {
                        // 属性类型
                        Class<?> type = field.getType();
                        // autowired 根据类型注入 （根据类型：User->user）
                        // 获取类对象名
                        String simpleName = type.getSimpleName();
                        // 首字母小写
                        name = simpleName.substring(0, 1)
                                .toLowerCase() + simpleName.substring(1);
                        // System.out.println("IOC.containsKey(type) = " + IOC.containsKey(name));
                        // 如果不包含该key
                        if (!IOC.containsKey(name)) {
                            bi.bean = type.getConstructor().newInstance();
//                        System.out.println("name = " + name);
                            IOC.put(name, bi);
                        }
                        // 否则包含就不需要处理了
                    }
                }
            }
        }
    }

    private void createBeanByClassFile(List<File> componentFiles) throws Exception {
        // 获取根目录
        URL url = getClass().getClassLoader().getResource("");
        String filePath = url.toString().substring("file:/".length());
        filePath = URLDecoder.decode(filePath, "utf-8");
        File rootFile = new File(filePath);

        // 变量字节码文件
        for (File componentFile : componentFiles) {
            String classpath = componentFile.getAbsolutePath().substring(rootFile.getAbsolutePath().length());
            classpath = classpath.replace(".class", "")
                    .replaceAll("\\\\", ".")
                    .substring(1); // 去掉第一个 . 号
            Class<?> aClass = Class.forName(classpath);
            // 判断是否是组件
            if (aClass.getAnnotation(Service.class) != null
                    || aClass.getAnnotation(Repository.class) != null
                    || aClass.getAnnotation(Controller.class) != null
                    || aClass.getAnnotation(Component.class) != null) {
                // 创建bean
                BeanInfo bi = new BeanInfo();
                // 获取name
                Service service = aClass.getAnnotation(Service.class);
                Repository repository = aClass.getAnnotation(Repository.class);
                Controller controller = aClass.getAnnotation(Controller.class);
                Component component = aClass.getAnnotation(Component.class);
                if (service != null) {
                    if (service.value().length() > 0) {
                        IOC.put(service.value(), bi);
                    }
                } else if (repository != null) {
                    if (repository.value().length() > 0) {
                        IOC.put(repository.value(), bi);
                    }
                } else if (controller != null) {
                    if (controller.value().length() > 0) {
                        IOC.put(controller.value(), bi);
                    }
                } else if (component != null) {
                    if (component.value().length() > 0) {
                        IOC.put(component.value(), bi);
                    }
                } else {
                    // 类名
                    String simpleName = aClass.getSimpleName();
                    // 首字母小写
                    String name = simpleName.substring(0, 1)
                            .toLowerCase() + simpleName.substring(1);
                    IOC.put(name, bi);
                }
            }
        }
    }

    private Object getBean(String name) {
        BeanInfo bi = (BeanInfo) IOC.get(name);
        if (bi.bean == null) {
            throw new RuntimeException("没有bean" + name);
        }
        return bi.bean;
    }

    public <T> T getBean(Class<T> cls) {
        Collection<BeanInfo> values = IOC.values();
        List<BeanInfo> list = new ArrayList<>();
        // 查找符合的bean
        for (BeanInfo value : values) {
            if (value.bean.getClass().equals(cls)) {
                list.add(value);
            }
        }
        if (list.isEmpty()) {
            throw new RuntimeException("没有bean" + cls);
        } else if (list.size() == 1) {
            return (T) list.get(0).bean;
        } else {
            Object primaryBean = null;
            for (BeanInfo beanInfo : list) {
                if (beanInfo.isPrimary) {
                    primaryBean = beanInfo.bean;
                }
            }
            if (primaryBean == null) {
                throw new RuntimeException("该容器包含多个" + cls);
            } else {
                return (T) primaryBean;
            }
        }
    }

    private BeanInfo buildBeanInfo(Class<?> aClass) throws InstantiationException, IllegalAccessException {
        boolean isPrimay = aClass.getAnnotation(Primary.class) != null;
        BeanInfo beanInfo = new BeanInfo();
        beanInfo.isPrimary = isPrimay;
        if (!aClass.isInterface()) {
            beanInfo.bean = aClass.newInstance();
            return beanInfo;
        }
        // TODO 扩展其他属性
        return null;
    }

    // 包扫描 => 扫描组件
    private List<File> scanComponent() throws Exception {
        List<File> ret = new ArrayList<>();
        ComponentScan componentScan = (ComponentScan) configClass.getAnnotation(ComponentScan.class);
        if (componentScan == null) {
            return Collections.EMPTY_LIST;
        } else {
            String[] packages = componentScan.value();
            ClassLoader classLoader = getClass().getClassLoader();
            for (String aPackage : packages) {
                String path = aPackage.replaceAll("\\.", "/");
                URL url = classLoader.getResource(path);
                String filePath = url.toString().substring("file:/".length());
                scanComponent(filePath, ret);
            }
        }
        return ret;
    }

    private void scanComponent(String filePath, List<File> list) throws UnsupportedEncodingException {
        filePath = URLDecoder.decode(filePath, "utf-8");
        File dir = new File(filePath);
        for (File file : dir.listFiles()) {
            if (file.isFile() && file.getName().endsWith(".class")) {
                list.add(file);
            } else if (file.isDirectory()) {
                scanComponent(file.getAbsolutePath(), list);
            } else {
                // 新建的文件对象
                //file.createNewFile();
                //file.mkdirs()
            }
        }
    }

    private void createBeanByBeanMethod() throws Exception {
        Method[] declaredMethods = configClass.getDeclaredMethods();
        for (Method declaredMethod : declaredMethods) {
            Bean beanAnnotation = declaredMethod.getAnnotation(Bean.class);
            if (beanAnnotation == null) {
                // 改方法没有bean注解
            } else {
                // 反射执行方法
                // 强制访问
                declaredMethod.setAccessible(true);
                // 创建bean
                Object invoke = declaredMethod.invoke(config);
                // 获取 bean 的 name
                String[] names;
                if (beanAnnotation.value().length == 0) {
                    names = new String[]{
                            declaredMethod.getName()
                    };
                } else {
                    names = beanAnnotation.value();
                }
                for (String name : names) {
                    BeanInfo bi = new BeanInfo();
                    bi.bean = invoke;
                    bi.isPrimary = declaredMethod.getAnnotation(Primary.class) != null;
                    IOC.put(name, bi);
                }
            }

        }
    }

    public static void main(String[] args) throws Exception {
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(IocConfig.class);
        context.IOC.forEach((name, bean) -> {
            System.out.printf("IOC beans:%s %s \n", name, bean);
        });
//        System.out.println("context.IOC = " + context.IOC);
    }

    class BeanInfo {
        Object bean;
        boolean isPrimary;
        boolean isLazy;
        Class<?> BeanClass;
        String scope = "singleton"; // prototype
    }
}
