package com.humanbooster.services.impl;

import java.sql.Date;
import java.time.Instant;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.humanbooster.business.UserLambda;
import com.humanbooster.dao.UserDao;
import com.humanbooster.services.UserService;
import com.humanbooster.utils.Encryption;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserDao ud;

	@Override
	public boolean connectUser(String login, String password) {
		UserLambda user = new UserLambda();
		user.setLoginUser(login);
		user.setPasswordUser(password);
		boolean bool = ud.connectDaoUser(user);

		return bool;
	}

	@Override
	public UserLambda findUserByMail(String loginUser) {

		UserLambda user = ud.findUserByMail(loginUser);

		return user;
	}

	@Override
	public UserLambda findUserById(int idUser) {
		UserLambda user = ud.findUserById(idUser);

		return user;
	}

	@Override
	public boolean addUser(UserLambda user) {
		user.setRegisterDateUser(Date.from(Instant.now()));
		user.setApprouvedUser(false);
		user.setAvailableUser(true);
		user.setDeletedUser(false);
		user.setPasswordUser(Encryption.encryption(user.getPasswordUser()));
		if (ud.saveUser(user)) {
			return true;
		} else {
			return false;
		}
	}

}
