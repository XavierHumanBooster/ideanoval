package com.humanbooster.services;

import com.humanbooster.business.User;
import com.humanbooster.business.UserLambda;

public interface UserService {
	
	public boolean connectUser(String login, String password);

	public User findUserByMail(String loginUser);

	public UserLambda findUserById(int idUser);

	public boolean addUser(User user);

}
