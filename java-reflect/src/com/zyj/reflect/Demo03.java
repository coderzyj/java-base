package com.zyj.reflect;

import com.zyj.bean.User;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.text.SimpleDateFormat;

/**
 * 版权声明：CopyRight (c) 2018 ucarinc. All Rights Reserved.
 *
 * @author : 张勇杰
 * @date : 2018/11/11 22:58
 * @Version : v1.0
 * @description 通过反射api动态操作：构造器，方法，属性。
 **/
public class Demo03 {
    public static void main(String[] args) throws IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException, NoSuchFieldException {
        String path = "com.zyj.bean.User";
        try {
            Class clazz = Class.forName(path);
            //通过反射API动态调用构造方法，构造对象,其实是调用无参构造器
            User user = (User) clazz.newInstance();
            System.out.println(user);

            Constructor<User> c = clazz.getDeclaredConstructor(int.class,int.class,String.class);
            User u2 = c.newInstance(1001,18,"张勇杰");
            System.out.println(u2.getName());

            //通过反射api调用普通方法
            User u3 = (User) clazz.newInstance();
            Method setName = clazz.getDeclaredMethod("setName", String.class);//u3.setName("张勇杰2");
            setName.invoke(u3,"张勇杰2");//反射的好处：动态调用
            System.out.println( u3.getName() );

            User u4 = (User) clazz.newInstance();
            Field field = clazz.getDeclaredField("name");
            field.setAccessible(true);
            field.set(u4,"张勇杰3");
            System.out.println(u4.getName());
            //通过反射API操作属性
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
