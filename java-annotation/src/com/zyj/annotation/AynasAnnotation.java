package com.zyj.annotation;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;

/**
 * 版权声明：CopyRight (c) 2018 ucarinc. All Rights Reserved.
 *
 * @author : 张勇杰
 * @date : 2018/11/10 17:38
 * @Version : v1.0
 * @description 使用反射读取注解的信息，模拟处理注解信息的流程
 **/
public class AynasAnnotation {
    public static void main(String[] args) {
        try {
            Class clazz = Class.forName("com.zyj.annotation.Student");
            //获得类所有有效注解
            Annotation[] annotations = clazz.getAnnotations();
            for(Annotation a : annotations){
                /*ZyjTable zyjTable = (ZyjTable)a;
                System.out.println(zyjTable.value());*/
                System.out.println(a);
            }
            //获得类制定的注解
            ZyjTable zyjTable = (ZyjTable) clazz.getAnnotation(ZyjTable.class);
            System.out.println(zyjTable.value());
            Field[] fields = clazz.getDeclaredFields();
            for(Field f:fields){
                ZyjField zyjField = f.getAnnotation(ZyjField.class);
                System.out.println(zyjField.columnName()+"--"+zyjField.type()+"--"+zyjField.length());
            }
            //根据获得的表明，字段信息，拼出DDL语句，然后，使用JDBC执行这个SQL，在数据库种生成相关的表
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
