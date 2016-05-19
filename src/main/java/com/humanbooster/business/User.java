package com.humanbooster.business;

import java.io.Serializable;
import java.time.Instant;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.OneToMany;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public abstract class User implements Serializable{

	private static final long serialVersionUID = 1L;

//======================
//Attributs
//======================
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idUser;
	
	@Column(nullable = false, length = 25, unique = true)
	private String loginUser;
	
	@Column(nullable = false, length = 25, unique = true)
	private String pseudoUser;
	
	@Column(nullable = false, length = 255)
	private String passwordUser;
	
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	private Date registerDateUser;
	
	@OneToMany(mappedBy = "user", fetch = FetchType.LAZY)
	private List<Commentary> commentaries;
	
	@OneToMany(mappedBy = "user", fetch = FetchType.LAZY)
	private List<Mark> marks;
	
	@OneToMany(mappedBy = "user", fetch = FetchType.LAZY)
	private List<Answer> answers;
	
//======================
//Constructors
//======================
	public User() {

	}
	
	public User(String login, String password) {
		this.loginUser = login;
		this.passwordUser = password;
	}
	
	
	public User(String login, String pseudo, String password) {
		this.loginUser = login;
		this.pseudoUser = pseudo;
		this.passwordUser = password;
		this.registerDateUser = Date.from(Instant.now());
	}
	
//======================
//Getters
//======================
	public int getIdUser() {
		return idUser;
	}

	public String getLoginUser() {
		return loginUser;
	}

	public String getPseudoUser() {
		return pseudoUser;
	}

	public String getPasswordUser() {
		return passwordUser;
	}

	public Date getRegisterDateUser() {
		return registerDateUser;
	}
	
	public List<Commentary> getCommentaries() {
		return commentaries;
	}

	public List<Mark> getMarks() {
		return marks;
	}

	public List<Answer> getAnswers() {
		return answers;
	}

//======================
//Setters
//======================
	public void setIdUser(int idUser) {
		this.idUser = idUser;
	}

	public void setLoginUser(String loginUser) {
		this.loginUser = loginUser;
	}

	public void setPseudoUser(String pseudoUser) {
		this.pseudoUser = pseudoUser;
	}

	public void setPasswordUser(String passwordUser) {
		this.passwordUser = passwordUser;
	}

	public void setRegisterDateUser(Date registerDateUser) {
		this.registerDateUser = registerDateUser;
	}

	public void setCommentaries(List<Commentary> commentaries) {
		this.commentaries = commentaries;
	}

	public void setMarks(List<Mark> marks) {
		this.marks = marks;
	}

	public void setAnswers(List<Answer> answers) {
		this.answers = answers;
	}
	
}
