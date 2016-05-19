package com.humanbooster.business;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class OptionPoll implements Serializable {

	private static final long serialVersionUID = 1L;

//======================
//Attributs
//======================
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idOptionPoll;
	
	@Column(nullable = false)
	private String valueOptionPoll;
	
	@ManyToMany(mappedBy = "options", fetch = FetchType.LAZY)
	private List<Poll> polls;
	
//======================
//Constructors
//======================
	public OptionPoll() {
	}
	
	public OptionPoll(String valueOption) {
		this.valueOptionPoll = valueOption;
	}

//======================
//Getters
//======================
	public int getIdOptionPoll() {
		return idOptionPoll;
	}

	public String getValueOptionPoll() {
		return valueOptionPoll;
	}

	public List<Poll> getPolls() {
		return polls;
	}

//======================
//Setters
//======================
	public void setIdOptionPoll(int idOptionPoll) {
		this.idOptionPoll = idOptionPoll;
	}

	public void setValueOptionPoll(String valueOptionPoll) {
		this.valueOptionPoll = valueOptionPoll;
	}

	public void setPolls(List<Poll> polls) {
		this.polls = polls;
	}
	
	
}
