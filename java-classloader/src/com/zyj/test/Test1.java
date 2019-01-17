package com.zyj.test;

/**
 * 版权声明：CopyRight (c) 2018 ucarinc. All Rights Reserved.
 *
 * @author : 张勇杰
 * @date : 2018/12/6 15:51
 * @Version : v1.0
 * @description
 **/
public abstract class Test1 {
    protected String test01() throws Exception {
        throw new Exception("666");
    }
    protected String test02() throws Exception{
        String c = test01();
        return c;
    }
}
