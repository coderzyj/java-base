package com.zyj.annotation;

/**
 * 版权声明：CopyRight (c) 2018 ucarinc. All Rights Reserved.
 *
 * @author : 张勇杰
 * @date : 2018/11/10 17:26
 * @Version : v1.0
 * @description
 **/
@ZyjTable("tb_Student")
@ZyjTable1("tb_Student1111")
public class Student {
    @ZyjField(columnName = "id",type="int",length=10)
    private int id;
    @ZyjField(columnName = "age",type="int",length = 3)
    private int age;
    @ZyjField(columnName = "sname",type="String",length = 10)
    private String name;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
