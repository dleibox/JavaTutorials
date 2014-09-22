package com.firststep.spring.impl;

import com.firststep.spring.Hello;

/**
 * Created by daniel on 9/19/2014.
 */
public class HelloImpl implements Hello {

    @Override
    public String sayHello() {
        return "Hello Hello";
    }
}
