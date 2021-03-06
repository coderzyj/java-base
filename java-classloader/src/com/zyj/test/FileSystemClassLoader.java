package com.zyj.test;

import java.io.*;

/**
 * 版权声明：CopyRight (c) 2018 ucarinc. All Rights Reserved.
 *
 * @author : 张勇杰
 * @date : 2018/12/6 14:47
 * @Version : v1.0
 * @description
 **/
public class FileSystemClassLoader extends ClassLoader {
    //d:/myjava/com/zyj/test/User.class  -->com.zyj.test.User
    private String rootDir;

    public FileSystemClassLoader(String rootDir){
        this.rootDir = rootDir;
    }

    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {
        Class<?> c = findLoadedClass(name);

        //应该先查询有没有加载过这个类，如果已经加载，则返回已经加载好的类。如果没有，则加载新的类
        if(c != null){
            return c;
        }else{
            ClassLoader parent = this.getParent();
            System.out.println(parent);
            //委派给父类加载
            try {
                c = parent.loadClass(name);
            }catch (Exception e){

            }

            if(c != null){
                return c;
            }else{
                byte[] classData = getClassData(name);
                if(classData == null){
                    throw new ClassNotFoundException();
                }else{
                    c = defineClass(name,classData,0,classData.length);
                }
            }
        }
        return c;
    }

    private byte[] getClassData(String className){
        String path = rootDir + "/"+className.replace(".","/")+".class";

        //IOUtils,可以使用他将流中的数据转成字节数组
        InputStream is = null;
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        try {
            is = new FileInputStream(path);
            byte[] buffer = new byte[1024];
            int temp = 0;
            while((temp = is.read(buffer))!= -1){
                baos.write(buffer,0,temp);
            }
            return baos.toByteArray();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }finally {
            if(is != null){
                try {
                    is.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (baos != null) {

                try {
                    baos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
