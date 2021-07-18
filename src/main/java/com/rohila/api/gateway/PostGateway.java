package com.rohila.api.gateway;

import com.rohila.api.repository.domain.PostDetails;

/**
 * Interface which is used to handle gateway requests for Post Operations
 *
 * @author Tarun Rohila
 */
public interface PostGateway {

    /**
     * Method to create new post
     *
     * @param postDetails - postDetails
     * @return
     */
    PostDetails createPost(PostDetails postDetails);
}
