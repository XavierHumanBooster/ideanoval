package com.humanbooster.business;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.humanbooster.business.PK.AnswerPK;

@Entity
@IdClass(AnswerPK.class)
public class Answer implements Serializable {

	private static final long serialVersionUID = 1L;

//======================
//Attributs
//======================
	@Id
	@ManyToOne
	@JoinColumn(name = "idIdea")
	private Poll poll;
	
	@Id
	@ManyToOne
	@JoinColumn(name = "idUser")
	private User user;
	
	@Column(nullable = true)
	private String valueAnswer;
	
	@Column(nullable = true)
	private String otherAnswer;
	
//======================
//Constructors
//======================
	public Answer() {
	}
	
	public Answer(Poll poll, User user, String valueAnswer) {
		this.poll = poll;
		this.user = user;
		this.valueAnswer = valueAnswer;
	}
	
	public Answer(Poll poll, User user, String valueAnswer, String otherAnswer) {
		this.poll = poll;
		this.user = user;
		this.valueAnswer = valueAnswer;
		this.otherAnswer = otherAnswer;
	}

//======================
//Getters
//======================
	public Poll getPoll() {
		return poll;
	}

	public User getUser() {
		return user;
	}

	public String getValueAnswer() {
		return valueAnswer;
	}

	public String getOtherAnswer() {
		return otherAnswer;
	}

//======================
//Setters
//======================
	public void setPoll(Poll poll) {
		this.poll = poll;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public void setValueAnswer(String valueAnswer) {
		this.valueAnswer = valueAnswer;
	}

	public void setOtherAnswer(String otherAnswer) {
		this.otherAnswer = otherAnswer;
	}
	
}
