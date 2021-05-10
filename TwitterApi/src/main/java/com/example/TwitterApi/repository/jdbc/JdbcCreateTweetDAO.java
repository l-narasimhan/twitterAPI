package com.example.TwitterApi.repository.jdbc;

import com.example.TwitterApi.domain.Follower;
import com.example.TwitterApi.domain.TweetRequest;
import com.example.TwitterApi.repository.TweetDao;
import lombok.val;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import static jdk.nashorn.internal.runtime.regexp.joni.Config.log;

@Repository
public class JdbcCreateTweetDAO  implements TweetDao {
    private JdbcTemplate jdbcTemplate;

    @Autowired
    public JdbcCreateTweetDAO(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }


    @Override
    public void createTweet(TweetRequest tweetRequest) {
        val sql = "INSERT INTO TWEETS_TABLE VALUES (?,?,?,?)";
        int row =  jdbcTemplate.update(sql, ps -> {
            ps.setString(1, tweetRequest.getUserID());
            ps.setString(2, tweetRequest.getTweetID());
            ps.setString(3, tweetRequest.getTweetText());
           // ps.setString(4, tweetRequest.getCreatedAt());
        });
        log.print("Request Received 1");
    }

    @Override
    public void updateFollower(Follower follower) {
        val sql = "INSERT INTO FOLLOWERS_TABLE VALUES (?,?)";
        int row =  jdbcTemplate.update(sql, ps -> {
            ps.setString(1, follower.getUserID());
            ps.setString(2, follower.getFollowerID());
        });
        log.print("Request Received for Followers");
    }

}

