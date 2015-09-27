package com.em.expensemeter.dao;

import java.util.List;

import com.em.expensemeter.model.ExpType;

public interface IExpTypeDao {

	/**
	 * @return List<ExpType>
	 */
	public List<ExpType> getAllExpenseType();

	/**
	 * @param expType
	 */
	public void addExpenseType(ExpType expType);

	/**
	 * @param expType
	 */
	public void updateExpenseType(ExpType expType);

	/**
	 * @param id
	 */
	public void deleteExpenseType(int id);

	/**
	 * @param id
	 * @return ExpType
	 */
	public ExpType getExpenseTypeDetailsById(int id);
}
