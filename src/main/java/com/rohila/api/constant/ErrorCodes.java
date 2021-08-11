package com.rohila.api.constant;

/**
 * Enum which is used to create constants for Social Media App
 *
 * @author Tarun Rohila
 */
public enum ErrorCodes {

    /**
     * All error codes
     */
    UNAUTHORIZED_ACCESS("API_INT_001", "Unauthorized Access"),
    FORBIDDEN_ACCESS("API_INT_002", "Forbidden Access"),
    INTERNAL_SERVER("API_INT_003", "Internal Server Error"),
    CREATE_POST("API_INT_005", "Create Post Error"),
    FOLLOW_USER("API_INT_006", "Follow User Error"),
    UNFOLLOW_USER("API_INT_007", "Unfollow User Error"),
    GET_NEWS_FEED("API_INT_008", "Get News Feed Error"),
    MISSING_MANDATORY_HEADERS("API_INT_004", "Mandatory Headers Error");

    /**
     * Variable declaration for code
     */
    public String code;

    /**
     * Variable declaration for detail
     */
    public String title;

    /**
     * Method to set error code
     *
     * @param code - code
     */
    private ErrorCodes(String code) {
        this.code = code;
    }

    /**
     * Method to set error code and details
     *
     * @param code - code
     */
    private ErrorCodes(String code, String title) {
        this.code = code;
        this.title = title;
    }

    /**
     * Method to get the value of code
     *
     * @return code - code
     */
    public String getCode() {
        return code;
    }

    /**
     * Method to get the value of title
     *
     * @return title - title
     */
    public String getTitle() {
        return title;
    }
}
