package com.asher.learn.jvm;

import java.util.ArrayList;
import java.util.List;

/**
 * 版权声明：CopyRight (c) 2018 ucarinc. All Rights Reserved.
 *
 * @author : 张勇杰
 * @date : 2019/7/13 10:28
 * @Version : v1.0
 * VM Args -XX:PermSize=10M -XX:MaxPermSize=10M
 * @description
 **/
public class PermGenTest {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        int i = 0;
        while (true){
            list.add(String.valueOf(i).intern());
            i++;
        }
    }
}
