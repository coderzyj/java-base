package com.asher.proxy;

import sun.misc.ProxyGenerator;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * 版权声明：CopyRight (c) 2018 ucarinc. All Rights Reserved.
 *
 * @author : 张勇杰
 * @date : 2019/1/17 20:59
 * @Version : v1.0
 * @description  动态代理
 **/
public class ProxyStudent implements InvocationHandler {
    private Object target;

    public Object getProxyInstance(Object t){
        this.target = t;
        return Proxy.newProxyInstance(this.target.getClass().getClassLoader(),new Class[]{Student.class},this);
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        byte[] bytes = ProxyGenerator.generateProxyClass("$proxy0", new Class[]{Student.class});
        File file = new File(this.getClass().getResource("").getPath()+File.separator+proxy.getClass().getSimpleName()+".class");
        FileOutputStream fos = new FileOutputStream(file);
        fos.write(bytes);
        fos.flush();
        /*if(!file.exists()){
           file.createNewFile();
        }
        FileOutputStream fos = new FileOutputStream(file);
        FileInputStream fis = new FileInputStream(file);
        int len = 0;
        byte[] buff = new byte[1024];
        while((len=fis.read(buff))!=-1){
            fos.write(buff,0,len);
        }
        fis.close();
        fos.close();*/
        System.out.println("大炮揍了小明一顿");
        method.invoke(this.target,args);
        System.out.println("大炮再次打了小明一顿");
        return null;
    }
}
