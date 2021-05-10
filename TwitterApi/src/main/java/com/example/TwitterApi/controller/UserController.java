package com.example.TwitterApi.controller;

import com.example.TwitterApi.domain.ResponeMessage;
import com.example.TwitterApi.domain.User;
import com.example.TwitterApi.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/")
public class UserController {

    private UserService userService;

    @Autowired
    public UserController(UserService userService){
        this.userService = userService;
    }

    @PostMapping(value = "createuser")
    public ResponseEntity<Object> updateFollowers(
            @RequestHeader HttpHeaders headers, @RequestBody User user)
            throws Exception {
        ResponeMessage tweetResponse = ResponeMessage.builder()
                .response("Updated Followers").build();
        userService.createUser(headers, user);
        return ResponseEntity.ok().body(tweetResponse);
    }
}
