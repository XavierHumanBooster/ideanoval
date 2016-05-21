package com.humanbooster.business;

import java.io.File;
import java.io.Serializable;
import java.time.Instant;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Transient;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public abstract class Idea implements Serializable {

	private static final long serialVersionUID = 1L;

//======================
//Attributs
//======================
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idIdea;
	
	@Column(nullable = false, unique = true)
	private String titleIdea;
	
	@Column(nullable = false)
	private String descriptionIdea;
	
	@Column(nullable = false)
	private String pictureIdea;
	
	@Transient
	File ImageUp;
	
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	private Date publishDateIdea;
	
	@Column(nullable = false)
	private boolean availableIdea;
	
	@ManyToOne
	@JoinColumn(name = "idCategory")
	private Category category;
	
	@ManyToOne
	@JoinColumn(name = "idUser")
	private UserLambda userLambda;

//======================
//Constructors
//======================
	public Idea() {
	}
	
	public Idea(String title, String description, Category category, UserLambda userLambda) {
		this.titleIdea = title;
		this.descriptionIdea = description;
		this.category = category;
		this.userLambda = userLambda;
		this.pictureIdea = "ImageByDefaut";
		this.publishDateIdea = Date.from(Instant.now());
		this.availableIdea = true;
	}
	
	public Idea(String title, String description, Category category, UserLambda userLambda, String pictureIdea) {
		this.titleIdea = title;
		this.descriptionIdea = description;
		this.category = category;
		this.userLambda = userLambda;
		this.pictureIdea = pictureIdea;
		this.publishDateIdea = Date.from(Instant.now());
		this.availableIdea = true;
	}

//======================
//Getters
//======================
	
	public int getIdIdea() {
		return idIdea;
	}

	public String getTitleIdea() {
		return titleIdea;
	}

	public String getDescriptionIdea() {
		return descriptionIdea;
	}

	public String getPictureIdea() {
		return pictureIdea;
	}
	
	public File getImageUp() {
		return ImageUp;
	}

	public Date getPublishDateIdea() {
		return publishDateIdea;
	}

	public boolean isAvailableIdea() {
		return availableIdea;
	}

	public Category getCategory() {
		return category;
	}

	public UserLambda getUserLambda() {
		return userLambda;
	}

//======================
//Setters
//======================
	public void setIdIdea(int idIdea) {
		this.idIdea = idIdea;
	}

	public void setTitleIdea(String titleIdea) {
		this.titleIdea = titleIdea;
	}

	public void setDescriptionIdea(String descriptionIdea) {
		this.descriptionIdea = descriptionIdea;
	}

	public void setPictureIdea(String pictureIdea) {
		this.pictureIdea = pictureIdea;
	}
	
	public void setImageUp(File imageUp) {
		ImageUp = imageUp;
	}

	public void setPublishDateIdea(Date publishDateIdea) {
		this.publishDateIdea = publishDateIdea;
	}

	public void setAvailableIdea(boolean availableIdea) {
		this.availableIdea = availableIdea;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public void setUserLambda(UserLambda userLambda) {
		this.userLambda = userLambda;
	}


	//======================
	//ToString
	//======================
		
	@Override
	public String toString() {
		return "Idea [idIdea=" + idIdea + ", titleIdea=" + titleIdea + ", descriptionIdea=" + descriptionIdea
				+ ", pictureIdea=" + pictureIdea + ", ImageUp=" + ImageUp + ", publishDateIdea=" + publishDateIdea
				+ ", availableIdea=" + availableIdea + ", category=" + category + ", userLambda=" + userLambda + "]";
	}
	
	
	
}
