package com.asher.consumer.consumer;

import com.asher.consumer.client.HttpClient;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author : 张勇杰
 * @date : 2019/8/9 11:56
 * @Version : v1.0
 * @description
 **/
public class Consumer implements Runnable{
    private static BlockingQueue queue = new ArrayBlockingQueue(100);
    private AtomicInteger a = new AtomicInteger();
    static {
        for (int i =0;i<100;i++){
            try {
                queue.put(i);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
    boolean isPut = false;

    public Consumer(boolean isPut) {
        this.isPut = isPut;
    }

    public static void main(String[] args) throws MalformedURLException, InterruptedException {
//        URL url = new URL("http","localhost",8080,"/");
//        HttpClient.send(url);
        Consumer consumer = new Consumer(false);
        new Thread(consumer,"线程1").start();
        new Thread(consumer,"线程2").start();
        new Thread(consumer,"线程3").start();
    }


    public void run() {
        if(isPut){
            try {
                put();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }else{
            try {
//                while(queue.size()>0){
                    get();
//                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private void put() throws InterruptedException {
        for (int i = 0;i< 100 ;i++){
            queue.put(Thread.currentThread().getName()+i);
            System.out.println(Thread.currentThread().getName()+i);
        }
    }

    private void get() throws InterruptedException {
        for(int i = 0 ;i<30;i++){
            System.out.println(Thread.currentThread().getName()+"---"+queue.take());
        }

    }
}
