package com.zyj;

/**
 * 版权声明：CopyRight (c) 2018 ucarinc. All Rights Reserved.
 *
 * @author : 张勇杰
 * @date : 2019/2/22 9:46
 * @Version : v1.0
 * @description
 **/
public class TestCompareAndSwap {
    public static void main(String[] args) {
        final CompareAndSwap compareAndSwap=new CompareAndSwap();
        for(int i = 0 ;i<5;i++){
            new Thread(new Runnable() {
                @Override
                public void run() {
                    int expectedValue = compareAndSwap.get();
                    System.out.println(compareAndSwap.compareAndSet(expectedValue,(int)(Math.random()*101)));
                }
            }).start();
        }
    }
}

class CompareAndSwap{
    private int value;

    public synchronized int get(){
        return value;
    }

    /**
     * 比较
     * @param expectedValue
     * @param newValue
     * @return
     */
    public synchronized int compareAndSwap(int expectedValue,int newValue){
        int oldValue = value;
        if(oldValue == expectedValue){
            this.value = newValue;
        }
        return oldValue;
    }

    public synchronized boolean compareAndSet(int expectedValue,int newValue){
        return expectedValue == compareAndSwap(expectedValue,newValue);
    }
}
