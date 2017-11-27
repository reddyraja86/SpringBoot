package com.opentext.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.opentext.model.User;

public interface UserRepository extends JpaRepository<User,Integer>{
   // User findByName(String name);
	
	
}