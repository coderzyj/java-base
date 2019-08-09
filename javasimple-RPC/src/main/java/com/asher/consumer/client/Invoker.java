package com.asher.consumer.client;

import java.io.Serializable;

/**
 * @author : 张勇杰
 * @date : 2019/8/9 15:39
 * @Version : v1.0
 * @description
 **/
public class Invoker implements Serializable {
    private String serviceName;

    private String methodName;

    private Class[] parameterTypes;

    private Object[] parameter;

    public Invoker(String serviceName, String methodName, Class[] parameterTypes, Object[] parameter) {
        this.serviceName = serviceName;
        this.methodName = methodName;
        this.parameterTypes = parameterTypes;
        this.parameter = parameter;
    }

    public String getServiceName() {
        return serviceName;
    }

    public void setServiceName(String serviceName) {
        this.serviceName = serviceName;
    }

    public String getMethodName() {
        return methodName;
    }

    public void setMethodName(String methodName) {
        this.methodName = methodName;
    }

    public Class[] getParameterTypes() {
        return parameterTypes;
    }

    public void setParameterTypes(Class[] parameterTypes) {
        this.parameterTypes = parameterTypes;
    }

    public Object[] getParameter() {
        return parameter;
    }

    public void setParameter(Object[] parameter) {
        this.parameter = parameter;
    }
}
