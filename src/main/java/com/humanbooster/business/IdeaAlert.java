package com.humanbooster.business;

import java.io.Serializable;
import java.time.Instant;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.springframework.format.annotation.DateTimeFormat;

import com.humanbooster.business.PK.IdeaAlertPK;

@Entity
@IdClass(IdeaAlertPK.class)
public class IdeaAlert implements Serializable {

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
	private UserLambda userLambda;
	
	@Column(nullable = false)
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	private Date dateIdeaAlert;

//======================
//Constructors
//======================
	public IdeaAlert() {
	}
	
	public IdeaAlert(EvaluableIdea evaluableIdea, UserLambda userLambda) {
		this.evaluableIdea = evaluableIdea;
		this.userLambda = userLambda;
		this.dateIdeaAlert = Date.from(Instant.now());
	}

//======================
//Getters
//======================
	public EvaluableIdea getEvaluableIdea() {
		return evaluableIdea;
	}

	public UserLambda getUserLambda() {
		return userLambda;
	}

	public Date getDateIdeaAlert() {
		return dateIdeaAlert;
	}

//======================
//Setters
//======================
	public void setEvaluableIdea(EvaluableIdea evaluableIdea) {
		this.evaluableIdea = evaluableIdea;
	}

	public void setUserLambda(UserLambda userLambda) {
		this.userLambda = userLambda;
	}

	public void setDateIdeaAlert(Date dateIdeaAlert) {
		this.dateIdeaAlert = dateIdeaAlert;
	}
	
	
}
