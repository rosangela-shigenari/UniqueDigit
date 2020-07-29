package com.inter.desafiodigitounico.configuration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@EnableSwagger2
@Configuration
public class SwaggerConfiguration {
    @Bean
    public Docket api() {
        Docket docket = new Docket(DocumentationType.SWAGGER_2);

        docket.select()
                .apis(RequestHandlerSelectors.basePackage( "com.inter.desafiodigitounico" ))
                .paths(PathSelectors.any())
                .build().apiInfo(apiInfo().build());

        return docket;
    }

    private ApiInfoBuilder apiInfo() {

        ApiInfoBuilder apiInfoBuilder = new ApiInfoBuilder();

        apiInfoBuilder.title("API Dígito Único");
        apiInfoBuilder.description("DESAFIO BANCO INTER: Api para cálculo de dígito único a partir de uma sequência de números " +
                                   "\n\n @Author: Rosangela Miyeko Shigenari \n\n Contact: r.shigenari@gmail.com");
        apiInfoBuilder.version("0.1 - SNAPSHOT");

        return apiInfoBuilder;

    }

}
