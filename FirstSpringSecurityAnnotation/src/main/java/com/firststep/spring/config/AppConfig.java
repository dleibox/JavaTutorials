package com.firststep.spring.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

/**
 * Created by daniel on 9/19/2014.
 *
 * equivalent in mvc-servlet.xml
 *
 <context:component-scan base-package="com.mkyong.web.*" />

 <bean class="org.springframework.web.servlet.view.InternalResourceViewResolver">
 <property name="prefix">
 <value>/WEB-INF/views/</value>
 </property>
 <property name="suffix">
 <value>.jsp</value>
 </property>
 </bean>

 */
@EnableWebMvc
@Configuration
@ComponentScan({ "com.firststep.spring.*" })
@Import({ SecurityConfig.class })
public class AppConfig {

    @Bean
    public InternalResourceViewResolver viewResolver() {
        InternalResourceViewResolver viewResolver
                = new InternalResourceViewResolver();
        viewResolver.setViewClass(JstlView.class);
        viewResolver.setPrefix("/WEB-INF/views/");
        viewResolver.setSuffix(".jsp");
        return viewResolver;
    }
}
