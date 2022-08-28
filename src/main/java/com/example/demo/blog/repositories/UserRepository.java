package com.example.demo.blog.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.blog.entities.User;

public interface UserRepository extends JpaRepository<User,Integer> {
	

}
