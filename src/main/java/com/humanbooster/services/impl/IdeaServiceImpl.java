package com.humanbooster.services.impl;

import java.time.Instant;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.humanbooster.business.EvaluableIdea;
import com.humanbooster.business.Idea;
import com.humanbooster.dao.IdeaDao;
import com.humanbooster.services.IdeaService;

@Service
public class IdeaServiceImpl implements IdeaService {
	
	@Autowired
	private IdeaDao id;
	
	public IdeaServiceImpl() {}

	@Override
	public Idea findIdeaById(int idIdea) {
		Idea idea = id.findIdeaById (idIdea);
		return idea;
	}
	
	@Override
	public List<Integer> getAllIdFromIdea(){
		List<Integer> listeId = id.getAllIdFromIdea();
		return listeId ;
	}


	@Override
	public boolean addIdea(Idea idea) {
		idea.setPublishDateIdea(Date.from(Instant.now()));
		idea.setAvailableIdea(true);
		if(id.saveIdea(idea)){
			return true;
		}else{
		return false;
		}
	}

	@Override
	public boolean updateIdea(Idea idea) {
		
		return id.updateIdea(idea);
	}

	@Override
	public List<Idea> findEnableIdea() {
		return id.findEnableIdea();
	}

	@Override
	public Idea findIdeaByTitle(String titleIdea) {
		return id.findIdeaByTitle(titleIdea);

	}

	@Override
	public EvaluableIdea findEvaluableIdeaByID(int idIdea) {
		return id.findEvaluableIdeaById(idIdea);
	}

}
