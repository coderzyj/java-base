package com.asher.provider.server;

import com.asher.consumer.client.Invoker;
import com.asher.consumer.client.URL;
import com.asher.provider.register.LocalRegister;
import com.asher.provider.register.RemoteRegister;

import javax.servlet.ServletException;
import javax.servlet.ServletInputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.lang.reflect.Method;

/**
 * @author : 张勇杰
 * @date : 2019/8/9 11:35
 * @Version : v1.0
 * @description
 **/
public class DispatcherServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            ServletInputStream is = req.getInputStream();
            ObjectInputStream pis = new ObjectInputStream(is);
            Invoker invoker = (Invoker) pis.readObject();
            Class target = LocalRegister.get(invoker.getServiceName());
            Method method = target.getMethod(invoker.getMethodName(),invoker.getParameterTypes());
            method.invoke(target.newInstance(),invoker.getParameter());
        } catch (Exception e) {
            e.printStackTrace();
        }
        super.service(req, resp);
    }
}
