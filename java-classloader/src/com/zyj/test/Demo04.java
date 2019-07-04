package com.zyj.test;

/**
 * 版权声明：CopyRight (c) 2018 ucarinc. All Rights Reserved.
 *
 * @author : 张勇杰
 * @date : 2018/12/14 14:54
 * @Version : v1.0
 * @description
 **/
public class Demo04 {
    public static void main(String[] args) throws ClassNotFoundException {
        //int a = 3;
        //异或操作，。
       // System.out.println(Integer.toBinaryString(a^0xff));
        FileSystemClassLoader loader = new FileSystemClassLoader("d:/myjava/temp");
        Class<?> c = loader.loadClass("HelloWorld");
        System.out.println(c);
    }
}
