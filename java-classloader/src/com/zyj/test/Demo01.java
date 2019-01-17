package com.zyj.test;

/**
 * 版权声明：CopyRight (c) 2018 ucarinc. All Rights Reserved.
 *
 * @author : 张勇杰
 * @date : 2018/12/3 16:16
 * @Version : v1.0
 * @description
 **/
public class Demo01 {
    public static void main(String[] args) {
        System.out.println(ClassLoader.getSystemClassLoader());
        System.out.println(ClassLoader.getSystemClassLoader().getParent());
        System.out.println(ClassLoader.getSystemClassLoader().getParent().getParent());

        System.out.println(System.getProperty("java.class" + ".path"));
        String a = "zyj";
        System.out.println(a.getClass().getClassLoader());

    }
}
