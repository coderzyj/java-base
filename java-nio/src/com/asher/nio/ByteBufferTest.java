package com.asher.nio;


import java.nio.ByteBuffer;
import java.util.HashMap;
import java.util.Set;

/**
 * @author : 张勇杰
 * @date : 2019/8/26 13:45
 * @Version : v1.0
 * @description
 **/
public class ByteBufferTest {
    public static void main(String[] args) {
        String a = "abcde";
        ByteBuffer buff = ByteBuffer.allocate(1024);
        System.out.println("------------beforePut-----------");
        System.out.println(buff.position());
        System.out.println(buff.limit());
        System.out.println(buff.capacity());

        buff.put(a.getBytes());
        System.out.println("------------afterPut-----------");
        System.out.println(buff.position());
        System.out.println(buff.limit());
        System.out.println(buff.capacity());

        //切换到读模式
        buff.flip();
        System.out.println("------------beforeGet-----------");
        System.out.println(buff.position());
        System.out.println(buff.limit());
        System.out.println(buff.capacity());
        byte[] dist = new byte[buff.limit()];
        buff.get(dist);
        //读取之后
        System.out.println("------------afterGet-----------");
        System.out.println(buff.position());
        System.out.println(buff.limit());
        System.out.println(buff.capacity());
        System.out.println(new String(dist));

        //可重复读  把position重置
        buff.rewind();
        System.out.println("------------afterRewind-----------");
        System.out.println(buff.position());
        System.out.println(buff.limit());
        System.out.println(buff.capacity());
//        System.out.println(new String(dist));

        byte[] dit = new byte[buff.limit()];
        buff.get(dit,0,2);
        System.out.println(buff.position());
        System.out.println(new String(dit,0,2));
        buff.get(dit,2,2);
        System.out.println(buff.position());
        System.out.println(new String(dit,2,2));
        System.out.println(new String(dit));
        //缓冲区状态重置 数据不清空
        buff.clear();
        System.out.println("------------afterClear-----------");
        System.out.println(buff.position());
        System.out.println(buff.limit());
        System.out.println(buff.capacity());

        char c = (char) buff.get();
        System.out.println(c);

        buff.flip();

        System.out.println(buff.position());
        System.out.println(buff.limit());
        System.out.println(buff.capacity());
        System.out.println(buff.remaining());
        //缓冲区位置标记 mark 与 reset
    }
}
