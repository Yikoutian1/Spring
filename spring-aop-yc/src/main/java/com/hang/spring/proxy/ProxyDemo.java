package com.hang.spring.proxy;

/**
 * @ClassName Proxy
 * @Description 代理模式
 * @Author QiuLiHang
 * @DATE 2023/9/13 013 20:18
 * @Version 1.0
 */

public class ProxyDemo {
    public static void main(String[] args) {
        Person p1 = new Defendant();
        Lvshi lvshi = new Lvshi();
        lvshi.proxy(p1);
        lvshi.say();
    }
}

// 静态代理 => 律师(代理主题)  被告(真实主题)
// 接口: Person
interface Person {
    void say();
}

/**
 * 被告
 */
class Defendant implements Person {

    @Override
    public void say() {
        System.out.println("我是被告");
    }
}

/**
 * 律师
 */
class Lvshi implements Person {
    private Person person;

    @Override
    public void say() {
        System.out.println("当事人不在场");
        person.say();
        System.out.println("我是律师,我来辩护");
    }

    public void proxy(Person person) {
        this.person = person;
    }
}