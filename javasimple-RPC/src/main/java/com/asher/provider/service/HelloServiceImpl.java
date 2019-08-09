package com.asher.provider.service;

/**
 * @author : 张勇杰
 * @date : 2019/8/9 11:17
 * @Version : v1.0
 * @description
 **/
public class HelloServiceImpl implements HelloService{
    public void sayHello(String name) {
        System.out.println("hello"+name);
    }
}
