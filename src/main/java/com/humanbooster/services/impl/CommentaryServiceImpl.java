package com.humanbooster.services.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.humanbooster.business.Commentary;
import com.humanbooster.dao.CommentaryDao;
import com.humanbooster.services.CommentaryService;

@Service
public class CommentaryServiceImpl implements CommentaryService {
	
	@Autowired
	private CommentaryDao commentaryDao;

	public CommentaryServiceImpl() {
	}

	@Override
	public boolean addCommentary(Commentary commentary) {
		return commentaryDao.addCommentary(commentary);
	}

	@Override
	public List<Commentary> getCommentarysByIdUser(int idUser) {
		List<Commentary> commentaries = new ArrayList<>();
		commentaries = commentaryDao.findCommentaryByIdUser(idUser);
		return commentaries;
	}

	@Override
	public List<Commentary> getCommentarysByIdIdea(int idIdea) {
		List<Commentary> commentaries = new ArrayList<>();
		commentaries = commentaryDao.findCommentaryByIdIdea(idIdea);
		return commentaries;
	}

	@Override
	public List<Commentary> getAllCommentary() {
		return commentaryDao.findAllCommentary();
	}

	@Override
	public Commentary findCommentaryById(int idCommentary) {
		return commentaryDao.findCommentaryById(idCommentary);
	}

}
