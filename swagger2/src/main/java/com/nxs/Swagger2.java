package com.nxs;

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
 * 通过@Configuration注解，让Spring来加载该类配置
 * 再通过@EnableSwagger2注解来启用Swagger2
 */
@Configuration
@EnableSwagger2
public class Swagger2 {

    /**
     * 通过createRestApi函数创建Docket的Bean
     * @return
     */
    public Docket createRestApi(){
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                /**
                 * //select()函数返回一个ApiSelectorBuilder实例用来控制哪些接口暴露给Swagger来展现，
                 * 本例采用指定扫描的包路径来定义，Swagger会扫描该包下所有Controller定义的API，并产生文档内容（除了被@ApiIgnore指定的请求）
                 */
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.nxs"))
                .paths(PathSelectors.any())
                .build();
    }

    /**
     * apiInfo()用来创建该Api的基本信息（这些基本信息会展现在文档页面中）。
     * @return
     */
    private ApiInfo apiInfo(){
        Contact contact = new Contact("聂孝爽", "http://jonenxs.com", "niexiaoshuang@gmail.com");
        return new ApiInfoBuilder()
                .title("Spring Boot中使用Swagger2构建RESTful APIs")
                .description("更多Spring Boot相关文章请关注：http://blog.didispace.com/")
                .termsOfServiceUrl("http://blog.didispace.com/")
                .contact(contact)
                .version("1.0")
                .build();
    }
}
