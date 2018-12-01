package com.zyj.javassist;

/**
 * 版权声明：CopyRight (c) 2018 ucarinc. All Rights Reserved.
 *
 * @author : 张勇杰
 * @date : 2018/12/1 13:39
 * @Version : v1.0
 * @description
 **/
public class Emp {
    private String empno;
    private String ename;
    public void sayHello(int a){
        System.out.println("sayHello"+a);
    }

    public Emp(String empno, String ename) {
        this.empno = empno;
        this.ename = ename;
    }

    public Emp() {
    }

    public String getEmpno() {
        return empno;
    }

    public void setEmpno(String empno) {
        System.out.println("1222");
        this.empno = empno;
    }

    public String getEname() {
        return ename;
    }

    public void setEname(String ename) {
        this.ename = ename;
    }
}
