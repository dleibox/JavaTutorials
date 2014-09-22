package com.firststep.spring;

import com.firststep.spring.impl.HelloImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * Created by daniel on 9/19/2014.
 */
@ComponentScan
@Configuration
public class Hello2Bean {

    @Bean
    public Hello2 getBean(){
        return new Hello2() {
            @Override
            public String sayHello() {
                return "Hello2 Hello2";
            }
        };
    }
}
