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

/**
 * Class which is used to keep all constants for Restful requests  for Social Media App
 *
 * @author Tarun Rohila
 */
public class RestRequestConstants {

    /**
     * Private constructor
     */
    private RestRequestConstants() {
    }

    /**
     * Constant declaration for PINGS_ENDPOINT
     */
    public static final String PINGS_ENDPOINT = "/pings";

    /**
     * Constant declaration for POSTS_CREATE_ENDPOINT
     */
    public static final String POSTS_CREATE_ENDPOINT = "/api/users/{userId}/posts";

    /**
     * Constant declaration for USERS_ACTION_ENDPOINT
     */
    public static final String USERS_ACTION_ENDPOINT = "/api/users/{action}/{followerId}/{followeeId}";

    /**
     * Constant declaration for USERS_CREATE_ENDPOINT
     */
    public static final String USERS_CREATE_ENDPOINT = "/api/users";

    /**
     * Constant declaration for NEWFEEDS_GET_ENDPOINT
     */
    public static final String NEWFEEDS_GET_ENDPOINT = "/api/users/{userId}/newsfeeds";

    /**
     * Constant declaration for USER_ID_PARAM
     */
    public static final String USER_ID_PARAM = "userId";

    /**
     * Constant declaration for ACTION_PARAM
     */
    public static final String ACTION_PARAM = "action";

    /**
     * Constant declaration for FOLLOWER_ID_PARAM
     */
    public static final String FOLLOWER_ID_PARAM = "followerId";

    /**
     * Constant declaration for FOLLOWEE_ID_PARAM
     */
    public static final String FOLLOWEE_ID_PARAM = "followeeId";
}
