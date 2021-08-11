package com.rohila.api.util;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.io.StringWriter;

/**
 * Class file to provide methods for json
 *
 * @author Tarun Rohila
 */
public class JsonUtils {

    /**
     * Logger declaration.
     */
    private static final Logger LOGGER = LogManager.getLogger(JsonUtils.class);

    private static ObjectMapper objectMapper = new ObjectMapper();

    /**
     * Method to convert object to json string
     *
     * @param object - object
     * @return object to string
     */
    public static String objectToJsonString(Object object) {
        return objectToJsonString(object, true);
    }

    /**
     * Method to convert object to string
     *
     * @param object - object
     * @param indent - indent
     * @return object to string
     */
    private static String objectToJsonString(Object object, boolean indent) {
        ObjectMapper mapper = getObjectMapper();
        if (indent) {
            mapper.enable(SerializationFeature.INDENT_OUTPUT);
        } else {
            mapper.disable(SerializationFeature.INDENT_OUTPUT);
        }
        StringWriter sw = new StringWriter();
        try {
            mapper.writeValue(sw, object);
        } catch (IOException e) {
            StringBuilder sb = new StringBuilder("Could not serialize date");
            if (object != null) {
                String className = object.getClass().getName();
                sb.append("when converting").append(className).append(" to JSON");
            }
            throw new RuntimeException(sb.toString(), e);
        }
        return sw.toString();
    }

    /**
     * Method to get instance of object mapper
     *
     * @return objectmapper
     */
    public static ObjectMapper getObjectMapper() {
        return objectMapper;
    }
}
