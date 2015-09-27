package com.em.expensemeter.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.springframework.stereotype.Repository;

import com.em.expensemeter.model.ExpType;

@Repository
public class ExpTypeDaoImpl extends HibernateSessionDao implements IExpTypeDao  {
	
	@SuppressWarnings("unchecked")
	@Override
	public List<ExpType> getAllExpenseType() {
		Criteria crt =  getSession().createCriteria(ExpType.class);
		crt.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
		return crt.list();
	}

	@Override
	public void addExpenseType(ExpType expType) {
		getSession().save(expType);
	}

	@Override
	public void updateExpenseType(ExpType expType) {
		getSession().saveOrUpdate(expType);
		
	}

	@Override
	public void deleteExpenseType(int id) {
		ExpType expType = (ExpType) getSession().load(ExpType.class, id);
		if(expType != null){
			getSession().delete(expType);
		}
	}

	@Override
	public ExpType getExpenseTypeDetailsById(int id) {
		ExpType expType = (ExpType) getSession().get(ExpType.class, id);
		return expType;
	}

}
