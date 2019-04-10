package com.mengxugu.springboot.config;

import com.mengxugu.springboot.component.MyLocaleResolver;
import com.mengxugu.springboot.interceptor.LoginHandlerInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Locale;

@Configuration
public class MySpringMvcConfigurer {

    @Bean
    public WebMvcConfigurer WebMvcConfigurer(){
        return new WebMvcConfigurer() {
            @Override
            public void addViewControllers(ViewControllerRegistry registry) {
                registry.addViewController("/").setViewName("main/login");
                registry.addViewController("index.html").setViewName("main/login");
                registry.addViewController("main.html").setViewName("main/index");
            }

            @Override
            public void addInterceptors(InterceptorRegistry registry) {
                registry.addInterceptor(new LoginHandlerInterceptor())
                .addPathPatterns("/**")
                .excludePathPatterns("/","/index.html","/login")
                .excludePathPatterns("/css/*","/js/*","/img/*");
            }
        };
    }

    @Bean
    public LocaleResolver LocaleResolver(){
        return new MyLocaleResolver();
    }
}
