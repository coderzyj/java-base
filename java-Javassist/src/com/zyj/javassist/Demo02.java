package com.zyj.javassist;

import javassist.*;

import java.io.IOException;
import java.lang.reflect.Method;
import java.text.MessageFormat;
import java.util.Arrays;

/**
 * 版权声明：CopyRight (c) 2018 ucarinc. All Rights Reserved.
 *
 * @author : 张勇杰
 * @date : 2018/12/1 14:04
 * @Version : v1.0
 * @description 测试javassist的API
 **/
public class Demo02 {
    /**
     * 处理类的基本用法
     */
    public static void test01() throws IOException, CannotCompileException, NotFoundException {
        ClassPool pool = ClassPool.getDefault();
        CtClass cc = pool.get("com.zyj.javassist.Emp");

        byte[] bytes = cc.toBytecode();
        System.out.println(Arrays.toString(bytes));

        System.out.println(cc.getName());//获得类名
        System.out.println(cc.getSimpleName());//获得简要类名
        System.out.println(cc.getSuperclass());//获得父类
        System.out.println(cc.getInterfaces());//获得接口
    }

    /**
     * 测试产生新的方法
     */
    public static void test02() throws Exception {
        ClassPool pool = ClassPool.getDefault();
        CtClass cc = pool.get("com.zyj.javassist.Emp");
        //CtMethod m = CtNewMethod.make("public int add(int a,int b){return a+b}",cc);

        CtMethod m = new CtMethod(CtClass.intType,"add",new CtClass[]{CtClass.intType,CtClass.intType},cc);
        m.setModifiers(Modifier.PUBLIC);
        m.setBody("{return $1+$2;}");
        cc.addMethod(m);

        //通过反射调用新生成的方法
        Class clazz = cc.toClass();
        Object obj = clazz.newInstance();//通过调用mp无参构造器，创建新的Emp对象
        Method method = clazz.getDeclaredMethod("add",int.class,int.class);
        Object o = method.invoke(obj, 1, 1);
        System.out.println(o);

    }


    public static void test03()throws Exception{
       ClassPool pool = ClassPool.getDefault();
       CtClass cc = pool.get("com.zyj.javassist.Emp");

       CtMethod cm = cc.getDeclaredMethod("sayHello",new CtClass[]{CtClass.intType});
        cm.insertBefore("System.out.println($1);System.out.println(\"start!!!\");");

        //通过反射调用新生成的方法
        Class clazz = cc.toClass();
        Object obj = clazz.newInstance();
        Method m = clazz.getDeclaredMethod("sayHello",int.class);
        Object result = m.invoke(obj, 1111);
        System.out.println(result);

    }
    public static void main(String[] args) throws Exception {
        test03();
    }
}
