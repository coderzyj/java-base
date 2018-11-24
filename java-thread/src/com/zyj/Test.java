package com.zyj;

/**
 * 版权声明：CopyRight (c) 2018 ucarinc. All Rights Reserved.
 *
 * @author : 张勇杰
 * @date : 2018/11/17 21:18
 * @Version : v1.0
 * @description
 **/
public class Test implements Runnable{
    @Override
    public void run() {
        for(int i =0 ;i<50;i++){
            System.out.println(Thread.currentThread().getName()+"第"+i+"个");

        }
    }

    public static void main(String[] args) throws InterruptedException {
        Test test = new Test();
        Thread t1 = new Thread(test,"zhangyongjie");
       // Thread t2 = new Thread(test, "zhangyongjie111");
        t1.start();
        //t2.start();
        for(int i = 0;i<50;i++){
            if(i==10){
                t1.join();
            }
            System.out.println(Thread.currentThread().getName()+"第"+i+"个");
        }

    }
}
