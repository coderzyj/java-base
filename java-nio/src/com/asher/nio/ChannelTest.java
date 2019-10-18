package com.asher.nio;

import sun.misc.URLClassPath;

import java.io.*;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.CharacterCodingException;
import java.nio.charset.Charset;
import java.nio.charset.CharsetDecoder;
import java.nio.charset.CharsetEncoder;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.Map;
import java.util.Set;
import java.util.SortedMap;

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
 *
 * 六、分散（Scatter）与聚集（Gather）
 * 分散读取（Scattering Reads）：将通道中的数据分散到多个缓冲区
 * 聚集写入（Gather Writes）：将多个缓冲区中的数据聚集到通道中
 *
 * 七、字符集：Charset
 * 编码:字符串-> 字节数组
 * 解码：字节数组 -> 字符串
 *
 **/
public class ChannelTest {
    public static void main(String[] args) throws IOException {
//        test1();
//        test2();
//        test3();
//        test4();
//          test5();
        test6();
    }

    public static void test6() throws CharacterCodingException {
        Charset cs1 = Charset.forName("GBK");

        //获取编码器
        CharsetEncoder ce = cs1.newEncoder();

        //获取解码器
        CharsetDecoder de = cs1.newDecoder();

        CharBuffer cBuf = CharBuffer.allocate(1024);
        cBuf.put("张勇杰");
        cBuf.flip();

        //编码
        ByteBuffer buffer = ce.encode(cBuf);
        for (int i = 0;i<6;i++){
            System.out.println(buffer.get());
        }
        buffer.flip();
        //解码
        CharBuffer dBuf = de.decode(buffer);
        System.out.println(dBuf.position());
        System.out.println(dBuf.limit());
        System.out.println(dBuf.length());
        System.out.println(dBuf.toString());
//        System.out.println(new String(buffer.array()));

    }
    public static void test5(){
        SortedMap<String, Charset> map = Charset.availableCharsets();
        Set<Map.Entry<String, Charset>> set = map.entrySet();
        for(Map.Entry<String, Charset> m:set){
            System.out.println(m.getKey()+"="+m.getValue());
        }

    }
    /**
     * 分散和聚集
     */
    public static void test4() throws IOException {
        RandomAccessFile raf1 = new RandomAccessFile(Paths.get("C://Ideaprojects/java-base/java-nio/src", "/12.txt").toString(),"rw");

        //1.获取通道
        FileChannel channel1 = raf1.getChannel();

        //2.分配指定大小的缓冲区
        ByteBuffer buf1 = ByteBuffer.allocate(100);
        ByteBuffer buf2 = ByteBuffer.allocate(1024);

        //3.分散读取
        ByteBuffer[] bufs = {buf1,buf2};
        channel1.read(bufs);

        for (ByteBuffer buf:bufs){
            buf.flip();
        }
        System.out.println(new String(bufs[0].array(),0,bufs[0].limit()));
        System.out.println(new String(bufs[1].array(),0,bufs[1].limit()));
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
