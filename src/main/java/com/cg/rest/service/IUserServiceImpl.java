package com.cg.rest.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.cg.rest.exception.ResourceNotFoundException;
import com.cg.rest.model.User;
import com.cg.rest.repository.UserRepository;

@Component
public class IUserServiceImpl implements IUserService {
	
	@Autowired
	private UserRepository userRepo;

	
	public User save(User user) {
		
		return userRepo.save(user);
	}


	public User findById(Long userId) throws ResourceNotFoundException {
		User user = userRepo.findById(userId).orElseThrow(() -> new ResourceNotFoundException("No User Found with this id : " + userId));
		return user;
	
	}
	
}