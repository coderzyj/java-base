package com.zyj.test;

/**
 * 版权声明：CopyRight (c) 2018 ucarinc. All Rights Reserved.
 *
 * @author : 张勇杰
 * @date : 2018/12/6 15:08
 * @Version : v1.0
 * @description
 **/
public class Demo02 {
    public static void main(String[] args) throws ClassNotFoundException {
        FileSystemClassLoader loader = new FileSystemClassLoader("d:/myjava");
        FileSystemClassLoader loader1 = new FileSystemClassLoader("d:/myjava");
        Class<?> c = loader.loadClass("com.zyj.test.HelloWorld");
        Class<?> c1 = loader.loadClass("com.zyj.test.HelloWorld");
        Class<?> c2 = loader1.loadClass("com.zyj.test.HelloWorld");
        Class c3 = loader.loadClass("java.lang.String");
        System.out.println(c.hashCode());
        System.out.println(c1.hashCode());
        System.out.println(c2.hashCode());
        System.out.println(c3.hashCode());
        //JVM认为被同一个加载器加载的同一个类是相同的类
    }
}
