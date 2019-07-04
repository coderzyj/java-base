package com.asher.stream.test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * 版权声明：CopyRight (c) 2018 ucarinc. All Rights Reserved.
 *
 * @author : 张勇杰
 * @date : 2019/3/16 10:02
 * @Version : v1.0
 * @description
 **/
public class StreamTry{
    public static void main(String[] args) {
        List<String> list = new ArrayList();
        list.add("zyj");
        list.add("zyj1");
        list.add("zyj2");
        list.add("zyj3");

        List<String> list2 = (List<String>) list.stream().filter(name -> name.toString().contains("1")).collect(Collectors.toList());
        for(String a:list2){
            System.out.println(a);
        }

        list.forEach((String temp) -> {
            if(true){
                System.out.println(temp);
            }

        });
        Map<String,String> map = new HashMap<>();

    }
}
