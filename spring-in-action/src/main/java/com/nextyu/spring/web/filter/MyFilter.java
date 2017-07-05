package com.nextyu.spring.web.filter;

import javax.servlet.*;
import java.io.IOException;

/**
 * created on 2016-11-07 11:48
 *
 * @author nextyu
 */
public class MyFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        chain.doFilter(request, response);
    }

    @Override
    public void destroy() {

    }
}
