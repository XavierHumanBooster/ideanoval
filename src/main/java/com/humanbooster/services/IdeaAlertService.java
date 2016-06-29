package com.humanbooster.services;

import java.util.List;

import com.humanbooster.business.IdeaAlert;

public interface IdeaAlertService {

	public List<IdeaAlert> findAllIdeaAlert();
	
	public IdeaAlert findIdeaAlertByIdIdea(int idIdea);
	
	public boolean deleteIdeaAlert(IdeaAlert ideaAlert);
	
	public boolean addIdeaAlert(IdeaAlert ideaAlert);
}