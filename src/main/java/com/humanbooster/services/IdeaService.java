package com.humanbooster.services;

import java.util.List;

import com.humanbooster.business.EvaluableIdea;
import com.humanbooster.business.Idea;

public interface IdeaService {
	
	public Idea findIdeaById(int idIdea);
	
	public Idea findIdeaByTitle(String titleIdea);
	
	public EvaluableIdea findEvaluableIdeaByID(int idIdea);

	public boolean addIdea(Idea idea);
	
	public List<Integer> getAllIdFromIdea();

	public boolean updateIdea(Idea idea);

	public List<Idea> findEnableIdea();
	
	public List<Idea> getTenBestIdea();
	
	public List<Idea> getAllIdea();
}
