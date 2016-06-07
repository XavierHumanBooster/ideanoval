package com.humanbooster.dao;

import java.util.Date;
import java.util.List;

import com.humanbooster.business.EvaluableIdea;
import com.humanbooster.business.Idea;

public interface IdeaDao {
	public Idea findIdeaById(int idIdea);
	public Idea findIdeaByTitle(String titleIdea);
	public List<Idea> findIdeaByDatePublish(Date date);
	public List<Idea> findIdeaByIdCategory(int idCategory);
	public List<Idea> findIdeaByIdUser(int idUser);
	public List<Idea> findEnableIdea();
	public List<Idea> findDisableIdea();
	public boolean updateIdea(Idea idea);
	public boolean deleteIdea(Idea idea);
	public List<Idea> findEvaluableIdeaByEndDate(Date endEvaluableIdea);
	public List<Idea> findPollByEndPoll(Date date);
	public boolean saveIdea(Idea idea);
	public List<Integer> getAllIdFromIdea();
	public List<Idea> findTenBestIdea();
	public List<Idea> findTenCommentedIdea();
	public EvaluableIdea findEvaluableIdeaById(int idIdea);
}
