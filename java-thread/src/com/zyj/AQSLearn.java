package com.zyj;

import java.util.concurrent.locks.AbstractQueuedSynchronizer;

/**
 * 版权声明：CopyRight (c) 2018 ucarinc. All Rights Reserved.
 *
 * @author : 张勇杰
 * @date : 2019/7/11 14:04
 * @Version : v1.0
 * @description
 **/
public class AQSLearn {
    private static int []kmpArr = {0,0,0,0,1,2,0};
    public static void main(String[] args) {
        String target = "BBC ABCDAB ABCDABCDABDE";
        String seek = "ABCDABD";
        target.contains(seek);
        kmp(target,seek);
    }

    static void kmp(String target, String seek){
        char []tar = target.toCharArray();
        char []se = seek.toCharArray();
        if(tar.length <= se.length){
            return;
        }

        int j = 0;
        int i = 0;
        int t = 0;
        int num = 0;
        while(j < se.length){
            if(tar[i] == se[j]){
                if(j == 0){
                    t = i;
                }
                j ++;
                i ++;
            }else{
                if(j > 1){
                    i = t+j-kmpArr[j-1];
//                    i-=kmpArr[j-1];
                }else{
                    i ++;
                }
                j = 0;
            }
            num ++;
        }
        System.out.println(num);
    }
}
