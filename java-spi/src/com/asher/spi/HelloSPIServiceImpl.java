package com.asher.spi;

/**
 * @author : 张勇杰
 * @date : 2019/8/9 11:00
 * @Version : v1.0
 * @description
 **/
public class HelloSPIServiceImpl implements HelloSpiService{
    @Override
    public void sayHelloToSPI() {
        System.out.println("hello,SPI!!");
    }
}
