package com.humanbooster.services;

<<<<<<< HEAD
=======
import java.util.Date;
>>>>>>> origin/master
import java.util.List;

import com.humanbooster.business.CommentaryAlert;

public interface CommentaryAlertService {
<<<<<<< HEAD

	public List<CommentaryAlert> findAllCommentaryAlert();
	
	public boolean deleteCommentaryAlert(CommentaryAlert commentaryAlert);
=======
	public boolean addCommentaryAlert(CommentaryAlert commentaryAlert);
	public List<CommentaryAlert> getCommentaryAlertsByIdDate(Date date);
>>>>>>> origin/master
}
