package com.asher.nio;

/**
 * @author : 张勇杰
 * @date : 2019/8/28 13:20
 * @Version : v1.0
 * @description
 * 一、使用NIO完成网络通信的三个核心
 * 1.通道（Channel）：负责连接
 *   java.nio.channels.Channel接口：
 *      |--SelectableChannel
 *         |--SocketChannel
 *         |--ServerSocketChannel
 *         |--DatagramChannel
 *
 *         |--Pipe.SinkChannel
 *         |--Pipe.SourceChannel
 *
 * 2.缓冲区（Buffer）：负责数据存取
 *
 * 3.选择器（Selector）：是SelectableChannel的多路复用器，用于监控SelectableChannel的IO状况
 *
 **/
public class BlockingNIOTest {
    public static void main(String[] args) {
        //1.
    }
}
