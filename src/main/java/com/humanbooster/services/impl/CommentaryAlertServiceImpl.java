package com.humanbooster.services.impl;

import java.util.ArrayList;
<<<<<<< HEAD
=======
import java.util.Date;
>>>>>>> origin/master
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.humanbooster.business.CommentaryAlert;
import com.humanbooster.dao.CommentaryAlertDao;
import com.humanbooster.services.CommentaryAlertService;

@Service
public class CommentaryAlertServiceImpl implements CommentaryAlertService {
	
	@Autowired
<<<<<<< HEAD
	CommentaryAlertDao commentaryAlertDao;

	@Override
	public List<CommentaryAlert> findAllCommentaryAlert() {
		List<CommentaryAlert> commentaryAlert = new ArrayList<>();
		commentaryAlert = commentaryAlertDao.findAllCommentaryAlert();
		return commentaryAlert;
	}

	@Override
	public boolean deleteCommentaryAlert(CommentaryAlert commentaryAlert) {
		
		return commentaryAlertDao.deleteCommentaryAlert(commentaryAlert);
=======
	private CommentaryAlertDao commentaryAlertDao;

	public CommentaryAlertServiceImpl() {
	}

	@Override
	public boolean addCommentaryAlert(CommentaryAlert commentaryAlert) {
		return commentaryAlertDao.addCommentaryAlert(commentaryAlert);
	}

	@Override
	public List<CommentaryAlert> getCommentaryAlertsByIdDate(Date date) {
		List<CommentaryAlert> commentaryAlerts = new ArrayList<>();
		commentaryAlerts = commentaryAlertDao.findCommentaryAlertByIdDate(date);
		return commentaryAlerts;
>>>>>>> origin/master
	}

}
