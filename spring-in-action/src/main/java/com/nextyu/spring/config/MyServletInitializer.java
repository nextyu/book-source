package com.nextyu.spring.config;

import com.nextyu.spring.web.servlet.MyServlet;
import org.springframework.web.WebApplicationInitializer;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

/**
 * created on 2016-11-07 11:42
 *
 * @author nextyu
 */
public class MyServletInitializer implements WebApplicationInitializer {
    @Override
    public void onStartup(ServletContext servletContext) throws ServletException {
        ServletRegistration.Dynamic myServlet = servletContext.addServlet("myServlet", MyServlet.class);
        myServlet.addMapping("/custom/**");
    }
}
