package com.asher.function.optional;

import com.asher.function.User;

import java.util.Optional;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * @author : 张勇杰
 * @date : 2019/10/17 17:18
 * @Version : v1.0
 * @description
 *
 * Optional 容器的常用方法
 * Optional.of(T t): 创建一个Optional实例
 * Optional.empty() 创建一个空的Optional实例
 * Optional.ofNullable(T t) 弱t不为null，创建Optional实例 否则创建空实例
 * isPresent: 判断是否包含空值
 * orElse(T t) 如果调用对象包含值  返回该值 否则返回t
 * orElseGet(Supplier s) 如果有值对其处理 返回该值 否则返回s提供的值
 * map(Function f) 如果有值对其处理 并返回处理后的Optional  否则返回Optional.empty
 * flatMap(Function mapper) 与map类似 要求返回值必须是Optional
 *
 **/
public class TestOptional {
    public static void main(String[] args) {
        test1();
//        test2();
        test3();
        test4();
    }

    public static void test1(){
        Optional<User> op = Optional.of(new User());
        System.out.println(op.get());
        System.out.println("--------------------------");
    }
    public static void test2(){
        Optional<Object> empty = Optional.empty();
        System.out.println(empty.get());
        System.out.println("--------------------------");
    }

    public static void test3(){
        Optional<Object> empty = Optional.ofNullable(null);
        //不等于空就返回true
        //isEmpty方法 是等于空就返回true
        if(empty.isPresent()){
            System.out.println(empty.get());
        }
        Object zhang = empty.orElse(new User(10, "zhang"));
        //此方法可以在Supplier供给型接口中做额外逻辑处理
        Object o = empty.orElseGet(() ->{
            if(true){
                return new User();
            }else{
                return new User(9,"a");
            }
        });
        System.out.println(o);
        System.out.println(zhang);
        System.out.println("--------------------------");
    }

    public static void test4(){
       Optional<User> op = Optional.ofNullable(new User(10,"z"));
       Optional<String> o = op.map(x -> x.getName());
        System.out.println(o.get());
    }
}
