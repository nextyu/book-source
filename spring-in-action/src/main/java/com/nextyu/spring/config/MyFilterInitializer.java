package com.nextyu.spring.config;

import com.nextyu.spring.web.filter.MyFilter;
import org.springframework.web.WebApplicationInitializer;

import javax.servlet.FilterRegistration;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;

/**
 * created on 2016-11-07 11:48
 *
 * @author nextyu
 */
public class MyFilterInitializer implements WebApplicationInitializer {
    @Override
    public void onStartup(ServletContext servletContext) throws ServletException {
        FilterRegistration.Dynamic myFilter = servletContext.addFilter("myFilter", MyFilter.class);
        myFilter.addMappingForUrlPatterns(null, false, "/custom/*");
    }
}
