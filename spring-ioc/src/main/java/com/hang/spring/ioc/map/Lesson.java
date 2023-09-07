package com.hang.spring.ioc.map;

/**
 * @ClassName Lesson
 * @Description 课程
 * @Author QiuLiHang
 * @DATE 2023/9/7 007 11:20
 * @Version 1.0
 */

public class Lesson {
    private String lessonName;

    @Override
    public String toString() {
        return "Lesson{" +
                "lessonName='" + lessonName + '\'' +
                '}';
    }

    public String getLessonName() {
        return lessonName;
    }

    public void setLessonName(String lessonName) {
        this.lessonName = lessonName;
    }
}
