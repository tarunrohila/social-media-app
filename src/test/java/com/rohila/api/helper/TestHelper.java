package com.rohila.api.helper;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.rohila.api.dto.Post;

/**
 * Class which is used to provide test helper method
 *
 * @author Tarun Rohila
 */
public class TestHelper {

    ObjectMapper mapper = new ObjectMapper();

    public static Post populatePost() {
        Post post = new Post();
        post.setDescription("my first post");
        post.setUserId(new Long(1));
        return post;
    }
}
