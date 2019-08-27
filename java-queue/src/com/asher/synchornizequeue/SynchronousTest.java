package com.asher.synchornizequeue;

import java.util.ArrayList;
import java.util.concurrent.SynchronousQueue;

/**
 * @author : 张勇杰
 * @date : 2019/8/13 10:53
 * @Version : v1.0
 * @description
 **/
public class SynchronousTest {
    public static void main(String[] args) throws InterruptedException {
        SynchronousQueue<String> queue = new SynchronousQueue<>();
        Thread thread1 = new Thread(new SynchornizedQueuePuter<String>("one", queue), "线程1");
        thread1.start();
        Thread thread2 = new Thread(new SynchornizedQueuePuter<String>("two", queue), "线程2");
        thread2.start();
        Thread thread3 = new Thread(new SynchornizedQueuePuter<String>("three", queue), "线程3");
        thread3.start();
        Thread thread4 = new Thread(new SynchornizedQueuePuter<String>("four", queue), "线程4");
        thread4.start();
        Thread thread5 = new Thread(new SynchornizedQueuePuter<String>("five", queue), "线程5");
        thread5.start();


        Thread.sleep(5000);
        Thread taker = new Thread(new SynchornizedQueueTaker<String>(queue),"取线程1");
        taker.start();
    }
}
