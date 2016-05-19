package com.humanbooster.dao.impl;

import java.util.Date;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.humanbooster.business.CommentaryAlert;
import com.humanbooster.dao.CommentaryAlertDao;

@SuppressWarnings("unchecked")
@Repository
public class CommentaryAlertDaoImpl implements CommentaryAlertDao {

	@Autowired
	private SessionFactory sessionFactory;

	public CommentaryAlertDaoImpl() {
		// TODO Auto-generated constructor stub
	}

	public CommentaryAlertDaoImpl(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	@Transactional
	public boolean addCommentaryAlert(CommentaryAlert commentaryAlert) {
		try {
			this.sessionFactory.getCurrentSession().save(commentaryAlert);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	@Transactional(readOnly = true)
	public CommentaryAlert findCommentaryAlertById(int idCommentary) {
		String queryString = "FROM CommentaryAlert c WHERE c.idCommentary = :idCommentary";
		Query query = this.sessionFactory.getCurrentSession().createQuery(queryString);
		query.setInteger("idCommentary", idCommentary);
		return (CommentaryAlert) query.uniqueResult();
	}

	@Override
	@Transactional(readOnly = true)
	public List<CommentaryAlert> findCommentaryAlertByIdUser(int idUser) {
		String queryString = "FROM CommentaryAlert c WHERE c.idUser = :idUser";
		Query query = this.sessionFactory.getCurrentSession().createQuery(queryString);
		query.setInteger("idUser", idUser);
		return query.list();
	}

	@Override
	@Transactional(readOnly = true)
	public List<CommentaryAlert> findCommentaryAlertByIdDate(Date date) {
		String queryString = "FROM CommentaryAlert c WHERE c.dateCommentaryAlert = :dateCommentaryAlert";
		Query query = this.sessionFactory.getCurrentSession().createQuery(queryString);
		query.setDate("idCommentary", date);
		return query.list();
	}

	@Override
	@Transactional
	public boolean updateCommentaryAlert(CommentaryAlert commentaryAlert) {
		try {
			this.sessionFactory.getCurrentSession().update(commentaryAlert);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	@Transactional
	public boolean deleteCommentaryAlert(CommentaryAlert commentaryAlert) {
		try {
			this.sessionFactory.getCurrentSession().delete(commentaryAlert);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

}
