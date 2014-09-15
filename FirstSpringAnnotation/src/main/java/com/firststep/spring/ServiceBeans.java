package com.firststep.spring;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * Created by daniel on 9/15/2014.
 */
@ComponentScan
@Configuration
public class ServiceBeans {

    @Bean
    public HelloWorldService helloWorldService(){
        return new HelloWorldService() {
            @Override
            public String sayHello() {
                return "Hello Spring World!";
            }
        };
    }
}
