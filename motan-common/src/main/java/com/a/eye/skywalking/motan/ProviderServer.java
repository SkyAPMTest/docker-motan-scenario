package com.a.eye.skywalking.motan;

import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by xin on 2016/12/5.
 */
public class ProviderServer extends Thread {

    private static ProviderServer providerServer = new ProviderServer();

    private ProviderServer() {
        super("dubbo provider");
    }

    @Override
    public void run() {
        try {
            ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("classpath*:motan_server.xml");
            context.start();

            while (true) {
                try {
                    Thread.sleep(60 * 60 * 1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        } finally {
            System.exit(-1);
        }
    }

    public static void startServer() {
        providerServer.start();
    }
}
