package com.myApp.concurrency.filter;

import com.myApp.concurrency.threadLocal.RequestHolder;
import org.springframework.http.HttpRequest;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

public class HttpFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest,
                         ServletResponse servletResponse,
                         FilterChain filterChain) throws IOException, ServletException {
        //获得请求
        HttpServletRequest httpServletRequest = (HttpServletRequest) servletRequest;
        //打印当前线程的ID与请求路径
        System.out.println("Thread Number is:" + Thread.currentThread().getId());
        System.out.println("servletPath is :" + httpServletRequest.getServletPath());
        //将当前线程ID添加到ThreadLocal中
        RequestHolder.add(Thread.currentThread().getId());
        filterChain.doFilter(servletRequest,servletResponse);
    }

    @Override
    public void destroy() {

    }
}
