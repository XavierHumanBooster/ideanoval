package com.humanbooster.services;

import java.util.List;

import com.humanbooster.business.Category;

public interface CategoryService {
	
	public List<Category> getAllCategory();
	
	public boolean addCategory(Category category);

	public Category getCategorybyId(int idCategory);


}
