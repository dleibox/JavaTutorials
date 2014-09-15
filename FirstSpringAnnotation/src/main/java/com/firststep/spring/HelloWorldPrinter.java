package com.firststep.spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by daniel on 9/15/2014.
 */
@Component
public class HelloWorldPrinter {
    HelloWorldService service;

    @Autowired
    public HelloWorldPrinter(HelloWorldService service){
        this.service = service;
    }

    public void printHelloWorld(){
        System.out.println(service.sayHello() + " (" + service.hashCode() + ")");
    }
}
