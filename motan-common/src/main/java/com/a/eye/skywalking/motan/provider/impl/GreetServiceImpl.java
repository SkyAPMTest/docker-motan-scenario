package com.a.eye.skywalking.motan.provider.impl;

import com.a.eye.skywalking.motan.provider.GreetService;

/**
 * Created by xin on 2016/12/7.
 */
public class GreetServiceImpl implements GreetService {
    public String sayHello() {
        return "it works.";
    }
}
