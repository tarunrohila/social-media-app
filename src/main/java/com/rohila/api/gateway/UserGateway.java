package com.rohila.api.gateway;

import com.rohila.api.repository.domain.UserDetails;

/**
 * Interface which is used to handle gateway requests for Post Operations
 *
 * @author Tarun Rohila
 */
public interface UserGateway {

    /**
     * Method to follow user
     *
     * @param followerId - followerId
     * @param followeeId - followeeId
     * @return message
     */
    String follow(Long followerId, Long followeeId);

    /**
     * Method to follow user
     *
     * @param followerId - followerId
     * @param followeeId - followeeId
     * @return message
     */
    String unfollow(Long followerId, Long followeeId);

    /**
     * Method to create new user
     *
     * @param userDetails - userDetails
     * @return user
     */
    UserDetails createUser(UserDetails userDetails);
}
