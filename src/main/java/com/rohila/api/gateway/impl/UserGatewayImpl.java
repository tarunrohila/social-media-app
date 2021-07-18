package com.rohila.api.gateway.impl;

import com.rohila.api.gateway.PostGateway;
import com.rohila.api.gateway.UserGateway;
import com.rohila.api.repository.PostRepository;
import com.rohila.api.repository.UserRepository;
import com.rohila.api.repository.domain.PostDetails;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * Class which is used to provide implementation for gateway requests for User Operations
 *
 * @author Tarun Rohila
 */
@Repository
public class UserGatewayImpl implements UserGateway {

    /** Logger declaration. */
    private static final Logger LOGGER = LogManager.getLogger(UserGatewayImpl.class);

    /** Autowired instance of userRepository */
    @Autowired
    private UserRepository userRepository;


    /**
     * Method to follow user
     *
     * @param followerId - followerId
     * @param followeeId - followeeId
     * @return message
     */
    @Override
    public String follow(String followerId, String followeeId) {
        userRepository.retrieveUserDetailsByUserId(Long.parseLong(followeeId));
        return null;
    }

    /**
     * Method to follow user
     *
     * @param followerId - followerId
     * @param followeeId - followeeId
     * @return message
     */
    @Override
    public String unfollow(String followerId, String followeeId) {
        return null;
    }
}
