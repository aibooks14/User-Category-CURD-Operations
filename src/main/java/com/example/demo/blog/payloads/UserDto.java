package com.example.demo.blog.payloads;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

public class UserDto {

	private Integer id;

	@NotEmpty
	@Size(min=4, message= "UserName must be minimum of 4 characters")
	private String name;

	@Email(message="Your email adress is not valid")
	private String email;

	@NotEmpty
	@Size(min=3, max=10, message="Password must be min of 3 and max of 10")
	private String password;

	@NotEmpty
	private String about;

	public UserDto() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getAbout() {
		return about;
	}

	public void setAbout(String about) {
		this.about = about;
	}

}
