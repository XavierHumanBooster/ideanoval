package com.humanbooster.business;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.humanbooster.business.PK.MarkPK;

@Entity
@IdClass(MarkPK.class)
public class Mark implements Serializable {

	private static final long serialVersionUID = 1L;
	
//======================
//Attributs
//======================
	@Id
	@ManyToOne
	@JoinColumn(name = "idIdea")
	private EvaluableIdea evaluableIdea;
	
	@Id
	@ManyToOne
	@JoinColumn(name = "idUser")
	private User user;
	
	@Column(nullable = false)
	private int valueMark;
	

//======================
//Constructors
//======================
	public Mark() {
	}
	
	public Mark(EvaluableIdea evaluableIdea, User user, int valueMark) {
		this.evaluableIdea = evaluableIdea;
		this.user = user;
		this.valueMark = valueMark;
	}

//======================
//Getters
//======================
	public EvaluableIdea getEvaluableIdea() {
		return evaluableIdea;
	}

	public User getUser() {
		return user;
	}

	public int getValueMark() {
		return valueMark;
	}
	
//======================
//Setters
//======================
	public void setEvaluableIdea(EvaluableIdea evaluableIdea) {
		this.evaluableIdea = evaluableIdea;
	}

	public void setUserLambda(User user) {
		this.user = user;
	}
	
	public void setValueMark(int valueMark) {
		this.valueMark = valueMark;
	}
}
