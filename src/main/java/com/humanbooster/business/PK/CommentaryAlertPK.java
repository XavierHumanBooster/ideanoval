package com.humanbooster.business.PK;

import java.io.Serializable;

import javax.persistence.IdClass;

import com.humanbooster.business.Commentary;
import com.humanbooster.business.UserLambda;

@IdClass(CommentaryAlertPK.class)
public class CommentaryAlertPK implements Serializable{

	private static final long serialVersionUID = 1L;

//======================
//Attributs
//======================	
	private Commentary commentary;
	private UserLambda userLambda;
	
//======================
//Getters
//======================
	public Commentary getCommentary() {
		return commentary;
	}
	
	public UserLambda getUserLambda() {
		return userLambda;
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
	
//======================
//Overrride
//======================
	@Override
	public boolean equals(Object obj) {
		if(obj instanceof CommentaryAlertPK) {
			CommentaryAlertPK commentaryAlertPK = (CommentaryAlertPK) obj;
			if (this.commentary.getIdCommentary() == commentaryAlertPK.getCommentary().getIdCommentary() && this.userLambda.getIdUser() == userLambda.getIdUser()) {
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

