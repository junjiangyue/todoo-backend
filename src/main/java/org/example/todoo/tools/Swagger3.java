package org.example.todoo.tools;

import io.swagger.annotations.ApiOperation;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.*;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spi.service.contexts.SecurityContext;
import springfox.documentation.spring.web.plugins.Docket;

import java.util.Collections;

@Configuration
public class Swagger3 {
    @Bean
    public Docket createRestApi() {
//        return new Docket(DocumentationType.SWAGGER_2)
//                .apiInfo(apiInfo())
//                //是否开启 (true 开启  false隐藏。生产环境建议隐藏)
////                .enable(false)
//                .select()
//                //扫描的路径包,设置basePackage会将包下的所有被@Api标记类的所有方法作为api
//                //.apis(RequestHandlerSelectors.basePackage("com.huaqi.zhanxin.controller"))
//                .apis(RequestHandlerSelectors.withMethodAnnotation(ApiOperation.class))
//                //配置如何通过path过滤，指定路径处理PathSelectors.any()代表所有的路径
//                .paths(PathSelectors.any())
//                .build();
        return new Docket(DocumentationType.OAS_30)
                .apiInfo(apiInfo())
                .securitySchemes(Collections.singletonList(HttpAuthenticationScheme.JWT_BEARER_BUILDER
                        //显示用
                        .name("JWT")
                        .build()))
                .securityContexts(Collections.singletonList(SecurityContext.builder()
                        .securityReferences(Collections.singletonList(SecurityReference.builder()
                                .scopes(new AuthorizationScope[0])
                                .reference("JWT")
                                .build()))
                        // 声明作用域
                        .operationSelector(o -> o.requestMappingPattern().matches("/.*"))
                        .build()))
                .select()
                .apis(RequestHandlerSelectors.withMethodAnnotation(ApiOperation.class))
                .paths(PathSelectors.any())
                .build();
    }

    private ApiInfo apiInfo() {
        //return new ApiInfoBuilder()
//                //设置文档标题(API名称)
//                .title("ZhanXin API 文档")
//                //文档描述
//                .description("此API文档使用于前后端分离开发，后端进行了接口变更，不需要更新接口文档，前端可以实时查看接口变更！")
//                .contact(new Contact("联系人名字", "http://xxx.xxx.com/联系人访问链接", "联系人邮箱"))
//                //版本号
//                .version("1.0.0")
//                .build();
        return new ApiInfoBuilder()
                .title("todoo接口文档")
                .description("欢迎您")
                .contact(new Contact("todoo", "http://localhost:8080/swagger-ui/index.html#/", "1216951219@qq.com"))
                .version("1.0")
                .build();
    }
}