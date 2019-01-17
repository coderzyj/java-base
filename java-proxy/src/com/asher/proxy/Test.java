package com.asher.proxy;

/**
 * 版权声明：CopyRight (c) 2018 ucarinc. All Rights Reserved.
 *
 * @author : 张勇杰
 * @date : 2019/1/17 21:03
 * @Version : v1.0
 * @description
 **/
public class Test {
    public static void main(String[] args) {
        Student sd = (Student) new ProxyStudent().getProxyInstance(new XiaoMing());
        sd.say();
    }
}
