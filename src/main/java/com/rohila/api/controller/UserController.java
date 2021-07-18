package com.rohila.api.controller;

import com.rohila.api.bean.Request;
import com.rohila.api.dto.User;
import com.rohila.api.response.Response;
import com.rohila.api.service.UserService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import static com.rohila.api.constant.RestRequestConstants.*;

/**
 * Class which is used to handle requests for Users
 *
 * @author Tarun Rohila
 */
@RestController
public class UserController {

    /**
     * Logger declaration.
     */
    private static final Logger LOGGER = LogManager.getLogger(UserController.class);

    /**
     * Autowired instance of userService
     */
    @Autowired
    private UserService userService;

    /**
     * Method to follow or unfollow users
     *
     * @param action     - action
     * @param followerId - followerId
     * @param followeeId - followeeId
     * @return return success/failure message on following or unfollowing actions
     */
    @PostMapping(USERS_ACTION_ENDPOINT)
    public Response userAction(@PathVariable(ACTION_PARAM) String action, @PathVariable(FOLLOWER_ID_PARAM) Long followerId, @PathVariable(FOLLOWEE_ID_PARAM) Long followeeId) {
        LOGGER.debug("processing request to [{}] for followerId = [{}] and followeeId = [{}]", action, followerId, followeeId);
        return userService.userAction(action, followerId, followeeId);
    }

    /**
     * Method to get news feeds for user
     *
     * @param userId - userId
     * @return return news feeds for user
     */
    @GetMapping(NEWFEEDS_GET_ENDPOINT)
    public Response retrieveNewsfeeds(@PathVariable(USER_ID_PARAM) String userId) {
        LOGGER.debug("processing request to retrieve news feeds for user = [{}]", userId);
        return userService.retrieveNewsfeeds(userId);
    }

    /**
     * Method to add User
     *
     * @param request - request
     * @return user
     */
    @PostMapping(USERS_CREATE_ENDPOINT)
    public Response createUser(@RequestBody Request request) {
        User user = request.getData(User.class);
        LOGGER.debug("creating new user of name = [{}}", user.getName());
        return userService.createUser(user);
    }
}
