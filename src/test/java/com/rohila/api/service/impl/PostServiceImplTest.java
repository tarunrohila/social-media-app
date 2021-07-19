package com.rohila.api.service.impl;

import com.rohila.api.bean.Request;
import com.rohila.api.bean.Resource;
import com.rohila.api.controller.PostController;
import com.rohila.api.dto.Post;
import com.rohila.api.exception.ApiResponseException;
import com.rohila.api.gateway.PostGateway;
import com.rohila.api.helper.TestHelper;
import com.rohila.api.repository.domain.PostDetails;
import com.rohila.api.response.Response;
import com.rohila.api.service.PostService;
import org.junit.Assert;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.http.HttpStatus;

import static com.rohila.api.constant.ErrorMessageConstants.CREATE_POST_ERROR;
import static org.junit.jupiter.api.Assertions.*;

@RunWith(MockitoJUnitRunner.class)
class PostServiceImplTest {

    @InjectMocks
    PostServiceImpl postService;

    @Mock
    PostGateway postGateway;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void testCreatePost() {
        Post post = new Post();
        post.setDescription("my first post");
        PostDetails postDetails = new PostDetails();
        postDetails.setDescription("my first post");
        Mockito.when(postGateway.createPost(Mockito.any(PostDetails.class))).thenReturn(postDetails);
        Response response = postService.createPost(post);
        Assert.assertNotNull(response);
    }

}