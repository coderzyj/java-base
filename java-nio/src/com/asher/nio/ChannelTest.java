package com.asher.nio;

import sun.misc.URLClassPath;

import java.io.*;
import java.nio.ByteBuffer;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

/**
 * @author : 张勇杰
 * @date : 2019/8/27 15:10
 * @Version : v1.0
 * @description
 *
 * 一、io过程
 *      1.应用程序发起读写请求时，要通过用户地址空间->内核地址空间，然后才能操作CPU的IO接口
 *      2.早期的IO是由CPU负责，发生IO时，CPU被占用，无法进行其他操作
 *      3.后来出现DMA（直接内存存取）技术，由他向CPU申请IO权限，申请成功后则由DMA全权负责
 *      4.之后出现channel（通道），是完全独立的处理器，专门负责IO操作
 * 二、通道：用于源节点和目标节点的连接，在javaNIO中负责缓冲区中数据的传输，Channel本身不存储数据，因此需要配合缓冲区进行传输
 *
 * 三、通道的主要实现类
 *  java.nio.channels.Channel
 *      |-- FileChannel
 *      |--SocketChannel
 *      |--ServerSocketChannel
 *      |--DatagramChannel
 *
 * 四、获取通道
 * 1.java 针对支持通道的类提供了getChannel()方法
 *    本地IO：FileInputStream/FileOutStream
 *    RandomAccessFile
 *
 *    网络IO:
 *    Socket
 *    ServerSocket
 *    DatagramSocket
 *
 * 2.在jdk1.7中的NIO .2 中针对各个通道提供了静态方法open()
 * 3.在jdk1.7中的NIO.2的Files工具类中的newByteChannel方法也能获取
 *
 * 五、通道之间的数据传输
 *  transferFrom
 *  transferTo
 **/
public class ChannelTest {
    public static void main(String[] args) throws IOException {
//        test1();
//        test2();
        test3();
    }

    /**
     * 通道之间的数据传输
     */
    public static void test3() throws IOException {
        FileChannel inChannel = FileChannel.open(Paths.get("C://Ideaprojects/java-base/java-nio/src", "/1.jpg"), StandardOpenOption.READ);

        FileChannel outChannel = FileChannel.open(Paths.get("C://Ideaprojects/java-base/java-nio/src","/4.jpg"),StandardOpenOption.WRITE,StandardOpenOption.READ,StandardOpenOption.CREATE_NEW);

        inChannel.transferTo(0,inChannel.size(),outChannel);
        outChannel.close();
        inChannel.close();
    }

    /**
     * 使用直接缓冲区完成文件复制（内存映射文件）
     */
    public static void test2() throws IOException {
        FileChannel inChannel = FileChannel.open(Paths.get("C://Ideaprojects/java-base/java-nio/src", "/1.jpg"), StandardOpenOption.READ);

        FileChannel outChannel = FileChannel.open(Paths.get("C://Ideaprojects/java-base/java-nio/src","/3.jpg"),StandardOpenOption.WRITE,StandardOpenOption.READ,StandardOpenOption.CREATE_NEW);

        //内存映射文件,直接物理内存，只有byteBuffer支持
        MappedByteBuffer inByteBuffer = inChannel.map(FileChannel.MapMode.READ_ONLY, 0, inChannel.size());

        MappedByteBuffer outByteBuffer = outChannel.map(FileChannel.MapMode.READ_WRITE, 0, inChannel.size());

        //直接对缓冲区进行数据的读写操作
        byte[] dst = new byte[inByteBuffer.limit()];
        inByteBuffer.get(dst);
        outByteBuffer.put(dst);

    }



    /**
     * 利用通道完成文件复制
     */
    public static void test1() throws IOException {
//        File file = new File("4.jpg");
//        FileInputStream fis = new FileInputStream(file);
        FileInputStream fis = new FileInputStream(Paths.get("C://Ideaprojects/java-base/java-nio/src","/1.jpg").toString());
        FileOutputStream fos = new FileOutputStream(Paths.get("C://Ideaprojects/java-base/java-nio/src","/2.jpg").toString());

        FileChannel inChannel = fis.getChannel();
        FileChannel outChannel = fos.getChannel();

        ByteBuffer buf = ByteBuffer.allocate(1024);
        while(inChannel.read(buf) != -1){
            buf.flip();
            outChannel.write(buf);
            buf.clear();
        }
        outChannel.close();
        inChannel.close();

    }
}
