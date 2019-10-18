package com.asher.test;

import org.apache.zookeeper.KeeperException;
import org.apache.zookeeper.WatchedEvent;
import org.apache.zookeeper.Watcher;
import org.apache.zookeeper.ZooKeeper;
import org.apache.zookeeper.data.Stat;

import java.io.IOException;
import java.util.concurrent.CountDownLatch;

/**
 * @author : asher.zhang
 * @date : 2019/9/10 15:29
 * @Version : v1.0
 * @description
 **/
public class ZookeeperTest implements Watcher {
    private static CountDownLatch connectSemaphore = new CountDownLatch(1);
    private static ZooKeeper zkClient = null;
    private static Stat stat = new Stat();
    public static void main(String[] args) throws Exception {
        String path = "/username";
        zkClient = new ZooKeeper("47.106.196.242:2181",5000,new ZookeeperTest());

        //等待zk连接成功
        connectSemaphore.await();
        //获取path路径下配置的数据，并注册到默认的监听器
        System.out.println(new String(zkClient.getData(path,true,stat)));

        Thread.sleep(Integer.MAX_VALUE);

    }

    public void process(WatchedEvent watchedEvent) {
        if(watchedEvent.getType() == Event.EventType.None && watchedEvent.getPath() == null){
            connectSemaphore.countDown();
        }else if(watchedEvent.getType() == Event.EventType.NodeDataChanged){
            try {
                System.out.println("配置已更改，新值为："+new String(zkClient.getData(watchedEvent.getPath(),true,stat)));
            } catch (KeeperException e) {
                e.printStackTrace();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
