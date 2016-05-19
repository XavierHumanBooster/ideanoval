package com.humanbooster.business;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;

@Entity
@NamedQuery(name="Commentary.findAll", query="SELECT commentary FROM Commentary commentary")
public class Commentary implements Serializable {

	private static final long serialVersionUID = 1L;

//======================
//Attributs
//======================
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idCommentary;
	
	@Column(nullable = false)
	private String valueCommentary;
		
	@ManyToOne
	@JoinColumn(name = "idUser")
	private User user;
	
	@ManyToOne
	@JoinColumn(name = "idIdea")
	private EvaluableIdea evaluableIdea;
	
	@OneToMany(mappedBy = "commentary", fetch = FetchType.LAZY)
	private List<CommentaryAlert> commentariesAlert;
	
//======================
//Constructors
//======================
	public Commentary() {
	}
	
	public Commentary(String value, User user, EvaluableIdea evaluableIdea) {
		this.valueCommentary = value;
		this.user = user;
		this.evaluableIdea = evaluableIdea;
	}
	
//======================
//Getters
//======================
	public int getIdCommentary() {
		return idCommentary;
	}

	public String getValueCommentary() {
		return valueCommentary;
	}

	public User getUser() {
		return user;
	}

	public EvaluableIdea getEvaluableIdea() {
		return evaluableIdea;
	}
	
	public List<CommentaryAlert> getCommentariesAlert() {
		return commentariesAlert;
	}

//======================
//Setters
//======================	
	public void setIdCommentary(int idCommentary) {
		this.idCommentary = idCommentary;
	}
	
	public void setValueCommentary(String valueCommentary) {
		this.valueCommentary = valueCommentary;
	}
	
	public void setUser(User user) {
		this.user = user;
	}
	
	public void setEvaluableIdea(EvaluableIdea evaluableIdea) {
		this.evaluableIdea = evaluableIdea;
	}
	
	public void setCommentariesAlert(List<CommentaryAlert> commentariesAlert) {
		this.commentariesAlert = commentariesAlert;
	}
}
