package com.devin.interview.interceptor;

import brave.Tracer;
import feign.RequestInterceptor;
import feign.RequestTemplate;
import org.springframework.context.annotation.Configuration;

import javax.annotation.Resource;

/**
 * @author Devin Zhang
 * @className InterceptorConfig
 * @description TODO
 * @date 2020/6/20 13:49
 */
@Configuration
public class TraceRequestInterceptor implements RequestInterceptor {

    private static final String FEIGN_REQUEST = "FEIGN_REQUEST";

    @Resource
    private Tracer tracer;

    @Override
    public void apply(RequestTemplate requestTemplate) {
        //feign 调用时产生一个tranceId，该traceId将在整个链路传递
        requestTemplate.header(FEIGN_REQUEST, tracer.currentSpan().context().traceIdString());
    }
}
