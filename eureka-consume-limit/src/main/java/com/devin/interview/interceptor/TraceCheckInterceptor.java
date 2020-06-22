package com.devin.interview.interceptor;


import brave.Tracer;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;

/**
 * @author Devin Zhang
 * @className TraceCheckInterceptor
 * @description TODO
 * @date 2020/6/20 14:02
 */

public class TraceCheckInterceptor extends HandlerInterceptorAdapter {

    private static final String FEIGN_REQUEST = "FEIGN_REQUEST";


    public Tracer getTracer(HttpServletRequest request) {
        WebApplicationContext requiredWebApplicationContext = WebApplicationContextUtils.getRequiredWebApplicationContext(request.getServletContext());
        return requiredWebApplicationContext.getBean(Tracer.class);
    }

    @Override
    public boolean preHandle(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response, Object handler) throws Exception {
        System.out.println(request.getRequestURI());
        Tracer tracer = getTracer(request);
        String traceId = request.getHeader(FEIGN_REQUEST);
        //只有是feign发起的请求才放过，其他的都做拦截
        if (traceId != null && traceId.equals(tracer.currentSpan().context().traceIdString())) {
            System.out.println("微服务调用，校验通过");
            return true;
        }
        System.out.println("不是微服务调用，没有权限");
        response.getWriter().write("no auth");
        return false;
    }
}
