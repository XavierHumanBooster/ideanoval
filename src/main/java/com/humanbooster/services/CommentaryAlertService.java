package com.humanbooster.services;

import java.util.Date;
import java.util.List;

import com.humanbooster.business.CommentaryAlert;

public interface CommentaryAlertService {
	public boolean addCommentaryAlert(CommentaryAlert commentaryAlert);
	public List<CommentaryAlert> getCommentaryAlertsByIdDate(Date date);
}
