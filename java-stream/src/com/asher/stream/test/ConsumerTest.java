package com.asher.stream.test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.function.UnaryOperator;
import java.util.stream.Stream;

/**
 *
 * @author : 张勇杰
 * @date : 2019/7/2 18:02
 * @Version : v1.0
 * @description
 **/
public class ConsumerTest {
    public static void main(String[] args) {
//        Consumer f = System.out::println;
//        Consumer f2 = (n) -> System.out.println("666"+n);
//        f.andThen(f2).andThen(f2).andThen(f2).accept("zhang");
//        f2.accept("1");


//        List<Integer> list = Arrays.asList(1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20);
//        ArrayList<Integer> collect = list.stream().filter(n -> n > 10 && n<15).collect(() -> new ArrayList<>(),
//                (list1, item) -> list1.add(item), (list2, list1) -> list2.addAll(list1));
//        collect.forEach(System.out::print);
//        Stream.iterate(1, new Predicate<Integer>() {
//            @Override
//            public boolean test(Integer integer) {
//                return integer <= 10;
//            }
//        }, new UnaryOperator<Integer>() {
//            @Override
//            public Integer apply(Integer integer) {
//                return integer*2;
//            }
//        }).forEach(System.out::println);
        Stream.iterate(1, n->n<10,n->n*3).forEach(System.out::println);
    }
}
