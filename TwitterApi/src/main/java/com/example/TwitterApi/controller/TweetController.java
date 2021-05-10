package com.example.TwitterApi.controller;

import com.example.TwitterApi.domain.ResponeMessage;
import com.example.TwitterApi.domain.Tweet;
import com.example.TwitterApi.domain.TweetsResponse;
import com.example.TwitterApi.service.TweetService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;
import java.util.concurrent.TimeUnit;

@RestController
@RequestMapping("/")
@Slf4j
public class TweetController {

    private TweetService tweetService;

    @Autowired
    public TweetController(TweetService tweetService) {
        this.tweetService = tweetService;
    }


    @PostMapping(value = "createtweet")
    public ResponseEntity createTweet(
             @RequestHeader HttpHeaders headers,@RequestBody Tweet tweet)
            throws Exception {
        Long startTime = System.currentTimeMillis();

        ResponeMessage tweetResponse = ResponeMessage.builder()
                .response("All good").build();
        tweetService.createTweet(headers, tweet);
        //TimeUnit.MILLISECONDS.sleep(100);
        log.info("Posted Tweet Successfully {}", System.currentTimeMillis() - startTime);
        return ResponseEntity.ok().body(tweetResponse);
    }

    @GetMapping(value = "viewtweets/{userId}")
    public ResponseEntity<TweetsResponse> viewTweets(
            @PathVariable(value = "userId") String userId,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "3") int size,
            @RequestHeader HttpHeaders headers)
            throws Exception {
        ResponeMessage tweetResponse = ResponeMessage.builder()
                .response("All good").build();
        TweetsResponse response =  tweetService.getTweets(page, size, userId);
        return ResponseEntity.ok().body(response);
    }
}
