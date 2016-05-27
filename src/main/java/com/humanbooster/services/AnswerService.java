package com.humanbooster.services;

import java.util.List;

import com.humanbooster.business.Answer;

public interface AnswerService {
	
	public boolean addAnswer(Answer answer);
	
	public List<Answer> getAnswersByIdUser(int idUser);
	
	public List<Answer> getAnswersByIdIdea(int idIdea);
}
