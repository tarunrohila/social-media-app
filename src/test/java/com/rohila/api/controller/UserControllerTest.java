package com.rohila.api.controller;

import com.rohila.api.bean.Resource;
import com.rohila.api.dto.Post;
import com.rohila.api.helper.TestHelper;
import com.rohila.api.response.Response;
import com.rohila.api.service.PostService;
import com.rohila.api.service.UserService;
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

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@RunWith(MockitoJUnitRunner.class)
class UserControllerTest {

    @InjectMocks
    UserController userController;

    @Mock
    UserService userService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void testUserActionFollow() {
        Mockito.when(userService.userAction(Mockito.any(String.class),Mockito.any(Long.class),Mockito.any(Long.class))).thenReturn(Response.assemble().build(HttpStatus.OK, new Resource<String>("id", "users", "success")));
        Response response = userController.userAction("follows", new Long(1), new Long(4));
        Assert.assertNotNull(response);
    }

    @Test
    void testUserActionFollowWhenError() {
        Mockito.when(userService.userAction(Mockito.any(String.class),Mockito.any(Long.class),Mockito.any(Long.class))).thenReturn(null);
        Response response = userController.userAction("follows", new Long(1), new Long(4));
        Assert.assertNull(response);
    }

    @Test
    void testUserActionUnFollow() {
        Mockito.when(userService.userAction(Mockito.any(String.class),Mockito.any(Long.class),Mockito.any(Long.class))).thenReturn(Response.assemble().build(HttpStatus.OK, new Resource<String>("id", "users", "success")));
        Response response = userController.userAction("unfollows", new Long(1), new Long(4));
        Assert.assertNotNull(response);
    }

    @Test
    void testUserActionUnFollowWhenError() {
        Mockito.when(userService.userAction(Mockito.any(String.class),Mockito.any(Long.class),Mockito.any(Long.class))).thenReturn(null);
        Response response = userController.userAction("unfollows", new Long(1), new Long(4));
        Assert.assertNull(response);
    }

    @Test
    void testRetrieveNewsfeeds() {
        List<Long> ids = new ArrayList<>();
        ids.add(new Long(2));
        ids.add(new Long(3));
        Mockito.when(userService.retrieveNewsfeeds(Mockito.any(Long.class))).thenReturn(Response.assemble().build(new Resource<List<Long>>("id", "posts", ids)));
        Response response = userService.retrieveNewsfeeds(new Long(2));
        Assert.assertNotNull(response);
    }

    @Test
    void testRetrieveNewsfeedsWhenError() {
        List<Long> ids = new ArrayList<>();
        ids.add(new Long(2));
        ids.add(new Long(3));
        Mockito.when(userService.retrieveNewsfeeds(Mockito.any(Long.class))).thenReturn(null);
        Response response = userService.retrieveNewsfeeds(new Long(2));
        Assert.assertNull(response);
    }

}