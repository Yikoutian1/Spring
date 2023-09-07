package com.hang.spring.ioc.injection;

/**
 * @ClassName Book
 * @Description TODO
 * @Author QiuLiHang
 * @DATE 2023/9/6 006 20:59
 * @Version 1.0
 */

public class Book {
    private String bname;
    private String author;


    public Book() {
    }

    public String getBname() {
        return bname;
    }

    public void setBname(String bname) {
        this.bname = bname;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    @Override
    public String toString() {
        return "Book{" +
                "bname='" + bname + '\'' +
                ", author='" + author + '\'' +
                '}';
    }

    public Book(String bname, String author) {
        this.bname = bname;
        this.author = author;
    }
}
