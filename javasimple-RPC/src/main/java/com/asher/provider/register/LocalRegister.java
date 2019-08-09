package com.asher.provider.register;

import java.util.HashMap;
import java.util.Map;

/**
 * @author : 张勇杰
 * @date : 2019/8/9 11:49
 * @Version : v1.0
 * @description
 **/
public class LocalRegister{
    private static Map<String,Class<?>> SERVICE_INF = new HashMap<String, Class<?>>(16);


    public static void register(String interfaceName, Class interfaceImpl){
        SERVICE_INF.put(interfaceName,interfaceImpl);
    }

    public static Class get(String interfaceName){
        return SERVICE_INF.get(interfaceName);
    }

}
