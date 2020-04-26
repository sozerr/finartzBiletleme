package com.odev.biletleme.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {
    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select().apis(RequestHandlerSelectors.basePackage("com.odev.biletleme"))
                .paths(PathSelectors.any())
                .build()
                .enable(true)
                .apiInfo(metaData("Finartz"));
    }
    private ApiInfo metaData(String title) {

        return new ApiInfo(
                title,
                "Biletleme",
                "Api Specification For Airlines Ticket",
                "1.0",
                "","","");
    }
}
