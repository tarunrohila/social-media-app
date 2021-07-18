package com.rohila.api.gateway;

import com.rohila.api.repository.domain.PostDetails;

import java.util.List;

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

    /**
     * Method to retrieve top 20 nes feeds
     * @param userIds - userIds
     * @return posts
     * @return posts
     */
    List<PostDetails> retrieveTop20Posts(List<Long> userIds);
}
