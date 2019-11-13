package com.asher.function.time;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAdjusters;
import java.util.Set;

/**
 * @author : 张勇杰
 * @date : 2019/10/19 11:34
 * @Version : v1.0
 * @description
 **/
public class LocalDateTimeTest {
    public static void main(String[] args) {
        test1();
        test2();
//        test3();
        test4();
        test5();
    }
    public static void test1(){
        LocalDateTime dateTime1 = LocalDateTime.now();
        System.out.println(dateTime1);
        LocalDateTime dateTime2 = LocalDateTime.of(2019,10,19,11,35,20);
        System.out.println(dateTime2);

        LocalDateTime dateTime3 = dateTime2.plusYears(2);
        System.out.println(dateTime3);
    }

    /**
     * Instant: 时间戳（以Unix元年：1970年1月1日00:00:00到某个时间之间的毫秒值
     */
    public static void test2(){
        //获取UTC时区
        Instant now = Instant.now();
        System.out.println(now);

        OffsetDateTime offsetDateTime = now.atOffset(ZoneOffset.ofHours(8));
        System.out.println(offsetDateTime);

        Instant now1 = Instant.now();
        System.out.println(now1.getEpochSecond()-now.getEpochSecond());
    }


    /**
     * Duration 计算两个时间之间的间隔
     * period 计算两个日期之间的间隔
     *
     */
    public static void test3() {
        Instant ins1 = Instant.now();
        try {
            Thread.sleep(1000);
        }catch (Exception e){

        }

        Instant ins2 = Instant.now();
        Duration duration = Duration.between(ins1,ins2);
        System.out.println(duration.toMillis());

        System.out.println("----------------");
        LocalTime lt1 = LocalTime.now();
        try {
            Thread.sleep(1000);
        }catch (Exception e){

        }
        LocalTime lt2 = LocalTime.now();
        Duration duration2 = Duration.between(lt1,lt2);
        System.out.println(duration2.toMillis());

        System.out.println("----------------");


        LocalDate ld1 = LocalDate.of(2015,1,1);
        LocalDate ld2 = LocalDate.now();
        Period period = Period.between(ld1,ld2);
        System.out.println(period);
        System.out.println(period.getYears());
        System.out.println(period.getMonths());
        System.out.println(period.getDays());
    }

    /**
     * TemporalAdjuster:时间矫正器
     */
    public static void test4(){
        LocalDateTime ldt = LocalDateTime.now();
        System.out.println(ldt);

        LocalDateTime ldt2 = ldt.withDayOfMonth(10);
        System.out.println(ldt2);

        //本月第一天
        LocalDateTime with = ldt.with(TemporalAdjusters.firstDayOfMonth());
        System.out.println(with);

        //下一个周五
        LocalDateTime with1 = ldt.with(TemporalAdjusters.next(DayOfWeek.FRIDAY));
        System.out.println(with1);
    }

    /**
     * DateTimeFormatter  格式化时间日期
     */
    public static void test5(){
        DateTimeFormatter dtf = DateTimeFormatter.ISO_DATE_TIME;
        LocalDateTime ldt = LocalDateTime.now();

        String format = ldt.format(dtf);
        System.out.println(format);

        System.out.println("---------");
        DateTimeFormatter dtf1 = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        System.out.println(ldt.format(dtf1));
        test6();
    }

    /**
     * 获取时区列表
     */
    public static void test6(){
        Set<String> availableZoneIds = ZoneId.getAvailableZoneIds();
        availableZoneIds.forEach(System.out::println);
    }
}
