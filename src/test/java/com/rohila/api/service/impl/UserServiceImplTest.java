package com.rohila.api.service.impl;

import com.rohila.api.bean.Resource;
import com.rohila.api.controller.UserController;
import com.rohila.api.gateway.UserGateway;
import com.rohila.api.response.Response;
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
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@RunWith(MockitoJUnitRunner.class)
class UserServiceImplTest {

    @InjectMocks
    UserServiceImpl userService;

    @Mock
    UserGateway userGateway;

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
    void testUserActionUnFollow() {
        Mockito.when(userGateway.unfollow(Mockito.any(Long.class),Mockito.any(Long.class))).thenReturn("success");
        Response response = userService.userAction("unfollows", new Long(1), new Long(4));
        Assert.assertNotNull(response);
    }

}