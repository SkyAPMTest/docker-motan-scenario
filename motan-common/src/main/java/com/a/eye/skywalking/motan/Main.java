package com.a.eye.skywalking.motan;

import java.io.IOException;

/**
 * Created by xin on 2016/12/7.
 */
public class Main {
    public static void main(String[] args) throws IOException {
        ProviderServer.startServer();
        ConsumerHttpServer.startServer();
    }
}
