package com.christinac.java.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.christinac.java.models.User;
import com.christinac.java.repositories.UserRepository;

@Service
public class UserService {
	
	@Autowired
	private UserRepository userRepo;
	
	public List<User> findAll(){
		return userRepo.findAll();
	}
}
