package com.firststep.app;

import com.firststep.spring.HelloWorldPrinter;
import com.firststep.spring.HelloWorldService;
import com.firststep.spring.ServiceBeans;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Created by daniel on 9/17/2014.
 */
public class Application {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(ServiceBeans.class, HelloWorldPrinter.class);
        HelloWorldService service = context.getBean(HelloWorldService.class);
        String hello = service.sayHello();
        System.out.println("Bean: (" + service.hashCode() + ") " + hello);

        HelloWorldPrinter printer = context.getBean(HelloWorldPrinter.class);
        printer.printHelloWorld();
    }
}
