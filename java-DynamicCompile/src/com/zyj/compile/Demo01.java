package com.zyj.compile;

import org.omg.SendingContext.RunTime;

import javax.tools.JavaCompiler;
import javax.tools.ToolProvider;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLClassLoader;

/**
 * 版权声明：CopyRight (c) 2018 ucarinc. All Rights Reserved.
 *
 * @author : 张勇杰
 * @date : 2018/11/26 14:58
 * @Version : v1.0
 * @description
 **/
@SuppressWarnings("all")
public class Demo01 {
    public static void main(String[] args) throws IOException {

        //通过IO流操作，将字符串存储成一个临时文件(Hi.java)，然后调用动态编译方法
        String str = "public class hi{public static void main(String[] args){System.out.println(\"hi world\");}}";


        JavaCompiler compiler = ToolProvider.getSystemJavaCompiler();
        int result = compiler.run(null,null,null,"C:/Users/张勇杰/Desktop/helloworld.java");
        System.out.println(result == 0?"编译成功":"编译失败");

        //通过Runtime调用执行类
        /*Runtime run = Runtime.getRuntime();

        Process process = run.exec("java -cp C:/Users/张勇杰/Desktop/   helloworld");

        InputStream in = process.getInputStream();
        BufferedReader reader = new BufferedReader(new InputStreamReader(in));
        String info="";
        while((info=reader.readLine())!=null){
            System.out.println(info);
        }*/

        try{
            URL[] urls = new URL[]{new URL("file:/"+"C:/Users/张勇杰/Desktop/")};
            URLClassLoader loader = new URLClassLoader(urls);
            Class c = loader.loadClass("helloworld");
            //调用加载类的main方法
            //参数一定要强转成object，由于可变参数是java5.0以后才有，会造成参数不匹配的问题
            c.getMethod("main",String[].class).invoke(null,(Object) new String[]{});
        }catch (Exception e){
            e.printStackTrace();

        }
    }
}
