package com.asher.function;

import java.util.function.*;

/**
 * @author : 张勇杰
 * @date : 2019/10/15 16:12
 * @Version : v1.0
 * @description
 *
 * 1.Function<T,R> 函数是接口：T是参数类型R是返回值类型
 * 2.Consumer<T>  接收一个T类型的参数
 * 3.Supplier<T>  返回一个T类型对象
 * 4.Predict<T>  断言 判断传入对象是否满足某条件
 *
 *
 *
 * 方法引用： 对已经存在的方法的特殊引用  要求参数类型和返回类型和 函数式接口一样  例如Consumer<T>的accept方法接受T类型 返回值为
 * void 可以用 System.out::println赋值
 * 对于参数是两个的（Bi开头的那种BIFunction啥的） 如果这个实例方法是 第一个参数调用的 且方法参数是第二个参数 可以用类方法的形式写 例如 String.equals
 * 1.实例方法 object::
 * 2.类方法（静态方法） Class::
 * 3.构造方法   Class::new
 **/
public class Main {
    public static void main(String[] args) {
        test1();
        test2();
        test3();
        test4();
        test5();
        test6();
        test7();
        test8();
        test9();
        test10();
    }

    public static void test1(){
        Predicate<String> pre = (x) -> x.length()>2;
        System.out.println(pre.test("hello"));
    }

    public static void test2(){
//        Consumer<String> com = (x) -> System.out.println(x);
        Consumer<String> com = System.out::println;
        com.accept("hello");
    }


    public static void test3(){
        Supplier<String> supplier = () -> new String("world");
        System.out.println(supplier.get());
    }

    public static void test4(){
        Function<String,Integer> function = (x) -> x.length();
        System.out.println(function.apply("zhang"));
    }


    public static void test5(){
        Function<String,Integer> function = String::length;
        System.out.println(function.apply("zhang"));
    }

    public static void test6(){
        Integer a = 1;
        Function<Integer,Boolean> function = a::equals;
        System.out.println(function.apply(1));
    }
    public static void test7(){
        BiPredicate<String,String> bp = String::equals;

        System.out.println(bp.test("zhang","yo"));
    }
    public static void test8(){
        Supplier<User> supplier = User::new;
        System.out.println(supplier.get());
    }

    public static void test9(){
        BiFunction<Integer,String,User> bf = User::new;
        System.out.println(bf.apply(18,"zhang"));
    }
    public static void test10(){
        Function<Integer,String[]> f = (x)->new String[x];
        Function<Integer,String[]> f1 = String[]::new;
        System.out.println(f1.apply(10).length);
    }
}

