package com.example.TwitterApi.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@IdClass(UserFollowerGroupPK.class)
@Table(name = "FOLLOWERS_TABLE")
public class Follower {

    @Column(name = "USERID")
    @Id
    private String userID;

    @Column(name = "FOLLOWERID")
    @Id
    private String followerID;

}
