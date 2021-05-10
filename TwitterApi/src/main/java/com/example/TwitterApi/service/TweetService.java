package com.example.TwitterApi.service;

import com.example.TwitterApi.domain.Tweet;
import com.example.TwitterApi.domain.TweetRequest;
import com.example.TwitterApi.domain.TweetsResponse;
import com.example.TwitterApi.repository.TweetRepository;
import io.micrometer.core.annotation.Timed;
import net.minidev.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Service;

import java.security.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

import static jdk.nashorn.internal.runtime.regexp.joni.Config.log;

@Service
public class TweetService {
    @Autowired
    private TweetRepository tweetRepository;

    @Autowired
    public TweetService(TweetRepository tweetRepository) {
        this.tweetRepository = tweetRepository;
    }

    @Timed(description = "Time Spent Posting Tweets 1")
    public void  createTweet(HttpHeaders headers,
            Tweet tweet) throws ParseException {

        TweetRequest tweetRequest = TweetRequest.builder().tweetID(tweet.getTweetID())
                .tweetText(tweet.getTweetText())
                .userID(tweet.getUserID())
                .createdAt(getDate(tweet))
                .build();
        tweetRepository.save(tweetRequest);
    }

    public TweetsResponse getTweets(int page, int size, String userId) {
        log.print("Request Received");
        try {
            Pageable paging = PageRequest.of(page, size);
            Page<TweetRequest> t;

            t = tweetRepository.findAllBy(userId, paging);
            TweetsResponse tweetsResponse = TweetsResponse.builder()
                    .tweetList(t.getContent())
                    .totalPages(t.getTotalPages())
                    .currentPage(t.getNumber())
                    .total(t.getTotalElements()).build();
            ;
            return tweetsResponse;
        } catch (Exception e) {
            throw e;
        }
    }

private Date getDate(Tweet tweet) throws ParseException {
        try {
            SimpleDateFormat myFormat = new SimpleDateFormat("yyyy-MM-dd'T'hh:mm:ss.SSS'Z'");
            Date myDate = myFormat.parse(tweet.getCreatedAt());
            return myDate;
        } catch(ParseException e) {
            throw e;
        }
}





}
