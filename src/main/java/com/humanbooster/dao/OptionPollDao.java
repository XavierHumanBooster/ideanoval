package com.humanbooster.dao;

import com.humanbooster.business.OptionPoll;

public interface OptionPollDao {
	public boolean addOptionPoll(OptionPoll optionPoll);
	public OptionPoll findOptionPollById(int idOptionPoll);
	public boolean updateOptionPoll(OptionPoll optionPoll);
	public boolean deleteOptionPoll(OptionPoll optionPoll);
}
