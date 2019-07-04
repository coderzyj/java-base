package com.zyj;

import java.util.concurrent.CyclicBarrier;

/**
 * 版权声明：CopyRight (c) 2018 ucarinc. All Rights Reserved.
 *
 * @author : 张勇杰
 * @date : 2019/3/12 15:46
 * @Version : v1.0
 * @description
 **/
public class TestCyclicBarrier {
    public static CyclicBarrier cyclicBarrier = new CyclicBarrier(4);
    public static void main(String[] args) {

        for (int i = 0 ;i<4;i++){
            new NewThread().start();
        }
    }
    static class NewThread extends Thread{
        @Override
        public void run() {
            try{
                System.out.println(Thread.currentThread().getName()+"开始执行.....");
                Thread.sleep(5000);
                System.out.println(Thread.currentThread().getName()+"执行完毕，等待其他线程执行");
                cyclicBarrier.await();
            }catch (Exception e){

            }
            System.out.println(Thread.currentThread().getName()+"开始做接下来的事情.....");
        }
    }
}
