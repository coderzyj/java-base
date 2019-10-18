package com.asher.function.stream;

import com.asher.function.User;

import java.util.*;
import java.util.function.BinaryOperator;
import java.util.stream.Collectors;

/**
 * @author : 张勇杰
 * @date : 2019/10/16 14:45
 * @Version : v1.0
 * @description
 * 查找与匹配
 * allMatch  检查是否匹配所有元素
 * anyMatch 检查是否至少匹配一个元素
 * noneMatch 检查是否没有匹配所有元素
 * findFirst 返回第一个元素
 * findAny 返回当前流中的任意元素
 * count 返回流中元素的总个数
 * max 返回流中的最大值
 * min 返回流中的最小值
 **/
public class StreamApiTest3 {
    static List<User> users = Arrays.asList(new User(1,"zhang"),
            new User(11,"zhangy"),
            new User(5,"zhang1"),
            new User(10,"zhang2"),
            new User(20,"zhang3"),
            new User(20,"zhang3"),
            new User(20,"zhang3"),
            new User(20,"zhang3"));
    public static void main(String[] args) {
//        test1();
//        test2();
//        test3();
//        test4();
        test5();


        test6();

        test7();
    }


    public static void test1(){
        boolean b = users.stream().allMatch(e -> e.getAge() == 10);
        System.out.println(b);
        System.out.println("-------------------------------------");

        boolean c = users.stream().anyMatch(e -> e.getAge() == 10);
        System.out.println(c);

        System.out.println("-------------------------------------");

        boolean d = users.stream().noneMatch(e -> e.getAge() == 10);
        System.out.println(d);


        System.out.println("-------------------------------------");

        Optional<User> any = users.stream().filter(e -> e.getAge() == 10).findAny();
        System.out.println(any);
    }

    /**
     * 规约
     * reduce(T identity,BinaryOperator) / reduce(BinaryOperator) 可将流中元素反复结合起来 得到一个值
     *
     */
    public static void test2(){
        List<Integer> list = Arrays.asList(1,2,3,4,5,6,7,8,9,10);
        Integer sum = list.stream().reduce(0, (x, y) -> x + y);
        System.out.println(sum);

        Optional<Integer> reduce = users.stream().map(User::getAge).reduce(Integer::sum);
        System.out.println(reduce.get());
        Integer reduce1 = users.stream().map(User::getAge).reduce(0, Integer::sum);
        System.out.println(reduce1);

    }


    /**
     * 手机 collect 将流转换为其他形式。接收一个Collector接口的实现，用于给Stream中元素做汇总的方法
     */
    public static void test3(){
        List<Integer> collect = users.stream().map(User::getAge).collect(Collectors.toList());
        System.out.println(collect);

    }


    public static void test4(){
        Long count = users.stream().map(User::getAge).collect(Collectors.counting());
        System.out.println("条数总和"+count);
        System.out.println("-----------------------");

        Double collect = users.stream().collect(Collectors.averagingDouble(User::getAge));
        System.out.println("平均年龄"+collect);
        System.out.println("-----------------------");

        Double summingage = users.stream().collect(Collectors.summingDouble(User::getAge));
        System.out.println("年龄总和"+summingage);
        System.out.println("-----------------------");

        //年龄最大值
        Optional<Integer> max = users.stream().map(User::getAge).max(Integer::compare);
        System.out.println("年龄最大值"+max.get());
        System.out.println("-------------------------");

        Optional<User> collect1 = users.stream().collect(Collectors.maxBy((x, y) -> Double.compare(x.getAge(), y.getAge())));
        System.out.println("年龄最大的用户"+collect1.get());
        System.out.println("-------------------------");

        Optional<Integer> collect2 = users.stream().map(User::getAge).collect(Collectors.maxBy(Integer::compareTo));
        System.out.println("年龄最大的用户2"+collect2.get());
        System.out.println("-------------------------");
    }

    /**
     * collect 分组
     */
    public static void test5(){
        Map<Integer, List<User>> collect = users.stream().collect(Collectors.groupingBy(x -> x.getAge()));
        Set<Map.Entry<Integer, List<User>>> entries = collect.entrySet();
        Iterator<Map.Entry<Integer, List<User>>> it = entries.iterator();
        while(it.hasNext()){
            Map.Entry<Integer, List<User>> next = it.next();
            System.out.println(next.getKey());
            System.out.println(next.getValue());
        }
        System.out.println(collect);
        System.out.println("------------------------------------");
    }

    /**
     * collect多级分组
     */
    public static void test6(){
        Map<Integer, Map<String, List<User>>> collect = users.stream().collect(Collectors.groupingBy(User::getAge, Collectors.groupingBy(x -> x.getName())));
        System.out.println(collect);
        System.out.println("------------------------------------");

        //分区
        Map<Boolean, List<User>> collect1 = users.stream().collect(Collectors.partitioningBy(x -> x.getAge() > 10));
        System.out.println(collect1);
        System.out.println("------------------------------------");

    //这种方式同样能获取最大最小值等信息
        DoubleSummaryStatistics collect2 = users.stream().collect(Collectors.summarizingDouble(x -> x.getAge()));
        System.out.println(collect2.getMax());
        System.out.println(collect2.getAverage());
        System.out.println(collect2.getCount());
        System.out.println(collect2.getMin());
        System.out.println(collect2.getSum());
        System.out.println("------------------------------------");


        StringJoiner sj = new StringJoiner("1",",","2");
        System.out.println(sj.toString());

        Map<String,String> map = new HashMap<>();
        map.put("1","1");
        map.put("2","2");
        map.put("3","3");
        map.put("4","4");
        String reduce = map.entrySet().stream().map(x -> x.getKey() + ":" + x.getValue()).reduce(new StringJoiner(",", "[", "]"), StringJoiner::add, StringJoiner::merge).toString();
        System.out.println(reduce);
    }

    public static void test7(){
        String reduce = users.stream().map(User::getName).sorted().reduce("", String::concat);
        System.out.println(reduce);
    }
}
