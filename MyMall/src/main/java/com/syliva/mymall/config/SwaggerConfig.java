package com.syliva.mymall.config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.core.env.Profiles;
import springfox.documentation.builders.ParameterBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.schema.ModelRef;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.service.Parameter;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;
import java.util.List;

@Configuration
@EnableSwagger2//开启swagger2
public class SwaggerConfig {
    @Bean
    public Docket docket1(){
        return new Docket(DocumentationType.SWAGGER_2).groupName("a");
    }


    @Bean
    public Docket docket(Environment environment){
        //设置要显示的环境
        Profiles profiles = Profiles.of("dev,test");
        //判断是否处在设置要显示的环境中
        boolean flag = environment.acceptsProfiles(profiles);


        return new Docket(DocumentationType.SWAGGER_2)
                .groupName("我的")
                .apiInfo(apiInfo())
                // .enable(false)是否启用swagger
                .enable(true)
                .select()
                //RequestHandlerSelectors 配置要扫描接口的方式
                //basePackage 指定要扫描的包
                //ang()扫描所有包
                //none()不扫描包
                //withMethodAnnotation 扫描方法上的注解
                //withClassAnnotation 扫描类上的注解
                .apis(RequestHandlerSelectors.basePackage("com.syliva.mymall.controller"))
                //.paths() 过滤路径上的类
                .paths(PathSelectors.any())
                .build();

    }
    private ApiInfo apiInfo(){

        Contact contact = new  Contact("我的","localhost:8080", "2792772385@qq.com");
        return new ApiInfo("我的swagger学习","学无止境","1.0","urn:tos",contact, "Apache 2.0", "http://www.apache.org/licenses/LICENSE-2.0", new ArrayList());
    }



}
