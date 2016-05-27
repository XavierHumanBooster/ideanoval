package com.humanbooster.business.PK;

import java.io.Serializable;

import com.humanbooster.business.Poll;
import com.humanbooster.business.User;

public class AnswerPK implements Serializable {

	private static final long serialVersionUID = 1L;

//======================
//Attributs
//======================	
	private Poll poll;
	private User user;
	
//======================
//Getters
//======================
	public Poll getPoll() {
		return poll;
	}
	
	public User getUser() {
		return user;
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
	
//======================
//Overrride
//======================
	@Override
	public boolean equals(Object obj) {
		if(obj instanceof AnswerPK) {
			AnswerPK answerPK = (AnswerPK) obj;
			if (this.poll.getIdIdea() == answerPK.getPoll().getIdIdea() && this.user.getIdUser() == user.getIdUser()) {
				return true;	
			} else {
				return false;
			}
		} else {
			return false;
		}
	}
	
	@Override
	public int hashCode() {
		return super.hashCode();
	}
}
