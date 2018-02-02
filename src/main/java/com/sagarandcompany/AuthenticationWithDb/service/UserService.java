package com.sagarandcompany.AuthenticationWithDb.service;


import com.sagarandcompany.AuthenticationWithDb.model.User;

public interface UserService {
	public User findUserByEmail(String email);
	public void saveUser(User user);
}
