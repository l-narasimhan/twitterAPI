package com.example.TwitterApi.domain;


import lombok.*;
import net.minidev.json.JSONObject;

import java.util.Date;

@ToString
@Getter
@Setter
@Data
@Builder
@NoArgsConstructor(access = AccessLevel.PUBLIC)
@AllArgsConstructor
public class Tweet {

    private String userID;

    private String tweetID;

    private String tweetText;

    private String createdAt;

}
