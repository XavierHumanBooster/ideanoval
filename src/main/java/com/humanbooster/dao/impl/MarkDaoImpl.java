package com.humanbooster.dao.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.humanbooster.business.Mark;
import com.humanbooster.dao.MarkDao;

@SuppressWarnings("unchecked")
@Repository
public class MarkDaoImpl implements MarkDao {

	@Autowired
	private SessionFactory sessionFactory;

	public MarkDaoImpl() {
		// TODO Auto-generated constructor stub
	}

	public MarkDaoImpl(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	@Transactional
	public boolean addMark(Mark mark) {
		try {
			this.sessionFactory.getCurrentSession().save(mark);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	@Transactional(readOnly = true)
	public Mark findMarkByIdUserAndIdIdea(int idUser, int idIdea) {
		String queryString = "FROM Mark m WHERE m.idUser = :idUser AND m.idIdea = :idIdea";
		Query query = this.sessionFactory.getCurrentSession().createQuery(queryString);
		query.setInteger("idUser", idUser);
		query.setInteger("idIdea", idIdea);
		return (Mark) query.uniqueResult();
	}

	@Override
	@Transactional(readOnly = true)
	public List<Mark> findMarkByIdIdea(int idIdea) {
		String queryString = "FROM Mark m WHERE m.evaluableIdea.idIdea = :idIdea";
		Query query = this.sessionFactory.getCurrentSession().createQuery(queryString);
		query.setInteger("idIdea", idIdea);
		return query.list();
	}

	@Override
	@Transactional(readOnly = true)
	public List<Mark> findMarkByIdUser(int idUser) {
		String queryString = "FROM Mark m WHERE m.user.idUser = :idUser";
		Query query = this.sessionFactory.getCurrentSession().createQuery(queryString);
		query.setInteger("idUser", idUser);
		return query.list();
	}

	@Override
	@Transactional
	public boolean updateMark(Mark mark) {
		try {
			this.sessionFactory.getCurrentSession().update(mark);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	@Transactional
	public boolean deleteMark(Mark mark) {
		try {
			this.sessionFactory.getCurrentSession().delete(mark);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	@Transactional
	public List<HashMap<Integer, Integer>> findIdIdea() {
		String queryString = "SELECT m.evaluableIdea.idIdea, SUM(m.valueMark) FROM Mark m GROUP BY m.evaluableIdea.idIdea";
		Query query = this.sessionFactory.getCurrentSession().createQuery(queryString);
		query.setMaxResults(3);
		List<HashMap<Integer, Integer>> listReturn = new ArrayList<>();
		for(Object object : query.list()){
			listReturn.add((HashMap<Integer, Integer>)object);
		}
		return listReturn;
	}

	@Override
	@Transactional(readOnly = true)
	public List<Mark> findAllMark() {
		String queryString = "FROM Mark m";
		Query query = this.sessionFactory.getCurrentSession().createQuery(queryString);
		return query.list();
	}

}
