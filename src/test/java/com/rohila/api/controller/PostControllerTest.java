package com.rohila.api.controller;

import com.rohila.api.bean.Request;
import com.rohila.api.bean.Resource;
import com.rohila.api.dto.Post;
import com.rohila.api.helper.TestHelper;
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

import static org.junit.jupiter.api.Assertions.*;

@RunWith(MockitoJUnitRunner.class)
class PostControllerTest {

    @InjectMocks PostController postController;

    @Mock
    PostService postService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void testCreatePost() {
        Request request = new Request();
        Post post = new Post();
        post.setDescription("my first post");
        request.setData(post);
        Mockito.when(postService.createPost(Mockito.any(Post.class))).thenReturn(Response.assemble().build(HttpStatus.CREATED, new Resource<Post>("id", "posts", TestHelper.populatePost())));
        Response response = postController.createPost(new Long(1), request);
        Assert.assertNotNull(response);
    }

    @Test
    void testCreatePostWhenError() {
        Request request = new Request();
        Post post = new Post();
        post.setDescription("my first post");
        request.setData(post);
        Mockito.when(postService.createPost(Mockito.any(Post.class))).thenReturn(null);
        Response response = postController.createPost(new Long(1), request);
        Assert.assertNull(response);
    }
}