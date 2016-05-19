package com.humanbooster.dao;

import java.util.List;

import com.humanbooster.business.Category;

public interface CategoryDao {
	public boolean addCategory(Category category);
	public Category findCategoryById(int idCategory);
	public Category findCategoryByLabel(String labelCategory);
	public boolean updateCategory(Category category);
	public boolean deleteCategory(Category category);
	public List<Category> getAllCategory();

}
