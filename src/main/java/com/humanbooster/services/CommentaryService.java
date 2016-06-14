package com.humanbooster.services;

import java.util.List;

import com.humanbooster.business.Commentary;

public interface CommentaryService {
	public boolean addCommentary(Commentary commentary);
	public List<Commentary> getCommentarysByIdUser(int idUser);
	public List<Commentary> getCommentarysByIdIdea(int idIdea);
	public List<Commentary> getAllCommentary();
}
