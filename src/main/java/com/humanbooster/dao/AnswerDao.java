package com.humanbooster.dao;

import java.util.List;

import com.humanbooster.business.Answer;

public interface AnswerDao {
	public boolean addAnswer(Answer answer);
	public List<Answer> findAnswerByIdUser(int idUser);
	public List<Answer> findAnswerByIdIdea(int idIdea);
	public Answer findAnswerByIdIdeaAndIdUser(int idIdea, int idUser);
	public boolean updateAnswer(Answer answer);
	public boolean deleteAnswer(Answer answer);
}
