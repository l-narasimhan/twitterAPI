package com.example.TwitterApi.repository;

import com.example.TwitterApi.domain.Follower;
import com.example.TwitterApi.domain.UserFollowerGroupPK;
import io.micrometer.core.annotation.Timed;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Timed(description = "Time Spent updating Followers")
@Repository
public interface FollowerRepository extends JpaRepository<Follower, UserFollowerGroupPK>{
}
