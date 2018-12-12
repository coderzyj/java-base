package com.zyj.test;

/**
 * 版权声明：CopyRight (c) 2018 ucarinc. All Rights Reserved.
 *
 * @author : 张勇杰
 * @date : 2018/12/6 15:52
 * @Version : v1.0
 * @description
 **/
public class Test02 extends Test1 {
    @Override
    protected String test01() throws Exception {
        return "我才是返回值";
    }

    public static void main(String[] args) {
        Test02 test02 = new Test02();
        try {
            System.out.println(test02.test02());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
