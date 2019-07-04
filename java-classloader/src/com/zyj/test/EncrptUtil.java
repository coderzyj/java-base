package com.zyj.test;

import java.io.*;

/**
 * 版权声明：CopyRight (c) 2018 ucarinc. All Rights Reserved.
 *
 * @author : 张勇杰
 * @date : 2018/12/14 15:01
 * @Version : v1.0
 * @description 加密工具类
 **/
public class EncrptUtil {
    public static void main(String[] args) {
        encrpt(new File("d://myjava/HelloWorld.class"),new File("d://myjava/temp/HelloWorld.class"));
    }
    public static void encrpt(File src,File dest){
        FileInputStream fis = null;
        FileOutputStream fos = null;
        try {
            fis = new FileInputStream(src);
            fos = new FileOutputStream(dest);
            int temp = -1;
            while((temp = fis.read())!=-1){
                fos.write(temp^0xff);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
           try {
                if(fos!= null){
                fos.close();
            }
            } catch (IOException e) {
                e.printStackTrace();

            }

        }
    }
}
