package com.example.demo.blog.services;

import java.util.List;

import com.example.demo.blog.payloads.CategoryDto;

public interface CategoryService {
	
	//Create
	public CategoryDto createCategory(CategoryDto categoryDto) ;
	
	//Update
	public CategoryDto updateCategory(CategoryDto categoryDto, Integer categoryId) ;
	
	//Delete
	
	public void deleteCategory(Integer categoryId) ;
	
	//get
	public CategoryDto getCategory(Integer categoryId) ;
	
	//getall
	List<CategoryDto> getCategories() ;
}
