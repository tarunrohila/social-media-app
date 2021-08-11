package com.rohila.api.config;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;
import com.rohila.api.exception.CoreExceptionHandler;
import com.rohila.api.serializer.DataFilter;
import com.rohila.api.util.JsonUtils;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.function.Predicate;

import static com.sun.javafx.fxml.expression.Expression.or;
import static springfox.documentation.builders.PathSelectors.regex;

/**
 * Class which is used to provide configuration beans to Social Media App
 *
 * @author Tarun Rohila
 */
@Configuration
@EnableSwagger2
public class AppConfig {

    /**
     * Method to create bean for exception handler
     *
     * @return default core exception handler
     */
    @Bean
    public CoreExceptionHandler getCoreExceptionHandler() {
        return new CoreExceptionHandler();
    }

    /**
     * Method to customize object mapper with configuration
     *
     * @return objectMapper
     */
    @Bean
    @Primary
    public ObjectMapper objectMapper() {
        ObjectMapper mapper = JsonUtils.getObjectMapper();
        mapper.setFilterProvider(new SimpleFilterProvider().addFilter("DataFilter", new DataFilter()));
        // To enable controller advice processing of null when return type is object
        mapper.disable(SerializationFeature.FAIL_ON_EMPTY_BEANS);
        // To exlude from response fields with null or not populated value
        mapper.setSerializationInclusion(JsonInclude.Include.NON_ABSENT);
        return mapper;
    }

    /**
     * Method to configure swagger
     * @return api swagger
     */
    @Bean
    public Docket swaggerConfig() {
        return new Docket(DocumentationType.SWAGGER_2).select()
                .apis(RequestHandlerSelectors.any())
                .paths(PathSelectors.any())
                .build().apiInfo(apiInfo());
    }

    /**
     * MEthod to add api info for swagger documentation
     * @return api info
     */
    private ApiInfo apiInfo() {
        return new ApiInfoBuilder().title("Social Media APP")
                .description("Social Media APP")
                .contact(new Contact("Tarun", "http://localhost:8080", "tarunrohila@gmail.com")).version("1.0").build();
    }

}
