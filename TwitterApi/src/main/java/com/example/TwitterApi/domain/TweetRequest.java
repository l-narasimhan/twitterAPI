package com.example.TwitterApi.domain;


import lombok.*;

import javax.persistence.*;
import java.util.Date;

@Data
@Builder
@NoArgsConstructor(access = AccessLevel.PUBLIC)
@AllArgsConstructor
@Entity
@Table(name = "TWEETS_TABLE")
public class TweetRequest {
    @Column(name = "USERID")
    private String userID;

    @Column(name = "TWEETID")
    @Id
    private String tweetID;

    @Column(name = "TWEETTEXT")
    private String tweetText;

    @Column(name = "CREATEDAT")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdAt;
}
