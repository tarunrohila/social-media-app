package com.rohila.api.gateway.impl;

import com.rohila.api.bean.Resource;
import com.rohila.api.controller.UserController;
import com.rohila.api.repository.UserRepository;
import com.rohila.api.repository.domain.UserDetails;
import com.rohila.api.response.Response;
import com.rohila.api.service.UserService;
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

import java.util.ArrayList;
import java.util.List;

@RunWith(MockitoJUnitRunner.class)
class UserGatewayImplTest {

    @InjectMocks
    UserGatewayImpl userGateway;

    @Mock
    UserRepository userRepository;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void testUserActionFollow() {
        UserDetails userDetails = new UserDetails();
        userDetails.setName("Test");
        userDetails.setId(new Long(1));
        List<UserDetails> following = new ArrayList<>();
        following.add(userDetails);
        userDetails.setFollowing(following);
        Mockito.when(userRepository.getById(Mockito.any(Long.class))).thenReturn(userDetails);
        Mockito.when(userRepository.save(Mockito.any(UserDetails.class))).thenReturn(userDetails);
        String response = userGateway.follow(new Long(1), new Long(4));
        Assert.assertNotNull(response);
    }

    @Test
    void testUserActionFollowWhenError() {
        UserDetails userDetails = new UserDetails();
        userDetails.setName("Test");
        userDetails.setId(new Long(1));
        List<UserDetails> following = new ArrayList<>();
        following.add(userDetails);
        userDetails.setFollowing(following);
        Mockito.when(userRepository.getById(Mockito.any(Long.class))).thenReturn(userDetails);
        Mockito.when(userRepository.save(Mockito.any(UserDetails.class))).thenThrow(new IllegalStateException("Session/EntityManager is closed"));
        Assertions.assertThrows(Exception.class, () -> {
            userGateway.follow(new Long(1), new Long(4));
        });
    }

    @Test
    void testUserActionUnFollow() {
        UserDetails userDetails = new UserDetails();
        userDetails.setName("Test");
        userDetails.setId(new Long(1));
        List<UserDetails> following = new ArrayList<>();
        following.add(userDetails);
        userDetails.setFollowing(following);
        Mockito.when(userRepository.getById(Mockito.any(Long.class))).thenReturn(userDetails);
        Mockito.when(userRepository.save(Mockito.any(UserDetails.class))).thenReturn(userDetails);
        String response = userGateway.unfollow(new Long(1), new Long(4));
        Assert.assertNotNull(response);
    }

    @Test
    void testUserActionUnFollowWhenError() {
        UserDetails userDetails = new UserDetails();
        userDetails.setName("Test");
        userDetails.setId(new Long(1));
        List<UserDetails> following = new ArrayList<>();
        following.add(userDetails);
        userDetails.setFollowing(following);
        Mockito.when(userRepository.getById(Mockito.any(Long.class))).thenReturn(userDetails);
        Mockito.when(userRepository.save(Mockito.any(UserDetails.class))).thenThrow(new IllegalStateException("Session/EntityManager is closed"));
        Assertions.assertThrows(Exception.class, () -> {
            userGateway.unfollow(new Long(1), new Long(4));
        });
    }

    @Test
    void testRetrieveNewsfeeds() {
        UserDetails userDetails = new UserDetails();
        userDetails.setName("Test");
        userDetails.setId(new Long(1));
        List<UserDetails> following = new ArrayList<>();
        following.add(userDetails);
        userDetails.setFollowing(following);
        Mockito.when(userRepository.getById(Mockito.any(Long.class))).thenReturn(userDetails);
        UserDetails response = userGateway.retrieveUser(new Long(1));
        Assert.assertNotNull(response);
    }

    @Test
    void testRetrieveNewsfeedsWhenError() {
        UserDetails userDetails = new UserDetails();
        userDetails.setName("Test");
        userDetails.setId(new Long(1));
        List<UserDetails> following = new ArrayList<>();
        following.add(userDetails);
        userDetails.setFollowing(following);
        Mockito.when(userRepository.getById(Mockito.any(Long.class))).thenThrow(new IllegalStateException("Session/EntityManager is closed"));
        Assertions.assertThrows(IllegalStateException.class, () -> {
            userGateway.retrieveUser(new Long(1));
        });
    }
}