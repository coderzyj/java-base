package com.asher.function.time;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.*;

/**
 * @author : 张勇杰
 * @date : 2019/10/18 16:11
 * @Version : v1.0
 * @description
 **/
public class SimpleDateFormatTest {
        //可以这样解决
    private static final ThreadLocal<SimpleDateFormat> sdfLocal = new ThreadLocal<>(){
        @Override
        protected SimpleDateFormat initialValue() {
            return new SimpleDateFormat("yyyyMMdd");
        }
    };
    public static void main(String[] args) {
        //simpledateformat有线程安全的问题
//        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
////        Date date = new Date();
//        Callable<Date> callable = () -> {
//            System.out.println(sdfLocal.get().hashCode());
//            return sdfLocal.get().parse("20191018");};
//
//        ExecutorService exec = Executors.newFixedThreadPool(10);
//        List<Future<Date>> futures = new ArrayList<>();
//        for(int i =0;i<10;i++){
//            Future<Date> f = exec.submit(callable);
//            futures.add(f);
//        }
//        futures.forEach(x -> {
//            try {
//                System.out.println(x.get());
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            } catch (ExecutionException e) {
//                e.printStackTrace();
//            }
//        });
        //1.8
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyyMMdd");
//        Date date = new Date();
        Callable<LocalDate> callable = () -> LocalDate.parse("20191018",dtf);

        ExecutorService exec = Executors.newFixedThreadPool(10);
        List<Future<LocalDate>> futures = new ArrayList<>();
        for(int i =0;i<10;i++){

            Future<LocalDate> f = exec.submit(callable);
            futures.add(f);
        }
        futures.forEach(x -> {
            try {
                System.out.println(x.get());
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            }
        });
        exec.shutdown();
    }
}
