package com.christinac.java.services;

import java.util.List;
import java.util.Optional;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;

import com.christinac.java.models.LoginUser;
import com.christinac.java.models.User;
import com.christinac.java.repositories.UserRepository;

@Service
public class UserService {
	
	@Autowired
	private UserRepository userRepo;
	
	public List<User> findAll(){
		return userRepo.findAll();
	}
	
	public User findById(Long id){
		Optional<User> optionalUser = userRepo.findById(id);
		if (optionalUser.isPresent()) {
			return optionalUser.get();
		} else {
			return null;
		}
	}
	
	public User register(User u, BindingResult result) {
		// if the confirmPassword != password
		String userEmail = u.getEmail();
		Optional<User> potentialUser = userRepo.findByEmail(userEmail);
		if(potentialUser.isPresent()) {
			result.rejectValue("email", null, "This email is already taken");
		}
		if(!u.getConfirmPass().equals(u.getPassword())) {
			// add error to your confirPassword input in your jsp
			result.rejectValue("confirPassword", null, "Passwords do not match!");
		}
		if (result.hasErrors()) {
			return null;
		}
		String hashPW = BCrypt.hashpw(u.getPassword(), BCrypt.gensalt());
		u.setPassword(hashPW);
		return userRepo.save(u);
	}
	
	public User login(LoginUser l, BindingResult result) {
		Optional<User> optionalUser = userRepo.findByEmail(l.getEmail());
		if (optionalUser.isEmpty() || !BCrypt.checkpw(l.getPassword(), optionalUser.get().getPassword())){
			result.rejectValue("password", null, "Incorrect email or password!");
			return null;
		} else {
			return optionalUser.get();
		}
		
	}
}
