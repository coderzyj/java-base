package com.asher.synchornizequeue;

import java.util.ArrayList;
import java.util.List;

/**
 * @author : 张勇杰
 * @date : 2019/8/13 11:49
 * @Version : v1.0
 * @description
 **/
public class ListTest {
    List<Integer> list;

    public static void main(String[] args) {
//        ListTest test = new ListTest();
//        test.dosomething();
//        int i = 2;
////        i = ++i;
////        System.out.println(i);
        int a=1;
        switch (a){
            case 1:
                System.out.println("1");
                break;
            case 2:
                System.out.println("2");
        }

    }
    void dosomething(){
        List<String> stringList = new ArrayList<>();
        stringList.add("1");
        stringList.add("2");
        stringList.add("3");
        stringList.add("4");
        stringList.add("5");
        this.list = new ArrayList<>(stringList.size());
        for(String a:stringList){
            this.list.add(Integer.valueOf(a));
        }
        System.out.println(this.list);
    }
}
