package com.asher.test;

/**
 * @author : 张勇杰
 * @date : 2019/9/17 17:44
 * @Version : v1.0
 * @description
 **/
public class FourMi {
    public static void main(String[] args) {
//        FourMi f = new FourMi();
//        System.out.println(f.isPowerOfFour(1048576));
//        System.out.println(4 << 28);
        FourMi f = new FourMi();
        f.d0();

    }
    public void d0(){
        A a = new C();
        A b = new D();
        System.out.println(a.getClass());
        System.out.println(A.class);
        System.out.println(a instanceof B);
        System.out.println(b instanceof B);
        System.out.println(A.class.isAssignableFrom(a.getClass()));
        System.out.println(B.class.isAssignableFrom(a.getClass()));
        System.out.println(A.class.isAssignableFrom(b.getClass()));
        System.out.println(B.class.isAssignableFrom(b.getClass()));
    }


    public boolean isPowerOfFour(int num) {
        switch (num){
            case 1:
                return true;
            case 4 << 0:
                return true;
            case 4 << 2:
                return true;
            case 4 << 4:
                return true;
            case 4 << 6:
                return true;
            case 4 << 8:
                return true;
            case 4 << 10:
                return true;
            case 4 << 12:
                return true;
            case 4 << 14:
                return true;
            case 4 << 16:
                return true;
            case 4 << 18:
                return true;
            case 4 << 20:
                return true;
            case 4 << 22:
                return true;
            case 4 << 24:
                return true;
            case 4 << 26:
                return true;
            case 4 << 28:
                return true;
            default:
                return false;
        }
    }
}
interface  A{
    void say();
}

abstract class B implements A{

}

class C extends B{

    public void say() {
        System.out.println("ok");
    }
}
class D implements A{

    public void say() {
        System.out.println("ok");
    }
}
