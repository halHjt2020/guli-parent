package com.atguigu.guli.service.base.config;


import com.google.common.base.Predicates;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import javax.swing.text.Document;

@Configuration
@EnableSwagger2
public class Swagger2Config {

    @Bean
    public Docket adminApiConfig(){
        return new Docket(DocumentationType.SWAGGER_2)
                .groupName("adminApi")
                .apiInfo(adminApiInfo())
                .select()
                .paths(Predicates.and((PathSelectors.regex("/admin/.*"))))
                .build();
    }

    @Bean
    public Docket webApiConfig(){
        return new Docket(DocumentationType.SWAGGER_2)
                .groupName("webApi")
                .apiInfo(webApiInfo())
                .select()
                .paths(Predicates.and((PathSelectors.regex("/api/.*"))))
                .build();

    }

    private ApiInfo adminApiInfo() {
        return new ApiInfoBuilder().
                title("谷粒学院运营系统API文档").
                description(".........").
                version("0.0.1-snapshot").
                contact(new Contact("Helen","http://atguigu.com","617626141@qq.com")).build();
    }
    private ApiInfo webApiInfo() {
        return new ApiInfoBuilder().
                title("谷粒学院API文档").
                description(".........").
                version("0.0.1-snapshot").
                contact(new Contact("Helen","http://atguigu.com","617626141@qq.com")).build();
    }

}
