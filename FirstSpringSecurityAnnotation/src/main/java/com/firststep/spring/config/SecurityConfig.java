package com.firststep.spring.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/**
 * Created by daniel on 9/19/2014.
 *
 * equivalent in spring-security.xml
 *
 <http auto-config="true">
 <intercept-url pattern="/admin**" access="ROLE_ADMIN" />
 <intercept-url pattern="/dba**" access="ROLE_ADMIN,ROLE_DBA" />
 </http>

 <authentication-manager>
 <authentication-provider>
 <user-service>
 <user name="test" password="1234" authorities="ROLE_USER" />
 <user name="admin" password="1234" authorities="ROLE_ADMIN" />
 <user name="dba" password="1234" authorities="ROLE_DBA" />
 </user-service>
 </authentication-provider>
 </authentication-manager>

 */
@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication().withUser("test").password("1234").roles("USER");
        auth.inMemoryAuthentication().withUser("admin").password("1234").roles("ADMIN");
        auth.inMemoryAuthentication().withUser("dba").password("1234").roles("DBA");
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {

        http.authorizeRequests()
            .antMatchers("/admin/**").access("hasRole('ROLE_ADMIN')")
            .antMatchers("/dba/**").access("hasRole('ROLE_ADMIN') or hasRole('ROLE_DBA')")
            .and().formLogin();

    }
}
