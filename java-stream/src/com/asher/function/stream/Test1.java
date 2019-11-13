package com.asher.function.stream;

/**
 * @author : 张勇杰
 * @date : 2019/10/30 18:13
 * @Version : v1.0
 * @description
 **/
public class Test1 implements Cloneable{
    public static void main(String[] args) throws CloneNotSupportedException {
        Test1 t = new Test1();
        Object clone = t.clone();
        System.out.println(t);
        System.out.println(clone);
    }
    void method1(Test<? extends Fu> test){
//        test.setT(new Fu1());
        Fu t = test.getT();
    }

    void method2(Test<? super Zi> test){
        test.setT(new Zi1());
        test.getT();
    }
}
class Test<T>{
    T t;

    public T getT() {
        return t;
    }

    public void setT(T t) {
        this.t = t;
    }
}
class Zi1 extends Zi{}
class Zi extends Fu{}
class Fu extends Fu1{}
class Fu1{}
