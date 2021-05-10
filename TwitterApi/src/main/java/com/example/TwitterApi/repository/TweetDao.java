package com.example.TwitterApi.repository;

import com.example.TwitterApi.domain.Follower;
import com.example.TwitterApi.domain.TweetRequest;

public interface TweetDao {

    void  createTweet(TweetRequest tweetRequest);

    void updateFollower(Follower follower);


}
