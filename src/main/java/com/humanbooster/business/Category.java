package com.humanbooster.business;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;

@Entity
@NamedQuery(name="Category.findAll", query="SELECT category FROM Category category")
public class Category implements Serializable {

	private static final long serialVersionUID = 1L;

//======================
//Attributs
//======================
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idCategory;
	
	@Column(nullable = false, length = 250)
	private String labelCategory;
	
	@OneToMany(mappedBy = "category", fetch = FetchType.LAZY)
	private List<Idea> ideas;
	
//======================
//Constructors
//======================
	public Category() {		
	}
	
	public Category(String label) {
		this.labelCategory = label;
	}
	
//======================
//Getters
//======================
	public int getIdCategory() {
		return idCategory;
	}
	
	public String getLabelCategory() {
		return labelCategory;
	}
	
	public List<Idea> getIdeas() {
		return ideas;
	}

//======================
//Setters
//======================	
	public void setIdCategory(int idCategory) {
		this.idCategory = idCategory;
	}
	
	public void setLabelCategory(String labelCategory) {
		this.labelCategory = labelCategory;
	}
	
	public void setIdeas(List<Idea> ideas) {
		this.ideas = ideas;
	}
}
