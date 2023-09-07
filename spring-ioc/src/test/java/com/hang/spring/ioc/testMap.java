package com.hang.spring.ioc;

import com.hang.spring.ioc.map.Lesson;
import com.hang.spring.ioc.map.Student;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @ClassName testMap
 * @Description TODO
 * @Author QiuLiHang
 * @DATE 2023/9/7 007 11:11
 * @Version 1.0
 */

public class testMap {
    @Test
    public void testMap() {
        ApplicationContext context =
                new ClassPathXmlApplicationContext("inject-map.xml");
        Student stu = context.getBean("stu", Student.class);
        stu.run();
        // TODO 控制台如下
//        学生的编号:1,学生的名字:map注入 学生bean
//        {
//            1=Teacher{
//                tid='1', tname='老师1'
//            },
//            2=Teacher{
//                tid='2', tname='老师2'
//            }
//        }
    }


    /**
     * P命名空间注入
     * p:xxx=""
     */
    @Test
    public void testPSpace() {
        ApplicationContext context =
                new ClassPathXmlApplicationContext("inject-util-list-map.xml");
        Student stu = context.getBean("studentP", Student.class);
        stu.run();
        // TODO 控制台如下
//        学生的编号:100,学生的名字:pName
//        {1=Teacher{tid='1', tname='普通注入属性(老师1)'}, 2=Teacher{tid='2', tname='普通注入属性(老师2)'}}
//[Lesson{lessonName='spring'}, Lesson{lessonName='spring'}]
    }

    /**
     * 测试使用util:map  util:list标签
     */
    @Test
    public void testUtilMap() {
        ApplicationContext context =
                new ClassPathXmlApplicationContext("inject-util-list-map.xml");
        Student stu = context.getBean("student", Student.class);
        stu.run();
        // TODO 控制台如下
//        学生的编号:1,学生的名字:普通注入属性(学生)
//        {
//            1=Teacher{
//                tid='1', tname='普通注入属性(老师1)'
//            },
//            2=Teacher{
//                tid='2', tname='普通注入属性(老师2)'
//            }
//        }
//        [
//                Lesson
//                {
//                     lessonName='spring'
//                },
//                Lesson
//                {
//                     lessonName='spring'
//                 }
//        ]
    }
}
