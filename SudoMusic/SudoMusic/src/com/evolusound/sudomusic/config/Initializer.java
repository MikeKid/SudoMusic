package com.evolusound.sudomusic.config;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration.Dynamic;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

public class Initializer implements WebApplicationInitializer {
	
	@Override
	public void onStartup(ServletContext servletContext) throws ServletException {  
        AnnotationConfigWebApplicationContext ctx = new AnnotationConfigWebApplicationContext();  
        ctx.register(AppConfiguration.class);  
        ctx.setServletContext(servletContext);    
        Dynamic dynamic = servletContext.addServlet("dispatcher", new DispatcherServlet(ctx));
        dynamic.setLoadOnStartup(1);
        dynamic.addMapping("/");
    }
}


/*
 * 
 * WEB.XML

<?xml version="1.0" encoding="UTF-8"?>
<beans xmlns="http://www.springframework.org/schema/beans"
	xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance" xmlns:p="http://www.springframework.org/schema/p"
	xmlns:context="http://www.springframework.org/schema/context"
	xsi:schemaLocation="http://www.springframework.org/schema/beans
 
http://www.springframework.org/schema/beans/spring-beans-4.0.xsd
http://www.springframework.org/schema/context 
http://www.springframework.org/schema/context/spring-context-4.0.xsd">
 
	<context:component-scan base-package="com.evolusound.sudomusic" />
 
	<bean id="viewResolver"
		class="org.springframework.web.servlet.view.UrlBasedViewResolver">
		<property name="viewClass"
			value="org.springframework.web.servlet.view.JstlView" />
		<property name="prefix" value="/WEB-INF/jsp/" />
		<property name="suffix" value=".jsp" />
	</bean>
</beans>
 * 
 */

/*
 * 
 * SUDOMUSIC-SERVLET.XML

<?xml version="1.0" encoding="UTF-8"?>
<web-app xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance" xmlns="http://java.sun.com/xml/ns/javaee" xsi:schemaLocation="http://java.sun.com/xml/ns/javaee http://java.sun.com/xml/ns/javaee/web-app_3_0.xsd" version="3.0">
  <display-name>SudoMusic</display-name>
  <welcome-file-list>
    <welcome-file>index.jsp</welcome-file>
  </welcome-file-list>
  <servlet>
    <servlet-name>sudomusic</servlet-name>
    	<servlet-class>
            org.springframework.web.servlet.DispatcherServlet
        </servlet-class>
    <load-on-startup>1</load-on-startup>
  </servlet>
  <servlet-mapping>
    <servlet-name>sudomusic</servlet-name>
    <url-pattern>/welcome</url-pattern>
    <url-pattern>/login</url-pattern>
    <url-pattern>/register</url-pattern>
    <url-pattern>/contactForm</url-pattern>
    
    <!-- To be deleted -->
    <url-pattern>/error</url-pattern>
    
  </servlet-mapping>
  
  <error-page>
    <exception-type>java.lang.Exception</exception-type>
    <location>/error</location>
  </error-page>
  
</web-app>
 * 
 */