package com.zyj.javassist;

import javassist.*;

import java.io.IOException;
import java.lang.reflect.Field;
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

    /**
     * 修改已有方法的信息
     * @throws Exception
     */
    public static void test03()throws Exception{
       ClassPool pool = ClassPool.getDefault();
       CtClass cc = pool.get("com.zyj.javassist.Emp");

       CtMethod cm = cc.getDeclaredMethod("sayHello",new CtClass[]{CtClass.intType});
        cm.insertBefore("System.out.println($1);System.out.println(\"start!!!\");");
        cm.insertAfter("System.out.println(\"end!!!!!!\");");
    //在某一行前面加上代码
        cm.insertAt(27,"empno = \"19191\";");
        //通过反射调用新生成的方法
        Class clazz = cc.toClass();
        Object obj = clazz.newInstance();
        Method m = clazz.getDeclaredMethod("sayHello",int.class);
        m.invoke(obj, 1111);
        Method m2 = clazz.getDeclaredMethod("getEmpno",null);
        Object o = m2.invoke(obj);
        System.out.println(o);
    }

    public static void test04()throws Exception{
        ClassPool pool = ClassPool.getDefault();
        CtClass cc = pool.get("com.zyj.javassist.Emp");

        //CtField f1 = CtField.make("private int no;",cc);

          CtField f1 = new CtField(CtClass.intType,"salary",cc);
          f1.setModifiers(Modifier.PRIVATE);
          cc.addField(f1);
            //获取指定的属性
            cc.getDeclaredField("salary");
            //增加相应的get和set方法
          /*cc.addMethod(CtNewMethod.getter("getSalary",f1));   //不可行，原因未知
          cc.addMethod(CtNewMethod.getter("setSalary",f1));*/
            //第一张方法：：这样可行
          /*cc.addMethod(CtNewMethod.make("public void setSalary(int salary){this.salary = salary;}",cc));
          cc.addMethod(CtNewMethod.make("public int getSalary(){return this.salary;}",cc));*/

          //第二种方法：亲测可行
        CtMethod setSalary = new CtMethod(CtClass.voidType, "setSalary", new CtClass[]{CtClass.intType}, cc);
        setSalary.setBody("this.salary = salary;");
        setSalary.setModifiers(Modifier.PUBLIC);
        CtMethod getSalary = new CtMethod(CtClass.intType, "getSalary", null, cc);
        getSalary.setBody("return salary;");
        getSalary.setModifiers(Modifier.PRIVATE);
        cc.addMethod(setSalary);
          cc.addMethod(getSalary);
          Class clazz = cc.toClass();
          Object obj = clazz.newInstance();
          Field field = clazz.getDeclaredField("salary");
          System.out.println(field.getName());
          Method setter = clazz.getDeclaredMethod("setSalary",int.class);
          setter.invoke(obj,3000);
          Method getter = clazz.getDeclaredMethod("getSalary");
          getter.setAccessible(true);
          Object re = getter.invoke(obj);
        System.out.println("salary:::"+re);
    }

    /**
     * 操作注解
     * @throws Exception
     */
    public static void test06() throws  Exception{
        CtClass cc = ClassPool.getDefault().get("com.zyj.javassist.Emp");
        Object annotation = cc.getAnnotation(Author.class);
        Author author = (Author) annotation;
        System.out.println("name:"+author.name()+",year:"+author.year());
    }

    /**
     * g构造器
     * @throws Exception
     */
    public static void test05()throws Exception{
        ClassPool pool = ClassPool.getDefault();
        CtClass cc = pool.get("com.zyj.javassist.Emp");
        CtConstructor[] cs = cc.getConstructors();
        for(CtConstructor c:cs){
            System.out.println(c.getLongName());
            //c.insertBeforeBody();
        }

    }
    public static void main(String[] args) throws Exception {
        test06();
    }
}
