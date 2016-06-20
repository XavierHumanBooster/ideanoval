package com.humanbooster.dao;

import java.util.HashMap;
import java.util.List;

import com.humanbooster.business.Mark;

public interface MarkDao {
	public boolean addMark(Mark mark);
	public Mark findMarkByIdUserAndIdIdea(int idUser, int idIdea);
	public List<Mark> findMarkByIdIdea(int idIdea);
	public List<Mark> findMarkByIdUser(int idUser);
	public boolean updateMark(Mark mark);
	public boolean deleteMark(Mark mark);
	public List<Mark> findAllMark();
	public List<HashMap<Integer, Integer>> findIdIdea();
}
