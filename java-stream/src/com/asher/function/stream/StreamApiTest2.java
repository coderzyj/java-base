package com.asher.function.stream;

import com.asher.function.User;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

/**
 * @author : 张勇杰
 * @date : 2019/10/16 10:52
 * @Version : v1.0
 * @description
 * 中间操作
 * 1.筛选和切片
 *  filter 接收lambda，从流中排除某些元素
 *  limit 截断流，使其元素不超过给定量
 *  skip（n） 跳过流，跳过前n个元素，若流中元素不足n个 则返回一个空流
 *  distinct 筛选  根据hashcode和equals去除重复元素
 **/
public class StreamApiTest2 {
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

//        test5();
//        test6();
        test7();
    }


    public static void test1(){
        //中间操作  不会进行任何操作
        Stream<User> userStream = users.stream().filter(x -> x.getAge() > 10);
        //终止操作 一次性执行全部内容 惰性求值
        userStream.forEach(System.out::println);
    }

    public static void test2(){
        //发现前两天符合条件的数据 后续数据不再迭代  起到提高效率的作用
        users.stream().filter(x -> {
            System.out.println("短路！");
            return x.getAge() > 5;
        }).limit(2).forEach(System.out::println);
    }


    public static void test3(){
        //跳过前两条符合条件的数据  取后面符合条件的数据
        users.stream().filter(x -> {
            System.out.println("短路！");
            return x.getAge() > 5;
        }).skip(2).forEach(System.out::println);
    }
    public static void test4(){
        //distinct 去除重复元素 前提是重写了hashcode和equals
        users.stream().filter(x -> {
            System.out.println("短路！");
            return x.getAge() > 5;
        }).skip(2).distinct().forEach(System.out::println);
    }

    /**
     * 映射
     * map  接收lambda，将元素转换成其他形式或提取信息。接收一个函数作为参数，该函数会被应用到每个元素上，并将其映射成一个新的元素。
     * flatMap 接收一个函数作为参数 ，将流中的每个值都转换成另一个流，然后把所有流合并成另一个流
     */
    public static void test5(){
        List<String> list = Arrays.asList("aaa","bbb","ccc","ddd","eee");
        list.stream().map(x -> x.toUpperCase()).forEach(System.out::println);

        users.stream().map(User::getName).forEach(System.out::println);
    }



    public static void test6(){
        List<String> list = Arrays.asList("aaa","bbb","ccc","ddd","eee");
        list.stream().map(x -> x.toUpperCase()).forEach(System.out::println);

        users.stream().map(User::getName).forEach(System.out::println);

        Stream<Stream<Character>> streamStream = list.stream().map(StreamApiTest2::filterChracter);//{{a,a,a},{b,b,b}}

        streamStream.forEach(x ->{x.forEach(System.out::println);});
        System.out.println("-------------------------------------------------------");

        Stream<Character> characterStream = list.stream().flatMap(StreamApiTest2::filterChracter);
        characterStream.forEach(System.out::println);
    }

    /**
     * 排序
     * sorted（） 自然排序（Comparabl）
     * sorted(Comparator com) 定制排序
     */
    public static void test7(){
        List<String> list = Arrays.asList("aaa","bbb","ccc","ddd","eee");
        list.stream().map(x -> x.toUpperCase()).forEach(System.out::println);

        users.stream().map(User::getName).forEach(System.out::println);
        System.out.println("--------------------------------------------");
        users.stream().sorted((e1,e2) ->{
            if(e1.getAge().equals(e2.getAge())){
                return e1.getName().compareTo(e2.getName());
            }else{
                return e1.getAge().compareTo(e2.getAge());
            }
        }).forEach(System.out::println);

    }

    static Stream<Character> filterChracter(String str){
        List<Character> list = new ArrayList<>();
        for(Character c:str.toCharArray()){
            list.add(c);
        }
        return list.stream();
    }
}
