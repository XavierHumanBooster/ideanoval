package com.humanbooster.dao.impl;

import java.util.Date;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.humanbooster.business.User;
import com.humanbooster.business.UserLambda;
import com.humanbooster.dao.UserDao;

@SuppressWarnings("unchecked")
@Repository
public class UserDaoImpl implements UserDao {

	@Autowired
	private SessionFactory sessionFactory;

	public UserDaoImpl() {

	}

	public UserDaoImpl(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	// A RETOUCHER POUR FAIRE UN USER user ET FAIRE LE TRI DANS LE SERVICE ENTRE
	// ADMIN ET USERLAMBDA
	@Override
	@Transactional(readOnly = true)
	public boolean connectDaoUser(UserLambda user) {
		try {
			Query query = sessionFactory.getCurrentSession()
					.createQuery("FROM User u WHERE u.loginUser=:mail AND u.passwordUser=:pwd");
			query.setString("mail", user.getLoginUser());
			query.setString("pwd", user.getPasswordUser());
			user = (UserLambda) query.uniqueResult();

			if (user != null) {
				return true;
			} else {
				return false;
			}
		} catch (HibernateException ex) {
			ex.printStackTrace();
			return false;
		}

	}

	@Override
	@Transactional(readOnly = true)
	public UserLambda findUserByMail(String mail) {
		try {
			String query = "from User u where u.loginUser=:mail";
			Query hQuery = sessionFactory.getCurrentSession().createQuery(query);
			hQuery.setString("mail", mail);
			return (UserLambda) hQuery.uniqueResult();
		} catch (HibernateException e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	@Transactional(readOnly = true)
	public UserLambda findUserById(int idUser) {
		try {
			String query = "from User u where u.idUser=:id";
			Query hQuery = sessionFactory.getCurrentSession().createQuery(query);
			hQuery.setInteger("id", idUser);
			return (UserLambda) hQuery.uniqueResult();
		} catch (HibernateException e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	@Transactional
	public boolean saveUser(User user) {
		try {
			this.sessionFactory.getCurrentSession().save(user);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	@Transactional(readOnly = true)
	public User findUserByPseudo(String pseudoUser) {
		String queryString = "FROM User u WHERE u.pseudoUser = :pseudoUser";
		Query query = this.sessionFactory.getCurrentSession().createQuery(queryString);
		query.setString("pseudoUser", pseudoUser);
		return (User) query.uniqueResult();
	}

	@Override
	@Transactional
	public User findUserByLogin(String loginUser) {
		String queryString = "FROM User u WHERE u.loginUser = :loginUser";
		Query query = this.sessionFactory.getCurrentSession().createQuery(queryString);
		query.setString("loginUser", loginUser);
		return (User) query.uniqueResult();
	}

	@Override
	@Transactional
	public List<User> findUserByRegisterDate(Date date) {
		String queryString = "FROM User u WHERE u.registerDateUser = :date";
		Query query = this.sessionFactory.getCurrentSession().createQuery(queryString);
		query.setDate("date", date);
		return query.list();
	}

	@Override
	@Transactional
	public boolean updateUser(User user) {
		try {
			this.sessionFactory.getCurrentSession().update(user);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	@Transactional
	public boolean deleteUser(User user) {
		try {
			this.sessionFactory.getCurrentSession().delete(user);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	@Transactional
	public List<User> findUserIsApprouved() {
		String queryString = "FROM User u WHERE u.ApprouvedUser = TRUE";
		Query query = this.sessionFactory.getCurrentSession().createQuery(queryString);
		return query.list();
	}

	@Override
	@Transactional
	public List<User> findUserIsNotApprouved() {
		String queryString = "FROM User u WHERE u.ApprouvedUser = FALSE";
		Query query = this.sessionFactory.getCurrentSession().createQuery(queryString);
		return query.list();
	}

	@Override
	@Transactional
	public List<User> findUserIsAvailable() {
		String queryString = "FROM User u WHERE u.AvailableUser = TRUE";
		Query query = this.sessionFactory.getCurrentSession().createQuery(queryString);
		return query.list();
	}

	@Override
	@Transactional
	public List<User> findUserIsNotAvailable() {
		String queryString = "FROM User u WHERE u.AvailableUser = FALSE";
		Query query = this.sessionFactory.getCurrentSession().createQuery(queryString);
		return query.list();
	}

	@Override
	@Transactional
	public List<User> findUserIsDeleted() {
		String queryString = "FROM User u WHERE u.DeletedUser = TRUE";
		Query query = this.sessionFactory.getCurrentSession().createQuery(queryString);
		return query.list();
	}

	@Override
	@Transactional
	public List<User> findUserIsNotDeleted() {
		String queryString = "FROM User u WHERE u.DeletedUser = FALSE";
		Query query = this.sessionFactory.getCurrentSession().createQuery(queryString);
		return query.list();
	}

}
