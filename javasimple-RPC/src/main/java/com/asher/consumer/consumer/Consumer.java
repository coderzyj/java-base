package com.asher.consumer.consumer;

import com.asher.consumer.client.HttpClient;

import java.net.MalformedURLException;
import java.net.URL;

/**
 * @author : 张勇杰
 * @date : 2019/8/9 11:56
 * @Version : v1.0
 * @description
 **/
public class Consumer {

    public static void main(String[] args) throws MalformedURLException {
        URL url = new URL("http","localhost",8080,"/");
        HttpClient.send(url);
    }
}
