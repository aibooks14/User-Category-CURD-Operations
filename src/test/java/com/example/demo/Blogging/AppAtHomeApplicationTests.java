package com.example.demo.Blogging;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.blog.repositories.UserRepository;

@SpringBootTest
class AppAtHomeApplicationTests {
	
	@Autowired
	private UserRepository userRepository ;

	@Test
	void contextLoads() {
	}
	
	@Test
	public void repositoryTest() {
		String className = this.userRepository.getClass().getName() ;
		String packageName = this.userRepository.getClass().getPackageName() ;
		System.out.println(className);
		System.out.println(packageName);
	}

}
