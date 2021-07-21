package com.rohila.api.service.impl;

import com.rohila.api.bean.Resource;
import com.rohila.api.controller.UserController;
import com.rohila.api.dto.User;
import com.rohila.api.gateway.PostGateway;
import com.rohila.api.gateway.UserGateway;
import com.rohila.api.gateway.impl.PostGatewayImpl;
import com.rohila.api.repository.domain.PostDetails;
import com.rohila.api.repository.domain.UserDetails;
import com.rohila.api.response.Response;
import com.rohila.api.service.UserService;
import org.junit.Assert;
import org.junit.jupiter.api.AfterEach;
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

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@RunWith(MockitoJUnitRunner.class)
class UserServiceImplTest {

    @InjectMocks
    UserServiceImpl userService;

    @Mock
    UserGateway userGateway;

    @Mock
    PostGateway postGateway;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void testUserActionFollow() {
        Mockito.when(userGateway.follow(Mockito.any(Long.class),Mockito.any(Long.class))).thenReturn("success");
        Response response = userService.userAction("follows", new Long(1), new Long(4));
        Assert.assertNotNull(response);
    }

    @Test
    void testUserActionFollowWheError() {
        Mockito.when(userGateway.follow(Mockito.any(Long.class),Mockito.any(Long.class))).thenThrow(new IllegalStateException("Exception"));
        Assertions.assertThrows(Exception.class, () -> {
            userService.userAction("follows", new Long(1), new Long(4));
        });
    }

    @Test
    void testUserActionFollowWhenError() {
        Mockito.when(userGateway.unfollow(Mockito.any(Long.class),Mockito.any(Long.class))).thenThrow(new IllegalStateException("Exception"));
        Assertions.assertThrows(Exception.class, () -> {
            userService.userAction("unfollows", new Long(1), new Long(4));
        });
    }

    @Test
    void testUserActionUnFollow() {
        Mockito.when(userGateway.unfollow(Mockito.any(Long.class),Mockito.any(Long.class))).thenReturn("success");
        Response response = userService.userAction("unfollows", new Long(1), new Long(4));
        Assert.assertNotNull(response);
    }

    @Test
    void testRetrieveNewsFeeds() {
        UserDetails userDetails = new UserDetails();
        userDetails.setName("Test");
        userDetails.setId(new Long(1));
        List<UserDetails> following = new ArrayList<>();
        following.add(userDetails);
        userDetails.setFollowing(following);
        PostDetails postDetails = new PostDetails();
        postDetails.setDescription("my first post");
        List<PostDetails> postDetailsList = new ArrayList<>();
        postDetailsList.add(postDetails);
        Mockito.when(userGateway.retrieveUser(Mockito.any(Long.class))).thenReturn(userDetails);
        Mockito.when(postGateway.retrieveTop20Posts(Mockito.any(List.class))).thenReturn(postDetailsList);
        Response response = userService.retrieveNewsfeeds(new Long(4));
        Assert.assertNotNull(response);
    }

    @Test
    void testRetrieveNewsFeedsWhenError() {
        UserDetails userDetails = new UserDetails();
        userDetails.setName("Test");
        userDetails.setId(new Long(1));
        List<UserDetails> following = new ArrayList<>();
        following.add(userDetails);
        userDetails.setFollowing(following);
        PostDetails postDetails = new PostDetails();
        postDetails.setDescription("my first post");
        List<PostDetails> postDetailsList = new ArrayList<>();
        postDetailsList.add(postDetails);
        Mockito.when(userGateway.retrieveUser(Mockito.any(Long.class))).thenThrow(new IllegalStateException("Exception"));;
        Mockito.when(postGateway.retrieveTop20Posts(Mockito.any(List.class))).thenReturn(postDetailsList);
        Assertions.assertThrows(Exception.class, () -> {
            userService.retrieveNewsfeeds(new Long(4));
        });
    }

    @Test
    void testUserWhenError() {
        UserDetails userDetails = new UserDetails();
        userDetails.setName("Test");
        Mockito.when(userGateway.createUser(Mockito.any(UserDetails.class))).thenThrow(new IllegalStateException("Exception"));
        User user = new User();
        user.setName("Test");
        Assertions.assertThrows(Exception.class, () -> {
            userService.createUser(user);
        });
    }

    @Test
    void testUser() {
        UserDetails userDetails = new UserDetails();
        userDetails.setName("Test");
        Mockito.when(userGateway.createUser(Mockito.any(UserDetails.class))).thenReturn(userDetails);
        User user = new User();
        user.setName("Test");
        Response response = userService.createUser(user);
        Assert.assertNotNull(response);
    }
}