package com.example.TwitterApi.domain;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@ToString
@Getter
@Setter
@Data
@Builder
@NoArgsConstructor(access = AccessLevel.PUBLIC)
@AllArgsConstructor
@Entity
@Table(name = "USER_TABLE")
public class User {
    @Column(name = "USERID")
    @Id
    private String userID;

    @Column(name = "REGION")
    private String region;

    @Column(name = "EMAIL")
    private String emailId;

    @Column(name = "FOLLOWERCOUNT")
    private int followerCount;

}
