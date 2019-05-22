package com.myApp.concurrency;

import com.myApp.concurrency.Interceptor.HttpInterceptor;
import com.myApp.concurrency.filter.HttpFilter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@SpringBootApplication
public class Application extends WebMvcConfigurerAdapter {
    //springboot的启动类Application中注册filter与Interceptor。要继承WebMvcConfigurerAdapter 类
    public static void main(String[] args) {
        SpringApplication.run(Application.class,args);
    }

    @Bean
    public FilterRegistrationBean httpFilter() {
        FilterRegistrationBean registrationBean = new FilterRegistrationBean();
        //设置过滤器
        registrationBean.setFilter(new HttpFilter());
        //设置要过滤的url
        registrationBean.addUrlPatterns("/threadLocal/*");
        return registrationBean;
    }

    //注册拦截器
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new HttpInterceptor()).addPathPatterns("/**");
    }
}
