package com.example.demo.blog.controller;


import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.blog.payloads.UserDto;
import com.example.demo.blog.services.UserService;

@RestController
@RequestMapping("api/users")
public class UserController {
	
	@Autowired
	private UserService userService; 
	
	//Post Create-user
	@PostMapping("/")
	public ResponseEntity<UserDto>createUser(@Valid @RequestBody UserDto userDto){
		UserDto createUserDto =this.userService.createUser(userDto) ;
		return new ResponseEntity<>(createUserDto, HttpStatus.CREATED) ;
	}
	
	
	//Put- update user
	@PutMapping("/{userId}")
	public ResponseEntity<UserDto> updateUser(@Valid @RequestBody UserDto userDto, @PathVariable("userId") Integer userId){
		UserDto updatedUser =this.userService.updateUser(userDto, userId) ;
		return ResponseEntity.ok(updatedUser) ;
	}
	
	//Delete- delete user
	@DeleteMapping("/{userId}")
	public ResponseEntity<?> deleteUser(@PathVariable("userId") Integer userId){
		this.userService.deleteUser(userId) ;
		return ResponseEntity.ok(Map.of("message" , "User Deleted Successfully")) ;
	}

	
	//Get -user
	@GetMapping("/")
	public ResponseEntity<List<UserDto>> getAllUsers() {
		return ResponseEntity.ok(this.userService.getAllUsers()) ;
		
	}
	
	@GetMapping("/{userId}")
	public ResponseEntity <UserDto> getAllUsers(@PathVariable Integer userId) {
		return ResponseEntity.ok(this.userService.getUserById(userId)) ;
		
	}

}
