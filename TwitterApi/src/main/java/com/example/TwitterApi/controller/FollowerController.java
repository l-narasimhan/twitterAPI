package com.example.TwitterApi.controller;


import com.example.TwitterApi.domain.ResponeMessage;
import com.example.TwitterApi.domain.Follower;
import com.example.TwitterApi.service.FollowerService;
import com.example.TwitterApi.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;

import static jdk.nashorn.internal.runtime.regexp.joni.Config.log;

@RestController
@RequestMapping("/")
public class FollowerController {

    private FollowerService followerService;
    private UserService userService;

    private static final String GOOD_RESPONSE = "Updated Followers";
    private static final String EXCEEDED_RESPONSE = "Exceed Follower Count";
    private static final String FOLLOWER_EXISTS = "Already a follower";



    @Autowired
    public FollowerController(FollowerService followerService, UserService userService){
        this.followerService = followerService;
        this.userService = userService;
    }

    @PostMapping(value = "addfollower")
    @Transactional
    public ResponseEntity<Object> updateFollowers(
            @RequestHeader HttpHeaders headers, @RequestBody Follower follower)
            throws Exception {
        ResponeMessage response = ResponeMessage.builder()
                .response(GOOD_RESPONSE).build();
        try {
            userService.updateUserFollower(follower.getUserID());
            followerService.updateFollower(headers, follower);
        }catch(Exception e){
            log.print("Illegal Operation");
            throw e;
        }
        return ResponseEntity.ok().body(response);
    }
}
