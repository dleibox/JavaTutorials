package com.firststep.spring.web.servlet;

import com.firststep.spring.HelloWorldService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by daniel on 9/15/2014.
 */
@Configuration
public class HelloWorldServlet extends HttpServlet {

    @Bean
    public HelloWorldService helloWorldService(){
        return new HelloWorldService() {
            @Override
            public String sayHello() {
                return "Hello Servlet World!";
            }
        };
    }

    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        WebApplicationContext context = WebApplicationContextUtils.getRequiredWebApplicationContext(getServletContext());
        HelloWorldService service = context.getBean(HelloWorldService.class);

        resp.getWriter().write("<html><body>" + service.sayHello() + "</body></html>");
    }
}
