package com.humanbooster.dao.impl;

import java.util.Date;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.humanbooster.business.IdeaAlert;
import com.humanbooster.dao.IdeaAlertDao;

@SuppressWarnings("unchecked")
@Repository
public class IdeaAlertDaoImpl implements IdeaAlertDao {

	@Autowired
	private SessionFactory sessionFactory;

	public IdeaAlertDaoImpl() {
		// TODO Auto-generated constructor stub
	}

	public IdeaAlertDaoImpl(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	@Transactional
	public boolean addIdeaAlert(IdeaAlert ideaAlert) {
		try {
			this.sessionFactory.getCurrentSession().save(ideaAlert);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	@Transactional(readOnly = true)
	public IdeaAlert findIdeaAlertById(int idIdeaAlert) {
		String queryString = "FROM IdeaAlert i WHERE i.idIdeaAlert = :idIdeaAlert";
		Query query = this.sessionFactory.getCurrentSession().createQuery(queryString);
		query.setInteger("idIdeaAlert", idIdeaAlert);
		return (IdeaAlert) query.uniqueResult();
	}

	@Override
	@Transactional(readOnly = true)
	public List<IdeaAlert> findIdeaAlertByIdUser(int idUser) {
		String queryString = "FROM IdeaAlert i WHERE i.idUser = :idUser";
		Query query = this.sessionFactory.getCurrentSession().createQuery(queryString);
		query.setInteger("idUser", idUser);
		return query.list();
	}

	@Override
	@Transactional(readOnly = true)
	public List<IdeaAlert> findIdeaAlertByDate(Date date) {
		String queryString = "FROM IdeaAlert i WHERE i.dateIdeaAlert = :dateIdeaAlert";
		Query query = this.sessionFactory.getCurrentSession().createQuery(queryString);
		query.setDate("dateIdeaAlert", date);
		return query.list();
	}

	@Override
	@Transactional
	public boolean updateIdeaAlert(IdeaAlert ideaAlert) {
		try {
			this.sessionFactory.getCurrentSession().update(ideaAlert);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	@Transactional
	public boolean deleteIdeaAlert(IdeaAlert ideaAlert) {
		try {
			this.sessionFactory.getCurrentSession().delete(ideaAlert);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

}
