package com.zyj;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * 版权声明：CopyRight (c) 2018 ucarinc. All Rights Reserved.
 *
 * @author : 张勇杰
 * @date : 2019/7/12 14:04
 * @Version : v1.0
 * @description
 **/
public class NumberTest {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String tip = scanner.next();
        char[] arr = tip.toCharArray();
        Integer result = operate(arr);
        System.out.println("出现最多的数字为："+result);
    }
    public static  Integer operate(char [] arr){
        HashMap<String,Integer> map = new HashMap<>();
        int max = 1;
        for(int i = 0;i < arr.length; i++){
            if(isNum(arr[i])){
                int j = i;
                StringBuilder sb = new StringBuilder();
                while(j < arr.length && isNum(arr[j])){
                    sb.append(arr[j++]);
                    if(!map.containsKey(sb.toString())){
                        map.put(sb.toString(),1);
                    }else{
                        map.put(sb.toString(),map.get(sb.toString())+1);
                        if(map.get(sb.toString()) > max){
                            max = map.get(sb.toString());
                        }
                    }
                }
            }
        }
        int index = 0;
        String [] barry = new String[map.size()];
        for(Map.Entry<String, Integer> entry :map.entrySet()){
//            System.out.println(entry.getKey()+"->"+entry.getValue());
            if(entry.getValue() == max){
                barry[index++] = entry.getKey();
            }
        }
        int maxNum = Integer.valueOf(barry[0]);
        for (int k = 0; k < index; k ++){
            if(barry != null && Integer.valueOf(barry[k]) > maxNum){
                maxNum = Integer.valueOf(barry[k]);
            }
        }
        return maxNum;
    }

    public static boolean isNum(char c){
        if(c >= '0' && c <= '9'){
            return true;
        }
        return false;
    }
}
