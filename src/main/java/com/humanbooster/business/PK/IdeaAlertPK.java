package com.humanbooster.business.PK;

import java.io.Serializable;

import javax.persistence.IdClass;

import com.humanbooster.business.EvaluableIdea;
import com.humanbooster.business.UserLambda;

@IdClass(IdeaAlertPK.class)
public class IdeaAlertPK implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
//======================
//Attributs
//======================	
	private EvaluableIdea evaluableIdea;
	private UserLambda userLambda;
	
//======================
//Getters
//======================
	public EvaluableIdea getEvaluableIdea() {
		return evaluableIdea;
	}
	
	public UserLambda getUserLambda() {
		return userLambda;
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
	
//======================
//Overrride
//======================
	@Override
	public boolean equals(Object obj) {
		if(obj instanceof IdeaAlertPK) {
			IdeaAlertPK ideaAlertPK = (IdeaAlertPK) obj;
			if (this.evaluableIdea.getIdIdea() == ideaAlertPK.getEvaluableIdea().getIdIdea() && this.userLambda.getIdUser() == userLambda.getIdUser()) {
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
