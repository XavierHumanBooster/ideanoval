package com.humanbooster.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.humanbooster.business.Answer;
import com.humanbooster.dao.AnswerDao;

@SuppressWarnings("unchecked")
@Repository
public class AnswerDaoImpl implements AnswerDao {

	@Autowired
	private SessionFactory sessionFactory;

	public AnswerDaoImpl() {
	}

	public AnswerDaoImpl(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	@Transactional
	public boolean addAnswer(Answer answer) {
		try {
			this.sessionFactory.getCurrentSession().save(answer);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	@Transactional(readOnly = true)
	public List<Answer> findAnswerByIdUser(int idUser) {
		String queryString = "FROM Answer a WHERE a.idUser = :idUser";
		Query query = this.sessionFactory.getCurrentSession().createQuery(queryString);
		query.setInteger("idUser", idUser);
		return query.list();
	}

	@Override
	@Transactional(readOnly = true)
	public List<Answer> findAnswerByIdIdea(int idIdea) {
		String queryString = "FROM Answer a WHERE a.idIdea = :idIdea";
		Query query = this.sessionFactory.getCurrentSession().createQuery(queryString);
		query.setInteger("idIdea", idIdea);
		return query.list();
	}

	@Override
	@Transactional(readOnly = true)
	public Answer findAnswerByIdIdeaAndIdUser(int idIdea, int idUser) {
		String queryString = "FROM Answer a WHERE a.idIdea = :idIdea AND a.idUser = :idUser";
		Query query = this.sessionFactory.getCurrentSession().createQuery(queryString);
		query.setInteger("idIdea", idIdea);
		query.setInteger("idUser", idUser);
		return (Answer) query.uniqueResult();
	}

	@Override
	@Transactional
	public boolean updateAnswer(Answer answer) {
		try {
			this.sessionFactory.getCurrentSession().update(answer);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	@Transactional
	public boolean deleteAnswer(Answer answer) {
		try {
			this.sessionFactory.getCurrentSession().delete(answer);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

}
