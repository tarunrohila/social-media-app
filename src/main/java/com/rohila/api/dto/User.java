package com.rohila.api.dto;

import com.rohila.api.repository.domain.UserDetails;

import java.util.List;

/**
 * Class which is used to create object of User
 *
 * @author Tarun Rohila
 */
public class User {

    /**
     * Variable declaration for id
     */
    private Long id;

    /**
     * Variable declaration for name
     */
    private String name;

    /**
     * Variable declaration for following
     */
    private List<UserDetails> following;

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
     * Method to get the value of name
     *
     * @return name - name
     */
    public String getName() {
        return name;
    }

    /**
     * Method to set the value of name
     *
     * @param name - name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Method to get the value of following
     *
     * @return following - following
     */
    public List<UserDetails> getFollowing() {
        return following;
    }

    /**
     * Method to set the value of following
     *
     * @param following - following
     */
    public void setFollowing(List<UserDetails> following) {
        this.following = following;
    }
}
