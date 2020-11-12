package com.cg.rest.service;

import com.cg.rest.exception.ResourceNotFoundException;
import com.cg.rest.model.User;

public interface IUserService {

	//public Movie save(Movie movie);
	public User save(User user);
	 public User findById(Long userId) throws ResourceNotFoundException;
}
