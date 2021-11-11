package com.example.shop_detail.config;

import org.apache.catalina.connector.RequestFacade;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

@Component
@Order(Ordered.HIGHEST_PRECEDENCE)//控制过滤器的级别
@WebFilter(urlPatterns = "/*", filterName = "requestFilter")
public class HttpServletFilter implements Filter {


    @Override
    public void init(FilterConfig filterConfig) {
    }
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        ServletRequest requestWrapper = null;
        if(request instanceof HttpServletRequest) {
            HttpServletRequest request1 = (HttpServletRequest) request;
            if (request1.getRequestURI().contains("upload")) {
                chain.doFilter(request, response);
                return;
            }
            requestWrapper = new RequestWrapper(request1);
        }
        if(requestWrapper == null) {
            chain.doFilter(request, response);
        } else {
            chain.doFilter(requestWrapper, response);
        }
    }
    @Override
    public void destroy() {

    }
}
