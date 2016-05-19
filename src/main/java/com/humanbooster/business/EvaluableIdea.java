package com.humanbooster.business;

import java.time.Instant;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
public class EvaluableIdea extends Idea {

	private static final long serialVersionUID = 1L;

//======================
//Attributs
//======================
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	private Date endEvaluableIdea;
	
	@OneToMany(mappedBy = "evaluableIdea", fetch = FetchType.LAZY)
	private List<Mark> marks;
	
	@OneToMany(mappedBy = "evaluableIdea", fetch = FetchType.LAZY)
	private List<Commentary> commentaries;
	
	@OneToMany(mappedBy = "evaluableIdea", fetch = FetchType.LAZY)
	private List<IdeaAlert> ideasAlert;
	
//======================
//Constructors
//======================
	public EvaluableIdea() {
		Calendar calendar = new GregorianCalendar();
		calendar.setTime(Date.from(Instant.now()));
		calendar.add(Calendar.DAY_OF_YEAR, 7);
		
		this.endEvaluableIdea = calendar.getTime();	
	}

//======================
//Getters
//======================
	public Date getEndEvaluableIdea() {
		return endEvaluableIdea;
	}

	public List<Mark> getMarks() {
		return marks;
	}

	public List<Commentary> getCommentaries() {
		return commentaries;
	}

	public List<IdeaAlert> getIdeasAlert() {
		return ideasAlert;
	}

//======================
//Setters
//======================
	public void setEndEvaluableIdea(Date endEvaluableIdea) {
		this.endEvaluableIdea = endEvaluableIdea;
	}

	public void setMarks(List<Mark> marks) {
		this.marks = marks;
	}

	public void setCommentaries(List<Commentary> commentaries) {
		this.commentaries = commentaries;
	}

	public void setIdeasAlert(List<IdeaAlert> ideasAlert) {
		this.ideasAlert = ideasAlert;
	}
	
	

	

}
