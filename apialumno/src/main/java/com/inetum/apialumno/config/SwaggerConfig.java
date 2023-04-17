package com.inetum.apialumno.config;

import org.springframework.context.annotation.Bean;
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
 *
 Class SwaggerConfig (Esta clase es la configuración del swagger)
 * @author Celso Calla
 * @version 1.0
 * @since 2023-04-17
 */
@Configuration
@EnableSwagger2
public class SwaggerConfig {

    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(getApiInfo())
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.inetum.apialumno"))
                .paths(PathSelectors.ant("/api/**"))
                .build();
    }

    private ApiInfo getApiInfo() {
        return new ApiInfoBuilder()
                .title("Proyecto Inetum")
                .description("Microservicios")
                .version("1.0")
                .contact(new Contact("Software Engineer - Celso Calla", "#", ""))
                .license("")
                .licenseUrl("")
                .build();
    }
}
