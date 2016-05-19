package com.humanbooster.dao.impl;

import java.util.Date;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.humanbooster.business.Idea;
import com.humanbooster.dao.IdeaDao;

@SuppressWarnings("unchecked")
@Repository
public class IdeaDaoImpl implements IdeaDao {
	
	@Autowired
	private SessionFactory sessionFactory;

	public IdeaDaoImpl() {
		// TODO Auto-generated constructor stub
	}
	
	public IdeaDaoImpl(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	@Transactional
	public boolean saveIdea(Idea idea) {
		try{
			this.sessionFactory.getCurrentSession().save(idea);
			return true;
		}catch(Exception e){
			e.printStackTrace();
			return false;
		}
	}

	@Override
	@Transactional(readOnly=true)
	public Idea findIdeaById(int idIdea) {
		 try{
	            String query = "from Idea i where i.idIdea=:id";
	            Query hQuery = sessionFactory.getCurrentSession().createQuery(query);
	            hQuery.setInteger("id", idIdea);
	            return (Idea) hQuery.uniqueResult();
	        } catch(HibernateException e) {
	            e.printStackTrace();
	            return null;
	        }
	}
	
	@Override
	public Idea findIdeaByTitle(String titleIdea) {
		String queryString = "FROM Idea i WHERE i.titleIdea = :titleIdea";
		Query query = this.sessionFactory.getCurrentSession().createQuery(queryString);
		query.setString("titleIdea", titleIdea);
		return (Idea)query.uniqueResult();
	}

	@Override
	public List<Idea> findIdeaByDatePublish(Date date) {
		String queryString = "FROM Idea i WHERE i.publishDateIdea = :publishDateIdea";
		Query query = this.sessionFactory.getCurrentSession().createQuery(queryString);
		query.setDate("publishDateIdea", date);
		return query.list();
	}

	@Override
	public List<Idea> findIdeaByIdCategory(int idCategory) {
		String queryString = "FROM Idea i WHERE i.idCategory = :idCategory";
		Query query = this.sessionFactory.getCurrentSession().createQuery(queryString);
		query.setInteger("idCategory", idCategory);
		return query.list();
	}

	@Override
	public List<Idea> findIdeaByIdUser(int idUser) {
		String queryString = "FROM Idea i WHERE i.idUser = :idUser";
		Query query = this.sessionFactory.getCurrentSession().createQuery(queryString);
		query.setInteger("idUser", idUser);
		return query.list();
	}

	@Override
	public List<Idea> findEnableIdea() {
		String queryString = "FROM Idea i WHERE i.availableIdea = TRUE";
		Query query = this.sessionFactory.getCurrentSession().createQuery(queryString);
		return query.list();
	}

	@Override
	public List<Idea> findDisableIdea() {
		String queryString = "FROM Idea i WHERE i.availableIdea = FALSE";
		Query query = this.sessionFactory.getCurrentSession().createQuery(queryString);
		return query.list();
	}

	@Override
	public boolean updateIdea(Idea idea) {
		try{
			this.sessionFactory.getCurrentSession().update(idea);
			return true;
		}catch(Exception e){
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean deleteIdea(Idea idea) {
		try{
			this.sessionFactory.getCurrentSession().delete(idea);
			return true;
		}catch(Exception e){
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public List<Idea> findEvaluableIdeaByEndDate(Date endEvaluableIdea) {
		String queryString = "FROM Idea i WHERE i.endEvaluableIdea = :endEvaluableIdea";
		Query query = this.sessionFactory.getCurrentSession().createQuery(queryString);
		query.setDate("endEvaluableIdea", endEvaluableIdea);
		return query.list();
	}

	@Override
	public List<Idea> findPollByEndPoll(Date date) {
		String queryString = "FROM Idea i WHERE i.endPoll = :endPoll";
		Query query = this.sessionFactory.getCurrentSession().createQuery(queryString);
		query.setDate("endPoll", date);
		return query.list();
	}

}
