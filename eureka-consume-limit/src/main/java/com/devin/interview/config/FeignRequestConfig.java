package com.devin.interview.config;

import com.devin.interview.interceptor.TraceRequestInterceptor;
import org.springframework.context.annotation.Bean;

/**
 * @author Devin Zhang
 * @className FeignRequestConfig
 * @description Feign 请求时会默认走这个拦截器生成一个tranceId，这个tranceId将通过sleuth在整个链路传递
 * @date 2020/6/20 14:16
 */

public class FeignRequestConfig {

    /**
     * 全局feign请求拦截器，添加feign请求标识
     */
    @Bean
    TraceRequestInterceptor traceRequestInterceptor() {
        return new TraceRequestInterceptor();
    }
}
