package com.rohila.api.repository.domain;

import javax.persistence.*;
import java.util.List;

/**
 * Class which is used to create Entity class for User
 *
 * @author Tarun Rohila
 */
@Entity
@Table(name="USER_DETAILS")
public class UserDetails {


    /**
     * Variable declaration for id
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * Variable declaration for name
     */
    private String name;

    /**
     * Variable declaration for followees
     */
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "followeeId")
    List<UserDetails> followees;

    /**
     * Variable declaration for followers
     */
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "followerId")
    List<UserDetails> followers;

    /**
     * Method to get the value of id
     *
     * @return id - id
     */
    public Long getId() {
        return id;
    }

    /**
     * Method to set the value of id
     *
     * @param id - id
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * Method to get the value of name
     *
     * @return name - name
     */
    public String getName() {
        return name;
    }

    /**
     * Method to set the value of name
     *
     * @param name - name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Method to get the value of followees
     *
     * @return followees - followees
     */
    public List<UserDetails> getFollowees() {
        return followees;
    }

    /**
     * Method to set the value of followees
     *
     * @param followees - followees
     */
    public void setFollowees(List<UserDetails> followees) {
        this.followees = followees;
    }

    /**
     * Method to get the value of followers
     *
     * @return followers - followers
     */
    public List<UserDetails> getFollowers() {
        return followers;
    }

    /**
     * Method to set the value of followers
     *
     * @param followers - followers
     */
    public void setFollowers(List<UserDetails> followers) {
        this.followers = followers;
    }
}

