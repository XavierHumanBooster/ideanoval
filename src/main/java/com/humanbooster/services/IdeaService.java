package com.humanbooster.services;

import com.humanbooster.business.Idea;

public interface IdeaService {
	
	public Idea findIdeaById(int idIdea);

	public boolean addIdea(Idea idea);

}
