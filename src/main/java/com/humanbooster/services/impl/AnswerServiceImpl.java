package com.humanbooster.services.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.humanbooster.business.Answer;
import com.humanbooster.dao.AnswerDao;
import com.humanbooster.services.AnswerService;

@Service
public class AnswerServiceImpl implements AnswerService {
	
	@Autowired
	private AnswerDao answerDao;

	public AnswerServiceImpl() {
	}

	@Override
	public boolean addAnswer(Answer answer) {
		return answerDao.addAnswer(answer);
	}

	@Override
	public List<Answer> getAnswersByIdUser(int idUser) {
		List<Answer> answers = new ArrayList<>();
		answers = answerDao.findAnswerByIdUser(idUser);
		return answers;
	}

	@Override
	public List<Answer> getAnswersByIdIdea(int idIdea) {
		List<Answer> answers = new ArrayList<>();
		answers = answerDao.findAnswerByIdIdea(idIdea);
		return answers;
	}

}
