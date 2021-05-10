package com.example.TwitterApi.repository;

import com.example.TwitterApi.domain.Tweet;
import com.example.TwitterApi.domain.TweetRequest;
import io.micrometer.core.annotation.Timed;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Repository;

@Repository
@Timed(description = "Time Spent Posting Tweets")
public interface TweetRepository extends JpaRepository<TweetRequest, String> {
    @Query("select th from TweetRequest th where th.userID = :userId ORDER BY th.createdAt DESC")
    Page<TweetRequest> findAllBy(String userId, Pageable pageable);
}