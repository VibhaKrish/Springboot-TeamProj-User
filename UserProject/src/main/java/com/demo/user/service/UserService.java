package com.demo.user.service;


import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.user.exception.UserNotFoundException;
import com.demo.user.model.User;
import com.demo.user.repository.UserRepository;



@Service
public class UserService implements IUserService {

	private final Logger LOG = LoggerFactory.getLogger(this.getClass());

	@Autowired
	UserRepository userRepository;


	@Override
	public List<User> getAllUsers() {
		LOG.info("getAllUsers");
		return userRepository.findAll();
	}

	@Override
	public User getUserById(Integer uid)  { 
		LOG.info(uid.toString());
		Optional<User> userOpt = userRepository.findById(uid);
		if (userOpt.isPresent()) {
			return userOpt.get();
		} else {
			String errorMessage = "User with uid " + uid + " not found!";
			LOG.warn(errorMessage);
			throw new UserNotFoundException(errorMessage); 
		}
	}

	@Override
	public List<User> getuserByusername(String username) {
		LOG.info(username);
		return userRepository.findByUsername(username);
	}



	@Override
	public User updateUser(User user) {
		LOG.info(user.toString());
		
		return userRepository.save(user);
	}

	@Override
	public User deleteUser(Integer uid) {
		LOG.info(uid.toString());
		User user = this.getUserById(uid);
		userRepository.deleteById(uid);
		return user;
	}

	@Override
	public User addUser(User user)  {
		LOG.info(user.toString());
		return userRepository.save(user);
		
		
	}
}
