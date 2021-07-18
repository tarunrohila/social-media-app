package com.rohila.api.repository;

import com.rohila.api.repository.domain.PostDetails;
import com.rohila.api.repository.domain.UserDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
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

    @Query("SELECT e FROM UserDetails e WHERE e.id = :id")
    UserDetails retrieveUserDetailsByUserId(
            @Param("id") final Long id);

}
