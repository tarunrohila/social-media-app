package com.rohila.api.repository;

import com.rohila.api.repository.domain.UserDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

/**
 * Interface which is used to create repository to intract with DB
 *
 * @author Tarun Rohila
 */
@Transactional
@Repository
public interface UserRepository extends JpaRepository<UserDetails, Long> {

//    @Modifying
//    @Query("UPDATE u UserDetails SET u.followerId = :followerId, u.followeeId = :followeeId WHERE u.id = :followerId")
//    void follow(long followerId, long followeeId);
}
