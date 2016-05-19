package com.humanbooster.dao;

import java.util.Date;
import java.util.List;

import com.humanbooster.business.User;
import com.humanbooster.business.UserLambda;

public interface UserDao {
	
	public UserLambda findUserById(int idUser);
	public User findUserByPseudo(String pseudoUser);
	public User findUserByLogin(String loginUser);
	public List<User> findUserByRegisterDate(Date date);
	public boolean updateUser(User user);
	public boolean deleteUser(User user);
	public List<User> findUserIsApprouved();
	public List<User> findUserIsNotApprouved();
	public List<User> findUserIsAvailable();
	public List<User> findUserIsNotAvailable();
	public List<User> findUserIsDeleted();
	public List<User> findUserIsNotDeleted();
	public boolean saveUser(User user);
	boolean connectDaoUser(UserLambda user);
	UserLambda findUserByMail(String mail);
}
