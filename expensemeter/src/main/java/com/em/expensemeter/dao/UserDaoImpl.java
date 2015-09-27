package com.em.expensemeter.dao;

import java.math.BigInteger;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.em.expensemeter.model.User;

@Repository(value="userDao")
public class UserDaoImpl extends HibernateSessionDao implements IUserDao {

	public void sessionTesting() {
		System.out.println("getSession() = " + getSession());

	}

	@SuppressWarnings("unchecked")
	@Override
	public List<User> getAllUsers() {
		Criteria crt = getSession().createCriteria(User.class);
		return crt.list();
	}

	@Override
	public void addUser(User user) {
		getSession().persist(user);
	}

	@Override
	public void updateUser(User user) {
		getSession().update(user);
	}

	@Override
	public void deleteUser(BigInteger userId) {
		User usr =  (User) getSession().load(User.class, userId);
		if (usr != null) {
			getSession().delete(usr);
		}
	}

	@Override
	public User loadUserDetailsByUserName(String userName) {
		System.out.println("user name =  "+userName);
		Criteria crt = getSession().createCriteria(User.class);
		crt.add(Restrictions.eq("userName", userName));
		crt.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
		User user = (User) crt.uniqueResult();
		return user;
	}

}
