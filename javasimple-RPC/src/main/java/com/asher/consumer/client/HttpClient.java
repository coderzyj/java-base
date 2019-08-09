package com.asher.consumer.client;

import com.asher.provider.service.HelloService;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;

/**
 * @author : 张勇杰
 * @date : 2019/8/9 11:55
 * @Version : v1.0
 * @description
 **/
public class HttpClient {
    public static void send(URL url){
        ObjectOutputStream oos = null;
        try {
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("POST");
            connection.setDoOutput(true);

            OutputStream os = connection.getOutputStream();
            oos = new ObjectOutputStream(os);
            Invoker invoker = new Invoker(HelloService.class.getName(),"sayHello",new Class[]{String.class},new Object[]{"zhangyongjie"});
            oos.writeObject(invoker);
            oos.flush();
            oos.close();

        } catch (IOException e) {
            e.printStackTrace();
        }finally {

        }
    }
}
