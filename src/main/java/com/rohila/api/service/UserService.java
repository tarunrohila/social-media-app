package com.rohila.api.service;

import com.rohila.api.dto.Post;
import com.rohila.api.response.Response;
import org.springframework.validation.annotation.Validated;

/**
 * Interface which is used to provide handling for user actions related endpoints
 *
 * @author Tarun Rohila
 */
@Validated
public interface UserService {

    /**
     * MEthod to follow/unfolllow users
     *
     * @param action - action
     * @param followerId - followerId
     * @param  followeeId - followeeId
     * @return success/failure if user has followed or unfollowed successfully
     */
    Response userAction(String action, String followerId, String followeeId);

    /**
     * Method to retrieve news feeds for user
     *
     * @param userId - userId
     * @return news feeds
     */
    Response retrieveNewsfeeds(String userId);
}
