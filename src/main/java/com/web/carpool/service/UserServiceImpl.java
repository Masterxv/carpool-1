package com.web.carpool.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.web.carpool.model.User;
import com.web.carpool.repository.UserRepository;

@Service("userService")
public class UserServiceImpl implements UserService {
	
	@Autowired
	@Qualifier("userRepository")
	private UserRepository userRepository;

	@Override
	public User findUserById(int id) {
		return userRepository.findById(id);
	}

	@Override
	public User findUserByUsername(String username) {
		return userRepository.findByUsername(username);
	}

	@Override
	public User findUserByEmail(String email) {
		return userRepository.findByEmail(email);
	}

	
	@Override
	public List<User> findAll() {
		return userRepository.findAll();
	}

	public User createUser(User user) {
        User lastUser = userRepository.findTopByOrderByIdDesc();
		return userRepository.save(user.setId((lastUser != null) ? (userRepository.findTopByOrderByIdDesc().getId() + 1) : 1));
	}
}
