package com.humanbooster.services;

import java.util.List;

import com.humanbooster.business.User;
import com.humanbooster.business.UserLambda;

public interface UserService {
	
	public boolean connectUser(String login, String password);
	
	public boolean connectAdmin(String login, String password);

	public User findUserByMail(String loginUser);

	public UserLambda findUserById(int idUser);

	public boolean addUser(UserLambda user);
	
	public boolean updateUser(UserLambda user);
	
	public boolean deleteUser(UserLambda user);
	
	public List<UserLambda> findAllNotApprouvedUser();

}
