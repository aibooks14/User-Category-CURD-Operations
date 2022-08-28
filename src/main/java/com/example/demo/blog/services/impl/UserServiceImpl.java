package com.example.demo.blog.services.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.blog.entities.User;
import com.example.demo.blog.payloads.UserDto;
import com.example.demo.blog.repositories.UserRepository;
import com.example.demo.blog.services.UserService;
import com.example.demo.blog.exceptions.ResourceNotFoundException ;

@Service
public class UserServiceImpl  implements UserService{
	
	@Autowired
	private UserRepository userRepository ;
	
	@Autowired
	private ModelMapper modelMapper ;

	@Override
	public UserDto createUser(UserDto userDto) {
		User user = this.dtoToUser(userDto) ;
		User savedUser = this.userRepository.save(user) ;
		return this.userToUserDto(savedUser) ;
	}

	@Override
	public UserDto updateUser(UserDto userDto, Integer userId) {
		User user = this.userRepository.findById(userId).orElseThrow(()-> new ResourceNotFoundException ("User", "Id", userId)) ;
		
		user.setName(userDto.getName());
		user.setEmail(userDto.getEmail());
		user.setPassword(userDto.getPassword());
		user.setAbout(userDto.getAbout());
		
		User updatedUser = this.userRepository.save(user) ;
		UserDto userDto1 = this.userToUserDto(updatedUser);
		return userDto1;
	}

	@Override
	public UserDto getUserById(Integer userId) {
		User user = this.userRepository.findById(userId).orElseThrow(()-> new ResourceNotFoundException ("User", "Id", userId)) ;
		return this.userToUserDto(user);
	}
	@Override
	public List<UserDto> getAllUsers() {
		List<User> users = this.userRepository.findAll(); //Multiple users
		
		//Convert Users list into userDto list
		List<UserDto> userDtos =users.stream().map(user->this.userToUserDto(user)).collect(Collectors.toList()) ;
		return userDtos;
	}

	@Override
	public void deleteUser(Integer userId) {
		User user = this.userRepository.findById(userId).orElseThrow(()-> new ResourceNotFoundException ("User", "Id", userId)) ;
		this.userRepository.delete(user);
		
	}
	
	//Using modelMapper
	
	public User dtoToUser(UserDto userDto) {
		User user = this.modelMapper.map(userDto, User.class) ;
		return user ;
	}
	
	//Use to Convert 
	public UserDto userToUserDto(User user) {
		UserDto userDto = this.modelMapper.map(user, UserDto.class) ;
		return userDto ;
	}
	
	//Use to convert UserDto to User
//	public User dtoToUser(UserDto userDto) {
//		User user= new User() ;
//		user.setId(userDto.getId());
//		user.setName(userDto.getName());
//		user.setEmail(userDto.getEmail());
//		user.setAbout(userDto.getAbout());
//		user.setPassword(userDto.getPassword());
//		return  user ;
//	}
//	
//	//Use to Convert 
//	public UserDto userToUserDto(User user) {
//		UserDto userDto = new UserDto() ;
//		userDto.setId(user.getId());
//		userDto.setName(user.getName());
//		userDto.setEmail(user.getEmail());
//		userDto.setAbout(user.getAbout()) ;
//		userDto.setPassword(user.getPassword());
//		return userDto ;
//	}

}
