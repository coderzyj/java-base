package com.asher.provider.provider;

import com.asher.consumer.client.URL;
import com.asher.provider.register.LocalRegister;
import com.asher.provider.register.RemoteRegister;
import com.asher.provider.server.HttpServer;
import com.asher.provider.service.HelloService;
import com.asher.provider.service.HelloServiceImpl;

/**
 * @author : 张勇杰
 * @date : 2019/8/9 11:17
 * @Version : v1.0
 * @description
 **/
public class Provider {
    public static void main(String[] args) {
        //1.本地注册
        LocalRegister.register(HelloService.class.getName(), HelloServiceImpl.class);


        //2.远程注册

        RemoteRegister.register(HelloService.class.getName(),new URL("localhost",8080));

        //3.暴露服务（tomcatServer、netty）
        HttpServer server = new HttpServer();
        server.start("localhost",8080);
    }
}
