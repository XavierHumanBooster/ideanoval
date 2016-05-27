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

import com.humanbooster.business.PK.CommentaryAlertPK;

@Entity
@IdClass(CommentaryAlertPK.class)
public class CommentaryAlert implements Serializable{

	private static final long serialVersionUID = 1L;
	
//======================
//Attributs
//======================
	@Id
	@ManyToOne
	@JoinColumn(name = "idCommentary")
	private Commentary commentary;
	
	@Id
	@ManyToOne
	@JoinColumn(name = "idUser")
	private UserLambda userLambda;
	
	@Column(nullable = false)
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	private Date dateCommentaryAlert;
	
//======================
//Constructors
//======================
	public CommentaryAlert() {
	}
	
	public CommentaryAlert(Commentary commentary, UserLambda userLambda) {
		this.commentary = commentary;
		this.userLambda = userLambda;
		this.dateCommentaryAlert = Date.from(Instant.now());
	}

//======================
//Getters
//======================
	public Commentary getCommentary() {
		return commentary;
	}

	public UserLambda getUserLambda() {
		return userLambda;
	}

	public Date getDateCommentaryAlert() {
		return dateCommentaryAlert;
	}

//======================
//Setters
//======================
	public void setCommentary(Commentary commentary) {
		this.commentary = commentary;
	}

	public void setUserLambda(UserLambda userLambda) {
		this.userLambda = userLambda;
	}

	public void setDateCommentaryAlert(Date dateCommentaryAlert) {
		this.dateCommentaryAlert = dateCommentaryAlert;
	}
	
	
}
