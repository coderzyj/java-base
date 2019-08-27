package com.asher.synchornizequeue;

import java.util.concurrent.SynchronousQueue;

/**
 * @author : 张勇杰
 * @date : 2019/8/13 10:50
 * @Version : v1.0
 * @description
 **/
public class SynchornizedQueuePuter<T> implements Runnable{
    T value;
    SynchronousQueue<T> queue;

    public SynchornizedQueuePuter(T value, SynchronousQueue<T> queue) {
        this.value = value;
        this.queue = queue;
    }

    @Override
    public void run() {
        try {
            System.out.println(Thread.currentThread().getName()+"--beforeput--"+value);
            queue.put(value);
            System.out.println(Thread.currentThread().getName()+"--afterput--"+value);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
