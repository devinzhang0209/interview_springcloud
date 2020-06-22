package com.devin.interview.config;

import com.devin.interview.interceptor.TraceCheckInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @author Devin Zhang
 * @className GlobalWebMvcConfigurer
 * @description TODO
 * @date 2020/6/20 15:18
 */
@Configuration
public class GlobalWebMvcConfigurer implements WebMvcConfigurer {

    @Bean
    public TraceCheckInterceptor traceCheckInterceptor() {
        return new TraceCheckInterceptor();
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        //约定好所有微服务请求都是以cloud开头
        registry.addInterceptor(traceCheckInterceptor()).addPathPatterns("/cloud/**");
    }
}
