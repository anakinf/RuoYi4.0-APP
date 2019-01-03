package com.ruoyi.app.common.config;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.ruoyi.common.config.Global;

import io.swagger.annotations.ApiOperation;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.ApiKey;
import springfox.documentation.service.AuthorizationScope;
import springfox.documentation.service.Contact;
import springfox.documentation.service.SecurityReference;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spi.service.contexts.SecurityContext;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * Swagger2的接口配置
 * 
 * @author ruoyi
 */
@Configuration
@EnableSwagger2
public class SwaggerConfig
{
    /**
     * 创建API
     */
    @Bean
    public Docket createRestApi()
    {
        return new Docket(DocumentationType.SWAGGER_2).apiInfo(apiInfo()).forCodeGeneration(true).select()
                .apis(RequestHandlerSelectors.withMethodAnnotation(ApiOperation.class))
                // .apis(RequestHandlerSelectors.any())
                .paths(PathSelectors.regex("^.*(?<!error)$")).build().securitySchemes(securitySchemes())
                .securityContexts(securityContexts());
    }

    private List<ApiKey> securitySchemes()
    {
        List<ApiKey> apiKeyList = new ArrayList<ApiKey>();
        apiKeyList.add(new ApiKey("token", "token", "header"));
        return apiKeyList;
    }

    private List<SecurityContext> securityContexts()
    {
        List<SecurityContext> securityContexts = new ArrayList<>();
        securityContexts.add(SecurityContext.builder().securityReferences(defaultAuth())
                .forPaths(PathSelectors.regex("^(?!auth).*$")).build());
        return securityContexts;
    }

    List<SecurityReference> defaultAuth()
    {
        AuthorizationScope authorizationScope = new AuthorizationScope("global", "accessEverything");
        AuthorizationScope[] authorizationScopes = new AuthorizationScope[1];
        authorizationScopes[0] = authorizationScope;
        List<SecurityReference> securityReferences = new ArrayList<>();
        securityReferences.add(new SecurityReference("token", authorizationScopes));
        return securityReferences;
    }

    /**
     * 添加摘要信息
     */
    private ApiInfo apiInfo()
    {
        // 用ApiInfoBuilder进行定制
        return new ApiInfoBuilder().title("标题：若依管理系统_接口文档").description("描述：用于管理集团旗下公司的人员信息,具体包括XXX,XXX模块...")
                .contact(new Contact(Global.getName(), null, null)).version("版本号:" + Global.getVersion()).build();
    }
}
