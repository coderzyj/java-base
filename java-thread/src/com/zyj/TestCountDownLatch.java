package com.zyj;

import java.util.concurrent.CountDownLatch;

/**
 * 版权声明：CopyRight (c) 2018 ucarinc. All Rights Reserved.
 *
 * @author : 张勇杰
 * @date : 2019/3/12 15:22
 * @Version : v1.0
 * @description
 **/
public class TestCountDownLatch {
    public static void main(String[] args) throws InterruptedException {
        CountDownLatch countDownLatch = new CountDownLatch(2);
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("线程"+Thread.currentThread().getName()+"启动");

                for(int i = 0;i< 10;i++){
                    System.out.println("线程"+Thread.currentThread().getName()+"循环第"+i+"次");
                }
                /*try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }*/
                countDownLatch.countDown();
            }
        }).start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("线程"+Thread.currentThread().getName()+"启动");

                for(int i = 0;i< 10;i++){
                    System.out.println("线程"+Thread.currentThread().getName()+"循环第"+i+"次");
                }
                /*try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }*/
                countDownLatch.countDown();
            }
        }).start();
//        System.out.println("666");
        countDownLatch.await();
        for(int i = 0;i< 10;i++){
            System.out.println("线程"+Thread.currentThread().getName()+"循环第"+i+"次");
        }
    }
}
