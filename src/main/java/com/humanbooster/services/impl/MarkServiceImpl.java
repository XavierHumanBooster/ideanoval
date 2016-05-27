package com.humanbooster.services.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.humanbooster.business.Mark;
import com.humanbooster.dao.MarkDao;
import com.humanbooster.services.MarkService;

@Service
public class MarkServiceImpl implements MarkService {
	
	@Autowired
	private MarkDao markDao;

	public MarkServiceImpl() {
	}

	@Override
	public boolean addMark(Mark mark) {
		return markDao.addMark(mark);
	}

	@Override
	public List<Mark> getMarksByIdIdea(int idIdea) {
		List<Mark> marks = new ArrayList<>();
		marks = markDao.findMarkByIdIdea(idIdea);
		return marks;
	}

	@Override
	public List<Mark> getMarksByIdUser(int idUser) {
		List<Mark> marks = new ArrayList<>();
		marks = markDao.findMarkByIdUser(idUser);
		return marks;
	}

	@Override
	public Mark getMarksByIdUserAndIdIdea(int idUser, int idIdea) {
		return markDao.findMarkByIdUserAndIdIdea(idUser, idIdea);
	}

}
