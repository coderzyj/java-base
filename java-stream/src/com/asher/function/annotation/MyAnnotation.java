package com.asher.function.annotation;

import java.lang.annotation.*;

/**
 * 重复注解
 *
 */
@Repeatable(MyAnnotations.class)
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface MyAnnotation {
    String value()default "zhangyongjie";
}
