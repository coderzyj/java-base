package com.asher.function.stream;


import com.asher.function.User;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.stream.Stream;

/**
 * @author : 张勇杰
 * @date : 2019/10/16 10:27
 * @Version : v1.0
 * @description
 *
 * 一、Stream的三个操作步骤
 * 1.创建stream
 * 2.中间操作
 * 3.终止操作（终端操作）
 **/
public class StreamApiTest {
    public static void main(String[] args) {
        test1();
    }

    public static void test1(){
        //1.可以通过Collection系列集合提供的stream()
        List<String> list = new ArrayList<>();
        Stream<String> stream = list.stream();

        //2.通过Arrays中的静态方法stream获取数组流
        User[] user = new User[10];
        Stream<User> stream1 = Arrays.stream(user);

        //3.通过Stream类中的静态方法of()
        Stream<String> stream2 = Stream.of("aa", "bb", "cc");

        //4.创建无限流
        //迭代
        Stream<Integer> stream3 = Stream.iterate(0, x -> x + 2);
        stream3.limit(10).forEach(System.out::println);

        //生成
        Stream<Double> stream4 = Stream.generate(() -> Math.random());
        stream4.limit(10).forEach(System.out::println);


    }
}
