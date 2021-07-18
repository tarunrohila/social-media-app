package com.rohila.api.dto;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

/**
 * Class which is used to create object of Post
 *
 * @author Tarun Rohila
 */
public class Post {

    /** Variable declaration for id */
    private Long id;

    /** Variable declaration for createdAt */
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private Date createdAt;

    /** Variable declaration for description */
    private String description;

    /** Variable declaration for userId */
    private String userId;

    /**
     * Method to get the value of id
     *
     * @return id - id
     */
    public Long getId() {
        return id;
    }

    /**
     * Method to set the value of id
     *
     * @param id - id
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * Method to get the value of createdAt
     *
     * @return createdAt - createdAt
     */
    public Date getCreatedAt() {
        return createdAt;
    }

    /**
     * Method to set the value of createdAt
     *
     * @param createdAt - createdAt
     */
    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    /**
     * Method to get the value of description
     *
     * @return description - description
     */
    public String getDescription() {
        return description;
    }

    /**
     * Method to set the value of description
     *
     * @param description - description
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * Method to get the value of userId
     *
     * @return userId - userId
     */
    public String getUserId() {
        return userId;
    }

    /**
     * Method to set the value of userId
     *
     * @param userId - userId
     */
    public void setUserId(String userId) {
        this.userId = userId;
    }
}
