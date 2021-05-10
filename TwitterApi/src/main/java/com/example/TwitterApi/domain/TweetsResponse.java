package com.example.TwitterApi.domain;

import lombok.*;

import java.util.List;

@ToString
@Getter
@Setter
@Data
@Builder
@NoArgsConstructor(access = AccessLevel.PUBLIC)
@AllArgsConstructor
public class TweetsResponse {
    private Long total;
    private List<TweetRequest> tweetList;
    private int currentPage;
    private int totalPages;
}
