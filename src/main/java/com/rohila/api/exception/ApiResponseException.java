package com.rohila.api.exception;

import com.rohila.api.response.Message;
import org.springframework.http.HttpStatus;

import java.util.List;

/**
 * Class file to create custom exception of {@link ApiResponseException}
 *
 * @author Tarun Rohila
 */
public class ApiResponseException extends ApiException {

    /**
     * Autogenerated serial version id
     */
    private static final long serialVersionUID = -1180392269986219782L;

    /**
     * Constructor declaration
     *
     * @param message - message
     */
    public ApiResponseException(Message message) {
        super(message);
    }

    /**
     * Constructor declaration
     *
     * @param message   - message
     * @param throwable - throwable
     */
    public ApiResponseException(Message message, Throwable throwable) {
        super(message, throwable);
    }

    /**
     * Constructor declaration
     *
     * @param messages - messages
     */
    public ApiResponseException(List<Message> messages) {
        super(messages);
    }

    /**
     * Method to get status
     *
     * @return status
     */
    @Override
    public HttpStatus getStatus() {
        return HttpStatus.INTERNAL_SERVER_ERROR;
    }
}
