package com.cg.rest.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cg.rest.exception.ResourceNotFoundException;
import com.cg.rest.model.User;
import com.cg.rest.service.IUserServiceImpl;

@RestController
public class UserController {
	
	@Autowired
	private IUserServiceImpl iuserServiceImpl;
	
	@PostMapping("/users/new")
	public User addUser(@RequestBody User user) {
		return iuserServiceImpl.save(user);
	}
	
	@PutMapping("/users/update/{id}")
	 public ResponseEntity<User> updateUser(@PathVariable(value = "id") Long userId, @RequestBody User userDetails) throws ResourceNotFoundException {
		User user = iuserServiceImpl.findById(userId);
		user.setFirstName(userDetails.getFirstName());
        user.setMiddleName(userDetails.getMiddleName());
        user.setLastName(userDetails.getLastName());
        user.setEmail(userDetails.getEmail());
        user.setMobileNumber(userDetails.getMobileNumber());
        user.setAadharCardNo(userDetails.getAadharCardNo());
        User updatedUser = iuserServiceImpl.save(user);
        return ResponseEntity.ok(updatedUser);
    }
}
