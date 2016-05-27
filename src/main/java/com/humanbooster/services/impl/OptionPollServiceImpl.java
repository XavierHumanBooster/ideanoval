package com.humanbooster.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.humanbooster.business.OptionPoll;
import com.humanbooster.dao.OptionPollDao;
import com.humanbooster.services.OptionPollService;

@Service
public class OptionPollServiceImpl implements OptionPollService {
	
	@Autowired
	private OptionPollDao optionPollDao;

	public OptionPollServiceImpl() {
	}

	@Override
	public boolean addOptionPoll(OptionPoll optionPoll) {
		return optionPollDao.addOptionPoll(optionPoll);
	}

}
