package com.humanbooster.dao;

import java.util.Date;
import java.util.List;

import com.humanbooster.business.CommentaryAlert;

public interface CommentaryAlertDao {
	public boolean addCommentaryAlert(CommentaryAlert commentaryAlert);
	public CommentaryAlert findCommentaryAlertById(int idCommentary);
	public List<CommentaryAlert> findCommentaryAlertByIdUser(int idUser);
	public List<CommentaryAlert> findCommentaryAlertByIdDate(Date date);
	public boolean updateCommentaryAlert(CommentaryAlert commentaryAlert);
	public boolean deleteCommentaryAlert(CommentaryAlert commentaryAlert);
}
