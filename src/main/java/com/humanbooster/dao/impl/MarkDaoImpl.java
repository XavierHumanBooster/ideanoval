package com.humanbooster.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

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
	public boolean addMark(Mark mark) {
		try{
			this.sessionFactory.getCurrentSession().save(mark);
			return true;
		}catch(Exception e){
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public Mark findMarkByIdUserAndIdIdea(int idUser, int idIdea) {
		String queryString = "FROM Mark m WHERE m.idUser = :idUser AND m.idIdea = :idIdea";
		Query query = this.sessionFactory.getCurrentSession().createQuery(queryString);
		query.setInteger("idUser", idUser);
		query.setInteger("idIdea", idIdea);
		return (Mark)query.uniqueResult();
	}

	@Override
	public List<Mark> findMarkByIdIdea(int idIdea) {
		String queryString = "FROM Mark m WHERE m.idIdea = :idIdea";
		Query query = this.sessionFactory.getCurrentSession().createQuery(queryString);
		query.setInteger("idIdea", idIdea);
		return query.list();
	}

	@Override
	public List<Mark> findMarkByIdUser(int idUser) {
		String queryString = "FROM Mark m WHERE m.idUser = :idUser";
		Query query = this.sessionFactory.getCurrentSession().createQuery(queryString);
		query.setInteger("idUser", idUser);
		return query.list();
	}

	@Override
	public boolean updateMark(Mark mark) {
		try{
			this.sessionFactory.getCurrentSession().update(mark);
			return true;
		}catch(Exception e){
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean deleteMark(Mark mark) {
		try{
			this.sessionFactory.getCurrentSession().delete(mark);
			return true;
		}catch(Exception e){
			e.printStackTrace();
			return false;
		}
	}

}
