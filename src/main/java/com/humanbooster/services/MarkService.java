package com.humanbooster.services;

import java.util.HashMap;
import java.util.List;

import com.humanbooster.business.Mark;

public interface MarkService {
	public boolean addMark(Mark mark);
	public List<Mark> getMarksByIdIdea(int idIdea);
	public List<Mark> getMarksByIdUser(int idUser);
	public Mark getMarksByIdUserAndIdIdea(int idUser, int idIdea);
	public List<Mark> getAllMark();
	public List<HashMap<Integer, Integer>> getIdIdea();
}
