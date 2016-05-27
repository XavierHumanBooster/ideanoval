package com.humanbooster.business.PK;

import java.io.Serializable;

import javax.persistence.IdClass;

import com.humanbooster.business.EvaluableIdea;
import com.humanbooster.business.User;

@IdClass(MarkPK.class)
public class MarkPK implements Serializable {

	private static final long serialVersionUID = 1L;

//======================
//Attributs
//======================	
	private EvaluableIdea evaluableIdea;
	private User user;
	
//======================
//Getters
//======================
	public EvaluableIdea getEvaluableIdea() {
		return evaluableIdea;
	}
	
	public User getUser() {
		return user;
	}
	
//======================
//Setters
//======================	
	public void setEvaluableIdea(EvaluableIdea evaluableIdea) {
		this.evaluableIdea = evaluableIdea;
	}
	
	public void setUser(User user) {
		this.user = user;
	}
	
//======================
//Overrride
//======================
	@Override
	public boolean equals(Object obj) {
		if(obj instanceof MarkPK) {
			MarkPK markPK = (MarkPK) obj;
			if (this.evaluableIdea.getIdIdea() == markPK.getEvaluableIdea().getIdIdea() && this.user.getIdUser() == user.getIdUser()) {
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
