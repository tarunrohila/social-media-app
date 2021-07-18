package com.rohila.api.repository;

import com.rohila.api.repository.domain.PostDetails;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Interface which is used to create repository to intract with DB
 *
 * @author Tarun Rohila
 */
public interface PostRepository extends JpaRepository<PostDetails, Long> {
}
