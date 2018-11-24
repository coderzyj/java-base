package com.zyj.reflect;

/**
 * 版权声明：CopyRight (c) 2018 ucarinc. All Rights Reserved.
 *
 * @author : 张勇杰
 * @date : 2018/11/10 18:03
 * @Version : v1.0
 * @description 测试各种类型（class，interface，enum，annotation，primitive type，void）对应的java.lang.Class的获取方式
 **/
@SuppressWarnings("all")
public class Demo01 {
    public static void main(String[] args) {
        String path = "com.zyj.bean.User";
        try {
            Class clazz = Class.forName(path);
            //对象是表示或封装一些数据，一个类被加载后，JVM会创建一个对应该类的Class对象，类的则很难哥哥结构信息会放到对应的Class对象中
            //这个Class对象就像一面镜子一样，通过这面镜子我可以看到对应类的全部信息
            System.out.println(clazz.hashCode());

            Class clazz2 = Class.forName(path);
            System.out.println(clazz2.hashCode());
            Class strClazz = String.class;
            Class strClazz2 = path.getClass();
            System.out.println(strClazz == strClazz2);

            int [] arr01 = new int[10];
            int [] arr02 = new int[30];
            int [][] arr03 = new int[30][3];
            System.out.println(arr01.getClass().hashCode() == arr02.getClass().hashCode());
            System.out.println(arr01.getClass().hashCode());
            System.out.println(arr02.getClass().hashCode());
            System.out.println(arr03.getClass().hashCode());
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
