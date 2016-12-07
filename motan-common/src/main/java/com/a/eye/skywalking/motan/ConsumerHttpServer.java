package com.a.eye.skywalking.motan;

import com.a.eye.skywalking.motan.provider.GreetService;
import fi.iki.elonen.NanoHTTPD;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.IOException;
import java.util.Map;

/**
 * Created by xin on 2016/12/5.
 */
public class ConsumerHttpServer extends NanoHTTPD {

    private static Logger logger = LoggerFactory.getLogger(ConsumerHttpServer.class);
    private static ClassPathXmlApplicationContext applicationContext;

    private ConsumerHttpServer() throws IOException {
        super(8080);
        start(NanoHTTPD.SOCKET_READ_TIMEOUT, true);
    }

    @Override
    public Response serve(IHTTPSession session) {
        try {
            String msg = "<html><body>\n";
            Map<String, String> parms = session.getParms();
            msg += "<p>Hello, " + applicationContext.getBean(GreetService.class).sayHello() + "!</p>";
            return newFixedLengthResponse(msg + "</body></html>\n");
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("Failed to generate result page.", e);
        }
        return newFixedLengthResponse("Failed");
    }

    public static void startServer() throws IOException {
        applicationContext = new ClassPathXmlApplicationContext("classpath*:motan_client.xml");
        applicationContext.start();
        new ConsumerHttpServer();
    }
}
