package com.web.carpool.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.web.carpool.model.User;
import com.web.carpool.repository.UserRepository;

@Service("userService")
public class UserServiceImpl implements UserService{

	@Autowired //decouple inject object, this is because i need to use the method of some obj
	private UserRepository userRepository; //inject vitual object, buyong new
	
	@Override
	public User findUserById(int id) {
		return userRepository.findById(id);
	}
}
