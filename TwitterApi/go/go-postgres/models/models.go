package models

import (
	"time"
)

// User schema of the user table
type Tweet struct {
    UserID   string  `json:"userId"`
    TweetID  string `json:"tweetId"`
    TweetText string `json:"tweetText"`
    CreatedAt  time.Time  `json:"createdAt"`
}

