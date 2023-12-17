package com.swifty.webapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.swifty.webapi.model.User;

public interface UserRepository extends JpaRepository<User, Long> {
  
}