package com.example.demo.blog.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.blog.entities.Category;

public interface CategoryRespository extends JpaRepository<Category, Integer> {

}
