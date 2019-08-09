package com.asher.spi;

import java.util.Iterator;
import java.util.ServiceLoader;

/**
 * @author : 张勇杰
 * @date : 2019/8/9 11:01
 * @Version : v1.0
 * @description
 **/
public class TestMain {
    public static void main(String[] args) {
        ServiceLoader<HelloSpiService> sl = ServiceLoader.load(HelloSpiService.class);
        Iterator<HelloSpiService> iterator = sl.iterator();
        while(iterator.hasNext()){
            HelloSpiService hss = iterator.next();
            hss.sayHelloToSPI();
        }
    }
}
