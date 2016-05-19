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
	public List<UserLambda> findUserIsApprouved();
	public List<UserLambda> findUserIsNotApprouved();
	public List<UserLambda> findUserIsAvailable();
	public List<UserLambda> findUserIsNotAvailable();
	public List<UserLambda> findUserIsDeleted();
	public List<UserLambda> findUserIsNotDeleted();
	public boolean saveUser(User user);
	boolean connectDaoUser(User user);
	User findUserByMail(String mail);
}
