package com.em.expensemeter.service;

import java.math.BigInteger;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.em.expensemeter.dao.IUserDao;
import com.em.expensemeter.model.User;

@Service(value="userService")
@Transactional(propagation=Propagation.REQUIRED)
public class UserServiceImpl implements IUserService{

	@Autowired
	IUserDao userdao;

	@Override
	public List<User> getAllUsers() {
		return userdao.getAllUsers();
	}

	@Override
	public void addUser(User user) {
		userdao.addUser(user);		
	}

	@Override
	public void updateUser(User user) {
		userdao.updateUser(user);
	}

	@Override
	public void deleteUser(BigInteger id) {
		userdao.deleteUser(id);
	}

	@Override
	public User loadUserDetailsByUserName(String userName) {
		return userdao.loadUserDetailsByUserName(userName);
	}

	
}
