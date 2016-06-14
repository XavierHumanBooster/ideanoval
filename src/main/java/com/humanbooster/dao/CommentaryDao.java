package com.humanbooster.dao;

import java.util.List;

import com.humanbooster.business.Commentary;

public interface CommentaryDao {
	public boolean addCommentary(Commentary commentary);
	public Commentary findCommentaryById(int idCommentary);
	public List<Commentary> findCommentaryByIdUser(int idUser);
	public List<Commentary> findCommentaryByIdIdea(int idIdea);
	public boolean updateCommentary(Commentary commentary);
	public boolean deleteCommentary(Commentary commentary);
	public List<Commentary> findAllCommentary();
}
