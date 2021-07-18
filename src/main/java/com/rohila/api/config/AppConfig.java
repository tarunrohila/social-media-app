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

/**
 * Class which is used to provide configuration beans to Social Media App
 *
 * @author Tarun Rohila
 */
@Configuration
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
}
