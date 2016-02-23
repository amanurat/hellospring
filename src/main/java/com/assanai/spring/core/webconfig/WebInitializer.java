package com.assanai.spring.core.webconfig;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.context.support.XmlWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

import javax.servlet.MultipartConfigElement;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

public class WebInitializer implements WebApplicationInitializer {

	/*public void onStartup(ServletContext servletContext) throws ServletException {
		
		AnnotationConfigWebApplicationContext context = new AnnotationConfigWebApplicationContext();
		context.register(WebConfig.class);
		context.setServletContext(servletContext); 
		ServletRegistration.Dynamic servlet = servletContext.addServlet("DispatcherServlet", new DispatcherServlet(context));
		servlet.addMapping("/");
		servlet.setLoadOnStartup(1);
	}
*/

	public void onStartup(ServletContext container) throws ServletException {
		/*XmlWebApplicationContext context = new XmlWebApplicationContext();
		context.setConfigLocation("/WEB-INF/spring/appServlet/servlet-context.xml");
		ServletRegistration.Dynamic dispatcher = container.addServlet("appServlet", new DispatcherServlet(context));

		MultipartConfigElement multipartConfigElement = new MultipartConfigElement(null, 5000000, 5000000, 0);
		dispatcher.setMultipartConfig(multipartConfigElement);
		dispatcher.setLoadOnStartup(1);
		dispatcher.addMapping("/");*/
	}
}