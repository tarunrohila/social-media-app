package com.rohila.api.gateway.impl;

import com.rohila.api.bean.Request;
import com.rohila.api.bean.Resource;
import com.rohila.api.controller.PostController;
import com.rohila.api.dto.Post;
import com.rohila.api.exception.ApiResponseException;
import com.rohila.api.helper.TestHelper;
import com.rohila.api.repository.PostRepository;
import com.rohila.api.repository.domain.PostDetails;
import com.rohila.api.response.Response;
import com.rohila.api.service.PostService;
import org.junit.Assert;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.http.HttpStatus;

import static org.junit.jupiter.api.Assertions.assertThrows;

@RunWith(MockitoJUnitRunner.class)
class PostGatewayImplTest {

    @InjectMocks PostGatewayImpl postGateway;

    @Mock
    PostRepository postRepository ;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void testCreatePost() {
        PostDetails postDetails = new PostDetails();
        postDetails.setDescription("my first post");
        Mockito.when(postRepository.save(Mockito.any(PostDetails.class))).thenReturn(postDetails);
        PostDetails response = postGateway.createPost(postDetails);
        Assert.assertNotNull(response);
    }

    @Test
    void testCreatePostWhenError() {
        PostDetails postDetails = new PostDetails();
        postDetails.setDescription("my first post");
        Mockito.when(postRepository.save(Mockito.any(PostDetails.class))).thenThrow(new IllegalStateException("Session/EntityManager is closed"));
        Assertions.assertThrows(IllegalStateException.class, () -> {
            postGateway.createPost(postDetails);
        });
    }
}