package com.rohila.api.repository;

import com.rohila.api.repository.domain.PostDetails;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

/**
 * Interface which is used to create repository to intract with DB
 *
 * @author Tarun Rohila
 */
@Repository
@Transactional
public interface PostRepository extends JpaRepository<PostDetails, Long> {

    /**
     * MEthod to retrieve top 10 results
     * @param userIds - userIds
     * @return top 10
     */
    @Query("SELECT p FROM PostDetails p where p.userId in :userIds ORDER BY p.createdAt")
    List<PostDetails> retrieveTop20Posts(List<Long> userIds);

    Page<PostDetails> findAllByUserIdIn(List<Long> userIds, PageRequest pageRequest);
}
