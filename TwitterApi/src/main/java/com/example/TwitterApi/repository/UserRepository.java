package com.example.TwitterApi.repository;

import com.example.TwitterApi.domain.User;
import io.micrometer.core.annotation.Timed;
import org.springframework.data.jpa.repository.JpaRepository;

@Timed
public interface UserRepository extends JpaRepository<User, String> {
}
