package com.demo.user.repository;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.demo.user.model.User;

public interface UserRepository extends JpaRepository<User, Integer> {
  
   
    List<User> findByUsername(String username);
    
	
}
