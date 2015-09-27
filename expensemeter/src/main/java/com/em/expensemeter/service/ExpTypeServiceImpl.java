package com.em.expensemeter.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.em.expensemeter.dao.IExpTypeDao;
import com.em.expensemeter.model.ExpType;

@Service
@Transactional(propagation=Propagation.REQUIRED)
public class ExpTypeServiceImpl implements IExpTypeService {

	@Autowired
	IExpTypeDao expTypeDao;

	@Override
	public List<ExpType> getAllExpenseType() {
		return expTypeDao.getAllExpenseType();
	}

	@Override
	public void addExpenseType(ExpType expType) {
		expTypeDao.addExpenseType(expType);		
	}

	@Override
	public void updateExpenseType(ExpType expType) {
		expTypeDao.updateExpenseType(expType);
	}

	@Override
	public void deleteExpenseType(int id) {
		expTypeDao.deleteExpenseType(id);
	}

	@Override
	public ExpType getExpenseTypeDetailsById(int id) {
		return expTypeDao.getExpenseTypeDetailsById(id);
	}

}
