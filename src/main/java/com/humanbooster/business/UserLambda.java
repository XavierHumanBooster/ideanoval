package com.humanbooster.business;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;

@Entity
public class UserLambda extends User {
	
	private static final long serialVersionUID = 1L;

//======================
//Attributs
//======================
	@Column(nullable = false)
	private boolean ApprouvedUser;
	
	@Column(nullable = false)
	private boolean AvailableUser;
	
	@Column(nullable = false)
	private boolean DeletedUser;
	
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
		this.ApprouvedUser = false;
		this.AvailableUser = true;
		this.DeletedUser = false;
	}
	
	
//======================
//Getters
//======================
	public boolean isApprouvedUser() {
		return ApprouvedUser;
	}

	public boolean isAvailableUser() {
		return AvailableUser;
	}

	public boolean isDeletedUser() {
		return DeletedUser;
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
		ApprouvedUser = approuvedUser;
	}

	public void setAvailableUser(boolean availableUser) {
		AvailableUser = availableUser;
	}

	public void setDeletedUser(boolean deletedUser) {
		DeletedUser = deletedUser;
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
