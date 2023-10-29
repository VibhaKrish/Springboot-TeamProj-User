package com.demo.user.service;

import java.util.List;

import com.demo.user.model.User;



public interface IUserService {

	public abstract List<User> getAllUsers();

	public abstract User getUserById(Integer uid);

	public abstract User addUser(User user);
	

	public abstract User updateUser(User user);

	public abstract User deleteUser(Integer uid);
	public abstract List<User> getuserByusername(String username);
}
