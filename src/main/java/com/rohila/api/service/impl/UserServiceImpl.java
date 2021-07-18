package com.rohila.api.service.impl;

import com.rohila.api.exception.ApiRequestException;
import com.rohila.api.gateway.UserGateway;
import com.rohila.api.response.Response;
import com.rohila.api.service.UserService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import static com.rohila.api.constant.ErrorMessageConstants.FOLLOW_USER_ERROR;

/**
 * Class which is used to provide implementation of {@link com.rohila.api.service.UserService}
 *
 * @author Tarun Rohila
 */
@Service
public class UserServiceImpl implements UserService {

    /** Logger declaration. */
    private static final Logger LOGGER = LogManager.getLogger(UserServiceImpl.class);

    /** Autowired instance of userGateway */
    @Autowired
    private UserGateway userGateway;

    /**
     * MEthod to follow/unfolllow users
     *
     * @param action       - action
     * @param followerId   - followerId
     * @param followeeId - followeeId
     * @return success/failure if user has followed or unfollowed successfully
     */
    @Override
    public Response userAction(String action, String followerId, String followeeId) {
        String message;
        if("follows".equalsIgnoreCase(action)) {
            LOGGER.debug("Request to follow user = [{}}", followeeId);
            message = userGateway.follow(followerId, followeeId);
        } else if("unfollows".equalsIgnoreCase(action)) {
            LOGGER.debug("Request to unfollow user = [{}}", followeeId);
            message = userGateway.unfollow(followerId, followeeId);
        } else {
            LOGGER.error("failed to follow/unfollow by user = [{}]", followerId);
            throw new ApiRequestException(FOLLOW_USER_ERROR.formatDetail(followerId, followeeId));
        }
        return Response.assemble().build(HttpStatus.OK, message);
    }

    /**
     * Method to retrieve news feeds for user
     *
     * @param userId - userId
     * @return news feeds
     */
    @Override
    public Response retrieveNewsfeeds(String userId) {
        return Response.assemble().build(HttpStatus.OK, "succ");
    }
}
