package com.rohila.api.service.impl;

import com.rohila.api.dto.Post;
import com.rohila.api.exception.ApiResponseException;
import com.rohila.api.gateway.PostGateway;
import com.rohila.api.repository.domain.PostDetails;
import com.rohila.api.response.Response;
import com.rohila.api.service.PostService;
import javassist.bytecode.stackmap.BasicBlock;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import static com.rohila.api.constant.AppConstants.ID;
import static com.rohila.api.constant.AppConstants.POSTS;
import static com.rohila.api.constant.ErrorMessageConstants.CREATE_POST_ERROR;
import static com.rohila.api.helper.CommonHelper.mapToDomain;
import static com.rohila.api.helper.CommonHelper.mapToResource;

/**
 * Class which is used to provide implementation of {@link PostService}
 *
 * @author Tarun Rohila
 */
@Service
public class PostServiceImpl implements PostService {

    /** Logger declaration. */
    private static final Logger LOGGER = LogManager.getLogger(PostServiceImpl.class);

    /** Autowired instance of postGateway */
    @Autowired
    private PostGateway postGateway;

    /**
     * Method to create new post
     *
     * @param post   - post
     * @return
     */
    @Override
    public Response createPost(Post post) {
        try {
            LOGGER.debug("Creating new post for userId = [{}] in PostServiceImpl.createPost Method", post.getUserId());
            return Response.assemble()
                    .build(
                            mapToResource(
                                    ID,
                                    POSTS,
                                    postGateway
                                            .createPost(mapToDomain(post, PostDetails.class)),
                                    Post.class));
        } catch (Exception e) {
            LOGGER.error("Failed to create new post by user = [{}]", post.getUserId());
            throw new ApiResponseException(CREATE_POST_ERROR.formatDetail(post.getUserId()));
        }
    }
}
