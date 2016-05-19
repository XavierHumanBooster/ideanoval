package com.humanbooster.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.humanbooster.business.Commentary;
import com.humanbooster.dao.CommentaryDao;

@SuppressWarnings("unchecked")
@Repository
public class CommentaryDaoImpl implements CommentaryDao {

	@Autowired
	private SessionFactory sessionFactory;

	public CommentaryDaoImpl() {
		// TODO Auto-generated constructor stub
	}

	public CommentaryDaoImpl(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	@Transactional
	public boolean addCommentary(Commentary commentary) {
		try {
			this.sessionFactory.getCurrentSession().save(commentary);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	@Transactional(readOnly = true)
	public Commentary findCommentaryById(int idCommentary) {
		String queryString = "FROM Commentary c WHERE c.idCommentary = :idCommentary";
		Query query = this.sessionFactory.getCurrentSession().createQuery(queryString);
		query.setInteger("idCommentary", idCommentary);
		return (Commentary) query.uniqueResult();
	}

	@Override
	@Transactional(readOnly = true)
	public List<Commentary> findCommentaryByIdUser(int idUser) {
		String queryString = "FROM Commentary c WHERE c.idUser = :idUser";
		Query query = this.sessionFactory.getCurrentSession().createQuery(queryString);
		query.setInteger("idUser", idUser);
		return query.list();
	}

	@Override
	@Transactional(readOnly = true)
	public List<Commentary> findCommentaryByIdIdea(int idIdea) {
		String queryString = "FROM Commentary c WHERE c.idIdea = :idIdea";
		Query query = this.sessionFactory.getCurrentSession().createQuery(queryString);
		query.setInteger("idIdea", idIdea);
		return query.list();
	}

	@Override
	@Transactional
	public boolean updateCommentary(Commentary commentary) {
		try {
			this.sessionFactory.getCurrentSession().update(commentary);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	@Transactional
	public boolean deleteCommentary(Commentary commentary) {
		try {
			this.sessionFactory.getCurrentSession().delete(commentary);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

}
