package com.humanbooster.dao.impl;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.humanbooster.business.OptionPoll;
import com.humanbooster.dao.OptionPollDao;

@Repository
public class OptionPollDaoImpl implements OptionPollDao {

	@Autowired
	private SessionFactory sessionFactory;

	public OptionPollDaoImpl() {
		// TODO Auto-generated constructor stub
	}

	public OptionPollDaoImpl(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	@Transactional
	public boolean addOptionPoll(OptionPoll optionPoll) {
		try {
			this.sessionFactory.getCurrentSession().save(optionPoll);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	@Transactional(readOnly = true)
	public OptionPoll findOptionPollById(int idOptionPoll) {
		String queryString = "FROM OptionPoll o WHERE o.idOptionPoll = :idOptionPoll";
		Query query = this.sessionFactory.getCurrentSession().createQuery(queryString);
		query.setInteger("idOptionPoll", idOptionPoll);
		return (OptionPoll) query.uniqueResult();
	}

	@Override
	@Transactional
	public boolean updateOptionPoll(OptionPoll optionPoll) {
		try {
			this.sessionFactory.getCurrentSession().update(optionPoll);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	@Transactional
	public boolean deleteOptionPoll(OptionPoll optionPoll) {
		try {
			this.sessionFactory.getCurrentSession().delete(optionPoll);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

}
