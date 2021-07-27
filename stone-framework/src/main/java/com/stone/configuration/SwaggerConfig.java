package com.stone.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @Author: stone
 * @Date: 2021/3/22 17:37
 * @Version 1.0
 */
@Configuration
@ComponentScan(basePackages = {"com.stone.controller"}) // 配置controller路径
@EnableSwagger2   //开启Swagger2
public class SwaggerConfig {
    @Bean
    public Docket createRestApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.stone"))//扫描com路径下的api文档
                .paths(PathSelectors.any())//路径判断,这里是任何路径
                .build();
    }

    private ApiInfo apiInfo()  {
        //配置swagger信息
        return new ApiInfoBuilder()
                .title("SWAGGER"  + " RESTful APIs")
                .description("")
                .termsOfServiceUrl("")
                .contact(new Contact("stone", "", ""))
                .version("1.0")
                .build();
    }
}
