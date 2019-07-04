//package com.asher.stream.test;
//
//import com.google.common.collect.Lists;
//
//import java.util.ArrayList;
//import java.util.Arrays;
//import java.util.List;
//import java.util.Map;
//import java.util.concurrent.ConcurrentHashMap;
//import java.util.function.Consumer;
//import java.util.function.Function;
//import java.util.function.Predicate;
//import java.util.function.Supplier;
//import java.util.stream.Collectors;
//import java.util.stream.Stream;
//
///**
// * 类介绍
// * Function
// *
// * @author tiefang.hu
// * @date 2019/06/27
// */
//public class LambdaCalculus {
//    /*
//     下面这个方法接受一个int类型参数a,返回a+1,符合我上面说的接受一个参数,返回一个值
//     所以呢这个方法就符合Function接口的定义,那要怎么用呢,继续看例子
// */
//    public static final int addOne(int a) {
//        return a + 1;
//    }
//
//    /*
//        该方法第二个参数接受一个function类型的行为,然后调用apply，对a执行这段行为
//    */
//    public static int oper(int a, Function<Integer, Integer> action) {
//        return action.apply(a);
//    }
//
//    /* 下面调用这个oper方法,将addOne方法作为参数传递 */
//    public static void main(String[] args) {
////        int x = 1;
////        int y = oper(x, b -> addOne(b));
////        System.out.println(y);
//
//
////        //消费者  运算结果`
////
////        Consumer<String> printString = s -> System.out.println(s);
////        printString.accept("helloWorld!");
////        //控制台输出 helloWorld!
////
////        //提供者
////        Supplier<String> getInstance = () -> "HelloWorld!";
////        System.out.println(getInstance.get());
////        // 控偶值台输出 HelloWorld
////
////
////        //Predicate 接口  判断
////        Predicate<Integer> predOdd = integer -> integer % 2 == 1;
////        System.out.println(predOdd.test(5));
////        //控制台输出 true
////
////
////        Predicate<Integer> predicatex = x -> x > 100;
////        System.out.println(predicatex.test(100));
////        //控制台输出 false
////        System.out.println(predicatex.test(101));
////        //控制台输出 true
////
////
////        Predicate<String> str = (s )->s.equals("aaaa");
////        Predicate<String> str2 = (s )->s.length()>0;
//
////        //条件1判断给定的值是否大于100
//       Predicate<Integer> predicate = x -> x > 100;
////        //叠加条件2是否是偶数
////        predicate.and(x -> x % 2 == 0);
////        //条件3或者条件
////        predicate.or(x -> x % 4 == 0);
////        //然后结果取反
////        predicate.negate();
////        System.out.println(predicate.test(98));
////        System.out.println(predicate.test(99));
////        System.out.println(predicate.test(100));
////        System.out.println(predicate.test(101));
////        System.out.println(predicate.test(102));
////        System.out.println("@@@@@@@@@");
////        int m=98;
////        if((m>100&&m%2==0||m%4==0)){
////            System.out.println(true);
////        }else{
////            System.out.println(false);
////        }
//
//
//
//
//
//
//
//
////        //年纪大于22的人
////        Predicate<Person> predicate1 = x -> x.getAge() > 22;
////        List<Person> list = new ArrayList<>();
////        Person p1 = new Person(10, "Frank");
////        list.add(p1);
////        Person p2 = new Person(22, "Lily");
////        list.add(p2);
////        Person p3 = new Person(25, "Gary");
////        list.add(p3);
////        Person p4 = new Person(30, "Jack");
////        list.add(p4);
////        System.out.println(predicate1.test(p1));
////        System.out.println(predicate1.test(p2));
////        System.out.println(predicate1.test(p3));
//
//        //短路
//
////        char c = '1';
////        if (c != '1' && c != '2' && c != '3' && c != '4') {
////            //此处必须都不等；必须用 && ，在使用&&时必须慎重
////            System.out.print("选择错误，请重新输入：");
////        } else {
////            System.out.println("对了");
////    }
////
////
////        char d = '1';
////        if (d != '1' & d != '2' & d != '3' & d != '4') {
////            //此处必须都不等；必须用 && ，在使用&&时必须慎重
////            System.out.print("选择错误，请重新输入：");
////        } else {
////            System.out.println("对了");
////        }
//
////
////        List<Person> alist = new ArrayList<>();
////        alist.add(new Person(22, "Frank"));
////        alist.add(new Person(22, "Frank"));
////        alist.add(new Person(10, "Step"));
////        alist.add(new Person(22, "Cathy"));
////        alist.add(new Person(30, "Frank"));
////        alist.add(new Person(30, "Jack"));
////
////        Stream<Person> streams = alist.stream();
////        streams.filter(distinctByKey(Person::getName)).forEach(a -> System.out.println(a.getAge() + "," + a.getName()));
////
//
//        //  final int sumage = 1;
//        //这个没法去重.他的作用是吧name=frank的取出来
//
//
////        streams.forEach(a -> System.out.println(a.getAge() + "," + a.getName()));
////        //直接当场循环这个流
////
////        streams.distinct()
////                .forEach(a -> System.out.println(a.getAge() + "," + a.getName()));
////
////        //集合按照属性分组
//
////
////
////
////
////        streams.filter(t -> "Frank".equals(t.getName()))
////                .collect(Collectors.toList())
////                .forEach(a -> {
////                    System.out.println(a.getAge() + "," + a.getName());
////                  //  System.out.println("1111111111");
////                 //  sumage=sumage+a.getAge();
////                 //   System.out.println(sumage);
////
////                });
////        System.out.println("###############################");
////        System.out.println(streams.mapToInt(Person::getAge).sum());
//
//
////无限流
////        IntStream.iterate(0, i -> i+1)
////                .distinct()
////                .limit(10)
////                .forEach(a->System.out.println(111));
////              //  .forEach(System.out::println);
////
////
////
//
////        List<Integer> nums = Lists.newArrayList(1,1,null,2,3,4,null,5,6,7,8,9,10);
////
////        System.out.println("sum is:"+nums.stream()
////                .filter(num -> num != null)
////                .distinct()
////                .mapToInt(num -> num * 2).
////        peek(System.out::println)
////                .skip(2)
////                .limit(4)
////                .sum());
//
////1领导:小胡啊,帮我整理下这些文件,Frank:好的,我吧他们同样转换成word格式吧这样好操作点[集合转换成流]
////2领导:把里面的空的去掉,Frank:好的 [过滤不等于null的 1,1,2,3,4,5,6,7,8,9,10]
////3领导:重复的也不要哦 Frank:好的 [去除重复的1,2,3,4,5,6,7,8,9,10]
////4领导:数字设的有点小,统一乘以2吧  Frank:好的 [做int计算-->乘以2  2,4,6,8,10,12,14,16,18,20]
////5领导:小胡,整理好了就帮我打印下 Frank:好的,那我先打开打印机,您还有没有别的问题?  [我要消费这个流了,就是给我吧结果打印出来]
////6领导:等等去掉前面两个 Frank: 好的 [去掉前两个 6,8,10,12,14,16,18,20]
////7Frank:您还有问题吗 领导:让我想想,恩,还有一个问题 只要前四个就够了 Frank:好的      [结果 6,8,10,12]
////8Frank:还有问题吗 领导:没了,再给我汇总一下结果吧
//// Frank:领导请确认下,我把刚才选出来的原[peek前面]文件打印了,然后把汇总过了的[peek后面]信息打印了[结果输出2,4,5,8,10,12,sum is:36]
////
//
//        //并行流
//
////        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9);
////        numbers.parallelStream()
////                .forEach(System.out::println);
//
//
//       List<Integer> nums = Lists.newArrayList(1, 1, null, 2, 3, 4, null, 5, 6, 7, 8, 9, 10);
////
//        List<Integer> numsWithoutNull = nums.stream().filter(num -> num != null).
//                collect(() -> new ArrayList<Integer>(),
//                        (list, item) -> accumulator(list,item),
//                        (list1, list2) -> list1.addAll(list2));
//
//
//        //去掉null
//        //执行一个终结操作,吧非空的集合给到一个新的集合
//
//        //  numsWithoutNull.forEach(System.out::println);
//
//
////        List<String> list = Lists.newArrayList("1", "2", "3", "4", "5");
////        Stream<String> stringStream = list.stream();
////        String concat1 = stringStream.collect(StringBuilder::new, StringBuilder::append, StringBuilder::append).toString();
////
////        System.out.println(concat1);
//
////        List<Integer> ints = Lists.newArrayList(1,2,3,4,5,6,7,8,9,10);
////
////        System.out.println("ints sum is:" + ints.stream().reduce((sum, item) ->sum + item).get());
//
//
//
//
//
//
//
//
//
//
////等价于上面,这样看起来应该更加清晰
//        // String concat2 = stringStream.collect(() -> new StringBuilder(),(l, x) -> l.append(x), (r1, r2) -> r1.append(r2)).toString();
//      //  consumerTest();
//
//    }
//
//    public  static  void  consumerTest(){
//        Consumer f=System.out::println;//为啥不能写Consumer f = System.out::println()
//        Consumer f2=n->System.out.println(n+"F2");
//
//        f.andThen(f2).accept("test");
//
//        f.andThen(f).andThen(f).andThen(f).accept("test1");
//
//
//
//
//
//    }
//
//
//    public static void accumulator(List list,Object item){
//        list.add(item);
//    }
//
//
//    public static <T> Predicate<T> distinctByKey(Function<? super T, Object> keyExtractor) {
//        Map<Object, Boolean> seen = new ConcurrentHashMap<>();
//        return object -> seen.putIfAbsent(keyExtractor.apply(object), Boolean.TRUE) == null;
//    }
//
//    public void testForeach() {
//
//        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9);
//        list.stream().filter(a -> a > 3)
//                .map(i -> {
//                    System.out.println(i);
//                    return i++;
//                }).collect(Collectors.toList());
//
//
//        for (int i = 0; i > list.size(); i++) {
//            if (list.get(i) > 3) {
//                System.out.println(i);
//            }
//        }
//
//        for (Integer i : list) {
//            if (i > 3) {
//                System.out.println(i);
//            }
//        }
//
//    }
//}
