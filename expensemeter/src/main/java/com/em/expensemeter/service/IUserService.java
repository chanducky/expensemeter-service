package com.em.expensemeter.service;

import java.math.BigInteger;
import java.util.List;

import com.em.expensemeter.model.User;

public interface IUserService {

	public List<User> getAllUsers();

	public void addUser(User user);

	public void updateUser(User user);

	public void deleteUser(BigInteger userId);

	public User loadUserDetailsByUserName(String username);

}
