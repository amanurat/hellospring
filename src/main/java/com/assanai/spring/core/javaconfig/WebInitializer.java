package com.assanai.spring.core.javaconfig;

import org.springframework.web.WebApplicationInitializer;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;

public class WebInitializer implements WebApplicationInitializer {

	public void onStartup(ServletContext servletContext) throws ServletException {
		
	/*	AnnotationConfigWebApplicationContext context = new AnnotationConfigWebApplicationContext();  
		context.register(JavaConfig.class);  		
		context.setServletContext(servletContext); 
		Dynamic servlet = servletContext.addServlet("DispatcherServlet", new DispatcherServlet(context));
		servlet.addMapping("/");
		servlet.setLoadOnStartup(1);*/

		
	}
	
	

}
