/* Copyright (c) 2020 Rohila Technologies, All Rights Reserved.
 *
 * This code is confidential to Rohila Technologies and shall not be disclosed
 * outside the organisation without the prior written permission of the IT Director of
 * the organisation.
 *
 * In the event that such disclosure is permitted the code shall not be copied
 * or disclosed other than a need-to-know basis and any recipients may be
 * required to sign a confidentiality undertaking in favour of Rohila
 * Technologies.
 */

package com.rohila.api.constant;

import com.rohila.api.response.Message;

import static com.rohila.api.constant.ErrorCodes.*;

/**
 * Class which is used to keep constants for error messages  for Social Media App
 *
 * @author Tarun Rohila
 */
public class ErrorMessageConstants {

    /**
     * Private constructor
     */
    private ErrorMessageConstants() {
    }

    /**
     * Constant declaration for ARG_ZERO
     */
    public static final String ARG_ZERO = "${arg[0]}";

    /**
     * Constant declaration for ARG_ONE
     */
    public static final String ARG_ONE = "${arg[1]}";

    /**
     * Constant declaration for UNAUTHORIZED_ACCESS_ERROR
     */
    public static final Message UNAUTHORIZED_ACCESS_ERROR =
            Message.create(UNAUTHORIZED_ACCESS.getCode(), UNAUTHORIZED_ACCESS.getTitle());

    /**
     * Constant declaration for FORBIDDEN_ACCESS_ERROR
     */
    public static final Message FORBIDDEN_ACCESS_ERROR =
            Message.create(FORBIDDEN_ACCESS.getCode(), FORBIDDEN_ACCESS.getTitle());

    /**
     * Constant declaration for INTERNAL_SERVER_ERROR
     */
    public static final Message INTERNAL_SERVER_ERROR =
            Message.create(INTERNAL_SERVER.getCode(), INTERNAL_SERVER.getTitle());

    /**
     * Constant declaration for MISSING_MANDATORY_HEADERS_ERROR
     */
    public static final Message MISSING_MANDATORY_HEADERS_ERROR =
            Message.create(MISSING_MANDATORY_HEADERS.getCode(), MISSING_MANDATORY_HEADERS.getTitle(), "Mandatory header Correlation-ID is missing in the request.");

    /**
     * Constant declaration for CREATE_POST_ERROR
     */
    public static final Message CREATE_POST_ERROR =
            Message.create(CREATE_POST.getCode(), CREATE_POST.getTitle(), "Failed to create Post for user = ${arg[0]}");

    /**
     * Constant declaration for FOLLOW_USER_ERROR
     */
    public static final Message FOLLOW_USER_ERROR =
            Message.create(FOLLOW_USER.getCode(), FOLLOW_USER.getTitle(), "Failed to follow user = ${arg[0]} by = ${arg[1]}");

    /**
     * Constant declaration for UNFOLLOW_USER_ERROR
     */
    public static final Message UNFOLLOW_USER_ERROR =
            Message.create(UNFOLLOW_USER.getCode(), UNFOLLOW_USER.getTitle(), "Failed to Unfollow user = ${arg[0]} by = ${arg[1]}");

    /**
     * Constant declaration for GET_NEWS_FEED_ERROR
     */
    public static final Message GET_NEWS_FEED_ERROR =
            Message.create(GET_NEWS_FEED.getCode(), GET_NEWS_FEED.getTitle(), "Failed to retrieve news feed for user = ${arg[0]}");
}
