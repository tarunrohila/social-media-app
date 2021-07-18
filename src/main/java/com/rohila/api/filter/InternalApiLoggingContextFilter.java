package com.rohila.api.filter;

import com.rohila.api.request.InternalRequestContext;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

/**
 * Class file to create {@link InternalApiLoggingContextFilter}
 *
 * @author Tarun Rohila
 */
@Component
@Order(10)
public class InternalApiLoggingContextFilter extends LoggingContextFilter {

    /** Logger declaration. */
    private static final Logger LOGGER = LogManager.getLogger(InternalApiLoggingContextFilter.class);

    /**
     * Method to get logging context properties
     *
     * @param request - request
     * @return logging context properties
     */
    @Override
    protected Map<String, String> getLoggingContextProperties(HttpServletRequest request) {
        Map<String, String> loggingContextProperties = new HashMap<>();
        if (StringUtils.hasText(request.getHeader(InternalRequestContext.CORRELATION_ID))) {
            LOGGER.debug(
                    "Adding [{}] header in logging context property header value is [{}]",
                    InternalRequestContext.CORRELATION_ID,
                    request.getHeader(InternalRequestContext.CORRELATION_ID));
            loggingContextProperties.put(InternalRequestContext.CORRELATION_ID, request.getHeader(
                    InternalRequestContext.CORRELATION_ID));
        }
        return loggingContextProperties;
    }
}
