package com.example.TwitterApi.domain;

import lombok.*;

import java.io.Serializable;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class UserFollowerGroupPK implements Serializable {
    private String userID;
    private String followerID;
}



