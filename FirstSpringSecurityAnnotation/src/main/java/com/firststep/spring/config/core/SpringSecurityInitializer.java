package com.firststep.spring.config.core;

import org.springframework.security.web.context.AbstractSecurityWebApplicationInitializer;

/**
 * Created by daniel on 9/19/2014.
 *
 * equivalent in web.xml
 *
 <filter>
 <filter-name>springSecurityFilterChain</filter-name>
 <filter-class>org.springframework.web.filter.DelegatingFilterProxy
 </filter-class>
 </filter>

 <filter-mapping>
 <filter-name>springSecurityFilterChain</filter-name>
 <url-pattern>/*</url-pattern>
 </filter-mapping>
 */
public class SpringSecurityInitializer extends AbstractSecurityWebApplicationInitializer {
}
