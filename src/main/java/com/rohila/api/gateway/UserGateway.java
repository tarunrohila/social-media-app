package com.rohila.api.gateway;

import com.rohila.api.repository.domain.PostDetails;

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
    String follow(String followerId, String followeeId);

    /**
     * Method to follow user
     *
     * @param followerId - followerId
     * @param followeeId - followeeId
     * @return message
     */
    String unfollow(String followerId, String followeeId);
}
