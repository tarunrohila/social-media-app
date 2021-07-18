package com.rohila.api.gateway.impl;

import com.rohila.api.exception.ApiResponseException;
import com.rohila.api.gateway.UserGateway;
import com.rohila.api.repository.UserRepository;
import com.rohila.api.repository.domain.UserDetails;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import static com.rohila.api.constant.ErrorMessageConstants.FOLLOW_USER_ERROR;
import static com.rohila.api.constant.ErrorMessageConstants.UNFOLLOW_USER_ERROR;

/**
 * Class which is used to provide implementation for gateway requests for User Operations
 *
 * @author Tarun Rohila
 */
@Repository
public class UserGatewayImpl implements UserGateway {

    /**
     * Logger declaration.
     */
    private static final Logger LOGGER = LogManager.getLogger(UserGatewayImpl.class);

    /**
     * Autowired instance of userRepository
     */
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
    public String follow(Long followerId, Long followeeId) {
        try {
            UserDetails userDetails = userRepository.getById(followerId);
            userDetails.getFollowing().add(userRepository.getById(followeeId));
            userRepository.save(userDetails);
            return "User Started following";
        } catch (Exception e) {
            LOGGER.error("Failed to follow user = [{}]", followeeId);
            throw new ApiResponseException(FOLLOW_USER_ERROR.formatDetail(followerId, followeeId));
        }
    }

    /**
     * Method to follow user
     *
     * @param followerId - followerId
     * @param followeeId - followeeId
     * @return message
     */
    @Override
    public String unfollow(Long followerId, Long followeeId) {
        try {
            UserDetails userDetails = userRepository.getById(followerId);
            userDetails.getFollowing().remove(userRepository.getById(followeeId));
            userRepository.save(userDetails);
            return "User Started unfollowing";
        } catch (Exception e) {
            LOGGER.error("Failed to unfollow user = [{}]", followeeId);
            throw new ApiResponseException(UNFOLLOW_USER_ERROR.formatDetail(followerId, followeeId));
        }
    }

    /**
     * Method to create new user
     *
     * @param userDetails - userDetails
     * @return user
     */
    @Override
    public UserDetails createUser(UserDetails userDetails) {
        LOGGER.debug("saving new user in DB for username = [{}]", userDetails.getName());
        return userRepository.save(userDetails);
    }
}
