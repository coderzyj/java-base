package com.asher.provider.register;

import com.asher.consumer.client.URL;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author : 张勇杰
 * @date : 2019/8/9 13:40
 * @Version : v1.0
 * @description
 **/
public class RemoteRegister {
    private static Map<String, List<URL>> REGISTER_INFO = new HashMap<String, List<URL>>(16);

    public static void register(String interfaceName, URL url){
        if(REGISTER_INFO.containsKey(interfaceName)){
            List<URL> urls = REGISTER_INFO.get(interfaceName);
            urls.add(url);
        }else{
            REGISTER_INFO.put(interfaceName, Collections.singletonList(url));
        }
    }

    public static URL get(String interfaceName){
        return REGISTER_INFO.get(interfaceName).get(0);
    }
}
