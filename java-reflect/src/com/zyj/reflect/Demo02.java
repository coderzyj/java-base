package com.zyj.reflect;

import com.zyj.bean.User;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * 版权声明：CopyRight (c) 2018 ucarinc. All Rights Reserved.
 *
 * @author : 张勇杰
 * @date : 2018/11/11 22:14
 * @Version : v1.0
 * @description 获取类的属性，方法，构造器
 **/
public class Demo02 {
    public static void main(String[] args) throws NoSuchFieldException, NoSuchMethodException {
        String path = "com.zyj.bean.User";
        try {
            Class clazz = Class.forName(path);
            //获取类的名字
            System.out.println(clazz.getName());//获取包名+类名：com.zyj.bean
            System.out.println(clazz.getSimpleName()); //获取类名：User
            //获取属性信息
            //Field[] fields = clazz.getFields();//此方法只能获得public的field
            //System.out.println(fields.length);
            Field[] declaredFields = clazz.getDeclaredFields();//获得所有Field
            System.out.println(declaredFields.length);
            Field name = clazz.getDeclaredField("name");
            System.out.println(name);
            for(Field f:declaredFields){
                System.out.println(f);
            }
           /* Method method = clazz.getMethod("getName");
            System.out.println(method);
            //获取方法信息
            Method[] methods = clazz.getDeclaredMethods();
            for(Method m:methods){
                System.out.println(m);
            }*/
            Method setUname = clazz.getMethod("setName",String.class);
            //获得构造器信息
            Constructor[] declaredConstructors = clazz.getDeclaredConstructors();
            for(Constructor temp:declaredConstructors){
                System.out.println("构造器"+temp);
            }
            Constructor a = clazz.getDeclaredConstructor(int.class,int.class,String.class);
            System.out.println("获得的构造器"+a);
            System.out.println(setUname);
            User user = (User)clazz.newInstance();
            setUname.invoke(user,"zyj");
            Method getUname = clazz.getMethod("getName");
            System.out.println("666"+getUname.invoke(user));
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
    }

}
