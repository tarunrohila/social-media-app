package com.rohila.api.service.impl;

import com.rohila.api.bean.Resource;
import com.rohila.api.dto.User;
import com.rohila.api.exception.ApiRequestException;
import com.rohila.api.exception.ApiResponseException;
import com.rohila.api.gateway.PostGateway;
import com.rohila.api.gateway.UserGateway;
import com.rohila.api.repository.domain.PostDetails;
import com.rohila.api.repository.domain.UserDetails;
import com.rohila.api.response.Response;
import com.rohila.api.service.UserService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import static com.rohila.api.constant.AppConstants.*;
import static com.rohila.api.constant.ErrorMessageConstants.CREATE_POST_ERROR;
import static com.rohila.api.constant.ErrorMessageConstants.FOLLOW_USER_ERROR;
import static com.rohila.api.helper.CommonHelper.mapToDomain;
import static com.rohila.api.helper.CommonHelper.mapToResource;

/**
 * Class which is used to provide implementation of {@link com.rohila.api.service.UserService}
 *
 * @author Tarun Rohila
 */
@Service
public class UserServiceImpl implements UserService {

    /**
     * Logger declaration.
     */
    private static final Logger LOGGER = LogManager.getLogger(UserServiceImpl.class);

    /**
     * Autowired instance of userGateway
     */
    @Autowired
    private UserGateway userGateway;

    /**
     * Autowired instance of postGateway
     */
    @Autowired
    private PostGateway postGateway;

    /**
     * MEthod to follow/unfolllow users
     *
     * @param action     - action
     * @param followerId - followerId
     * @param followeeId - followeeId
     * @return success/failure if user has followed or unfollowed successfully
     */
    @Override
    public Response userAction(String action, Long followerId, Long followeeId) {
        try {
            String message;
            if ("follows".equalsIgnoreCase(action)) {
                LOGGER.debug("Request to follow user = [{}}", followeeId);
                message = userGateway.follow(followerId, followeeId);
            } else if ("unfollows".equalsIgnoreCase(action)) {
                LOGGER.debug("Request to unfollow user = [{}}", followeeId);
                message = userGateway.unfollow(followerId, followeeId);
            } else {
                LOGGER.error("failed to follow/unfollow by user = [{}]", followerId);
                throw new ApiRequestException(FOLLOW_USER_ERROR.formatDetail(followerId, followeeId));
            }
            return Response.assemble().build(HttpStatus.OK, new Resource<String>(UUID.randomUUID().toString(), USERS, message));
        } catch (Exception e) {
            LOGGER.error("Failed to follow user = [{}]", followeeId);
            throw new ApiResponseException(FOLLOW_USER_ERROR.formatDetail(followerId, followeeId));
        }
    }

    /**
     * Method to retrieve news feeds for user
     *
     * @param userId - userId
     * @return news feeds
     */
    @Override
    public Response retrieveNewsfeeds(Long userId) {
        LOGGER.debug("retrieving news feed for user = [{}]", userId);
        UserDetails user = userGateway.retrieveUser(userId);
        List<Long> userIds = user.getFollowing().stream().map(userDetails -> userDetails.getId()).collect(Collectors.toList());
        userIds.add(userId);
        List<Long> postIds = postGateway.retrieveTop20Posts(userIds).stream().map(postDetails -> postDetails.getId()).collect(Collectors.toList());
        return Response.assemble().build(HttpStatus.OK, new Resource<>(UUID.randomUUID().toString(), POSTS, postIds));
    }

    /**
     * Method to create new user
     *
     * @param user - user
     * @return user
     */
    @Override
    public Response createUser(User user) {
        try {
            LOGGER.debug("Creating new post for userId = [{}] in PostServiceImpl.createPost Method", user.getName());
            return Response.assemble()
                    .build(
                            mapToResource(
                                    ID,
                                    USERS,
                                    userGateway
                                            .createUser(mapToDomain(user, UserDetails.class)),
                                    User.class));
        } catch (Exception e) {
            LOGGER.error("Failed to create new post by user = [{}]", user.getName());
            throw new ApiResponseException(CREATE_POST_ERROR.formatDetail(user.getName()));
        }
    }
}
