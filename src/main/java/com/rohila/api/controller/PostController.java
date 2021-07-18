package com.rohila.api.controller;

import com.rohila.api.bean.Request;
import com.rohila.api.dto.Post;
import com.rohila.api.response.Response;
import com.rohila.api.service.PostService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import static com.rohila.api.constant.RestRequestConstants.POSTS_CREATE_ENDPOINT;
import static com.rohila.api.constant.RestRequestConstants.USER_ID_PARAM;

/**
 * Class which is used to handle requests for Posts
 *
 * @author Tarun Rohila
 */
@RestController
public class PostController {

    /**
     * Logger declaration.
     */
    private static final Logger LOGGER = LogManager.getLogger(PostController.class);

    /**
     * Autowired instance of postService
     */
    @Autowired
    private PostService postService;

    /**
     * Method to create user posts
     *
     * @param userId  - userId
     * @param request - request
     * @return created post
     */
    @PostMapping(POSTS_CREATE_ENDPOINT)
    public Response createPost(@PathVariable(USER_ID_PARAM) String userId, @RequestBody Request request) {
        Post post = request.getData(Post.class);
        post.setUserId(userId);
        LOGGER.debug("creating new post of userId = [{}}", userId);
        return postService.createPost(post);
    }
}
