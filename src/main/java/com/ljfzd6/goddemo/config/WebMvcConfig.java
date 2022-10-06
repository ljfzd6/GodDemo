package com.ljfzd6.goddemo.config;


import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebMvcConfig implements WebMvcConfigurer {

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        //自定义路径mypic，  addResourceLocations指定访问资源所在目录
//        registry.addResourceHandler("/mypic/**").addResourceLocations("file:C:\\Users\\Administrator\\Desktop\\images1\\");
        //自定义路径webjars访问，addResourceLocations映射该路径下的资源，resourceChain资源链
        registry.addResourceHandler("/videos").addResourceLocations("file:"+"classpath:/resources/videos/").resourceChain(true);
        registry.addResourceHandler("/user").addResourceLocations("file:"+"classpath:/resources/user/").resourceChain(true);
    }
}