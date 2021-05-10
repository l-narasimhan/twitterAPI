package com.example.TwitterApi.service;

import com.example.TwitterApi.domain.Follower;
import com.example.TwitterApi.domain.UserFollowerGroupPK;
import com.example.TwitterApi.repository.FollowerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.Optional;

import static jdk.nashorn.internal.runtime.regexp.joni.Config.log;

@Service
public class FollowerService {
    private FollowerRepository followerRepository;

    @Autowired
    public FollowerService(FollowerRepository followerRepository) {
        this.followerRepository = followerRepository;
    }

    public void  updateFollower(HttpHeaders headers,
                             Follower follower) {
        log.print("Request Received");

        try {
            boolean result = retrieveFollower(follower);
            Follower followers = followerRepository.save(follower);
        }catch (DataAccessException ex) {
            throw ex;
        }
    }
    public boolean retrieveFollower(Follower follower){
        String Id = follower.getUserID() + follower.getFollowerID();
        Optional<Follower> record = followerRepository.findById(new UserFollowerGroupPK(follower.getUserID(), follower.getFollowerID()));
        if (record.isPresent()){
            throw new DataAccessException("Data Integrity Viloation") {
            };
        }
        return true;
    }
}
