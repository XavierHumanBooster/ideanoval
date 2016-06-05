package com.humanbooster.business;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;

@Entity
public class UserLambda extends User {
	
	private static final long serialVersionUID = 1L;

//======================
//Attributs
//======================
	private boolean approuvedUser;
	
	private boolean availableUser;
	
	private boolean deletedUser;
	
	@OneToMany(mappedBy = "userLambda", fetch = FetchType.LAZY)
	private List<CommentaryAlert> commentariesAlert;
	
	@OneToMany(mappedBy = "userLambda", fetch = FetchType.LAZY)
	private List<IdeaAlert> ideasAlert;
	
	@OneToMany(mappedBy = "userLambda", fetch = FetchType.LAZY)
	private List<Idea> ideas;
	
//======================
//Constructors
//======================
		
	public UserLambda() {
		this.approuvedUser = false;
		this.availableUser = true;
		this.deletedUser = false;
	}
	
	
//======================
//Getters
//======================
	public boolean isApprouvedUser() {
		return approuvedUser;
	}

	public boolean isAvailableUser() {
		return availableUser;
	}

	public boolean isDeletedUser() {
		return deletedUser;
	}
	
	public List<CommentaryAlert> getCommentariesAlert() {
		return commentariesAlert;
	}

	public List<IdeaAlert> getIdeasAlert() {
		return ideasAlert;
	}

	public List<Idea> getIdeas() {
		return ideas;
	}

//======================
//Setters
//======================
	public void setApprouvedUser(boolean approuvedUser) {
		this.approuvedUser = approuvedUser;
	}

	public void setAvailableUser(boolean availableUser) {
		this.availableUser = availableUser;
	}

	public void setDeletedUser(boolean deletedUser) {
		this.deletedUser = deletedUser;
	}

	public void setCommentariesAlert(List<CommentaryAlert> commentariesAlert) {
		this.commentariesAlert = commentariesAlert;
	}

	public void setIdeasAlert(List<IdeaAlert> ideasAlert) {
		this.ideasAlert = ideasAlert;
	}

	public void setIdeas(List<Idea> ideas) {
		this.ideas = ideas;
	}
	
}
