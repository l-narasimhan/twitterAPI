package com.example.TwitterApi.service;

import com.example.TwitterApi.domain.Follower;
import com.example.TwitterApi.domain.User;
import com.example.TwitterApi.repository.UserRepository;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Service;

import java.util.Optional;

import static jdk.nashorn.internal.runtime.regexp.joni.Config.log;

@Service
public class UserService {

    private UserRepository userRepository;

    public UserService(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    public void  createUser(HttpHeaders headers,
                            User user) {
        log.print("Request Received");
        userRepository.save(user);
    }

    public boolean  updateUserFollower(
                            String userId) {
        log.print("Request Received");
        Optional<User> retrievedUser = userRepository.findById(userId);
        if (retrievedUser.get().getFollowerCount() > 100) {
            throw new UnsupportedOperationException("Unsupported Operation");

        } else {
            int newUserCount = retrievedUser.get().getFollowerCount() + 1;
            retrievedUser.get().setFollowerCount(newUserCount);
            User updateUser = User.builder()
                    .userID(userId)
                    .emailId(retrievedUser.get().getEmailId())
                    .region(retrievedUser.get().getRegion())
                    .followerCount(newUserCount).build();
            userRepository.save(updateUser);
        }
        return true;
    }





}
