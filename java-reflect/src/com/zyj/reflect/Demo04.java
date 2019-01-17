package com.zyj.reflect;

import com.zyj.bean.User;

import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;
import java.util.Map;

/**
 * 版权声明：CopyRight (c) 2018 ucarinc. All Rights Reserved.
 *
 * @author : 张勇杰
 * @date : 2018/11/25 12:34
 * @Version : v1.0
 * @description
 **/
public class Demo04 {
    public void test01(Map<String,User> map, List<User> list){
        System.out.println("Demo04.test01");
    }

    public Map<Integer,User> test02(){
        System.out.println("Demo04.test02");
        return null;
    }

    public static void main(String[] args) throws NoSuchMethodException {
        Method m1 = Demo04.class.getMethod("test01",Map.class,List.class);
        Type []types = m1.getGenericParameterTypes();
        for(Type paramType:types){
            System.out.println("#"+paramType);
            if(paramType instanceof ParameterizedType){
                Type[] genericTypes = ((ParameterizedType) paramType).getActualTypeArguments();
                for(Type genericType:genericTypes){
                    System.out.println("泛型类型"+genericType);
                }
            }
        }

        Method m2 = Demo04.class.getMethod("test02");
        Type returnType = m2.getGenericReturnType();
        System.out.println(returnType);

        if(returnType instanceof ParameterizedType){
            Type[] genericTypes = ((ParameterizedType) returnType).getActualTypeArguments();
            for(Type t:genericTypes){
                System.out.println("--"+t);
            }
        }
    }
}
