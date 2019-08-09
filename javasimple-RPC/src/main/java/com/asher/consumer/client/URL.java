package com.asher.consumer.client;

/**
 * @author : 张勇杰
 * @date : 2019/8/9 11:56
 * @Version : v1.0
 * @description
 **/
public class URL {
    private String hostName = "localhost";
    private int port = 8080;

    public URL() {
    }

    public URL(String hostName, int port) {
        this.hostName = hostName;
        this.port = port;
    }

    public String getHostName() {
        return hostName;
    }

    public void setHostName(String hostName) {
        this.hostName = hostName;
    }

    public int getPort() {
        return port;
    }

    public void setPort(int port) {
        this.port = port;
    }
}
