package com.example.shop_detail.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebCustomConfiguration implements WebMvcConfigurer {

    /**
     * 具体将拦截器注入的方法实现
     * @param registry
     */
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new TokenInterceptor())
                .addPathPatterns("/**")
                .excludePathPatterns("/index/loginIn")
                .excludePathPatterns("/index/login")
                .excludePathPatterns("/js/**")
                .excludePathPatterns("/css/**");
    }


}
