package com.em.expensemeter.service;

import java.util.List;

import com.em.expensemeter.model.ExpType;

public interface IExpTypeService {
	
	public List<ExpType> getAllExpenseType();
	public void addExpenseType(ExpType expType);
	public void updateExpenseType(ExpType expType);
	public void deleteExpenseType(int id);
	public ExpType getExpenseTypeDetailsById(int id);

}
