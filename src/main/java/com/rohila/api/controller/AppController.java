package com.rohila.api.controller;

import com.rohila.api.bean.Resource;
import com.rohila.api.response.Response;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

import static com.rohila.api.constant.AppConstants.PINGS;
import static com.rohila.api.constant.AppConstants.PINGS_SUCCESS;
import static com.rohila.api.constant.RestRequestConstants.PINGS_ENDPOINT;

/**
 * Class which is used to create controller to manange requests for social media API
 *
 * @author Tarun Rohila
 */
@RestController
public class AppController {

    /** Logger declaration. */
    private static final Logger LOGGER = LogManager.getLogger(AppController.class);


    /**
     * Method to test api if it is accessible
     *
     * @return success if api is up and working
     */
    @GetMapping(PINGS_ENDPOINT)
    public Response ping() {
        LOGGER.debug("ping method is executed");
        return Response.assemble().build(HttpStatus.OK, new Resource<String>(UUID.randomUUID().toString(), PINGS, PINGS_SUCCESS));
    }
}
