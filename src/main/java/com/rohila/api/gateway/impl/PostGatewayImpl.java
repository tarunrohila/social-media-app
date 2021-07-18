package com.rohila.api.gateway.impl;

import com.rohila.api.gateway.PostGateway;
import com.rohila.api.repository.PostRepository;
import com.rohila.api.repository.domain.PostDetails;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Class which is used to provide implementation for gateway requests for Post Operations
 *
 * @author Tarun Rohila
 */
@Repository
public class PostGatewayImpl implements PostGateway {

    /**
     * Logger declaration.
     */
    private static final Logger LOGGER = LogManager.getLogger(PostGatewayImpl.class);

    /**
     * Autowired instance of postRepository
     */
    @Autowired
    private PostRepository postRepository;

    /**
     * Method to create new post
     *
     * @param postDetails - postDetails
     * @return
     */
    @Override
    public PostDetails createPost(PostDetails postDetails) {
        return postRepository.save(postDetails);
    }

    /**
     * Method to retrieve top 20 nes feeds
     *
     * @param userIds - userIds
     * @return posts
     */
    @Override
    public List<PostDetails> retrieveTop20Posts(List<Long> userIds) {
        LOGGER.debug("Retrieving top 20 news feeds");
        return postRepository.findAllByUserIdIn(userIds, PageRequest.of(0, 20, Sort.by(Sort.Direction.DESC, "createdAt"))).getContent();
    }
}
