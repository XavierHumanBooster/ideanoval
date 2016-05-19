package com.humanbooster.business;

import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
public class Poll extends Idea {

	private static final long serialVersionUID = 1L;
	
//======================
//Attributs
//======================
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	private Date endPoll;
	
	@OneToMany(mappedBy = "poll", fetch = FetchType.LAZY)
	private List<Answer> answers;
	
	@ManyToMany
	@JoinTable(name = "poll_optionPoll", joinColumns = @JoinColumn(name = "idIdea"), inverseJoinColumns = @JoinColumn(name = "idOptionPoll"))
	private List<OptionPoll> options;
	
//======================
//Constructors
//======================
	public Poll() {
	}
	
	public Poll(Date endPoll) {
		this.endPoll = endPoll;
	}
	
//======================
//Getters
//======================
	public Date getEndPoll() {
		return endPoll;
	}

	public List<Answer> getAnswers() {
		return answers;
	}

	public List<OptionPoll> getOptions() {
		return options;
	}
	
//======================
//Setters
//======================
	public void setEndPoll(Date endPoll) {
		this.endPoll = endPoll;
	}

	public void setAnswers(List<Answer> answers) {
		this.answers = answers;
	}

	public void setOptions(List<OptionPoll> options) {
		this.options = options;
	}	
}
