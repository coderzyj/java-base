package com.asher.synchornizequeue;

import java.util.concurrent.SynchronousQueue;

/**
 * @author : 张勇杰
 * @date : 2019/8/13 10:57
 * @Version : v1.0
 * @description
 **/
public class SynchornizedQueueTaker<T> implements Runnable{
    T value;
    SynchronousQueue<T> queue;

    public SynchornizedQueueTaker(SynchronousQueue<T> queue) {
        this.queue = queue;
    }

    @Override
    public void run() {

        try {
            System.out.println(Thread.currentThread().getName()+"--beginTaker--");
            value = queue.take();
            System.out.println(Thread.currentThread().getName()+"--afterTaker--"+value);

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
