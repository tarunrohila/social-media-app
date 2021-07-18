package com.rohila.api.service;

import com.rohila.api.dto.Post;
import com.rohila.api.response.Response;
import org.springframework.validation.annotation.Validated;

/**
 * Interface which is used to provide handling for post related endpoints
 *
 * @author Tarun Rohila
 */
@Validated
public interface PostService {

    /**
     * Method to create new post
     *
     * @param post - post
     * @return
     */
    Response createPost(Post post);
}
