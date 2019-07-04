package com.asher.stream.test;

import java.util.Date;

public interface DemoInterface {
    default void now(){
        System.out.println(new Date());
    }
}
