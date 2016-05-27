package com.humanbooster.services.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.humanbooster.business.Category;
import com.humanbooster.dao.CategoryDao;
import com.humanbooster.services.CategoryService;

@Service
public class CategoryServiceImpl implements CategoryService {

	@Autowired
	private CategoryDao categoryDao;
	
	@Override
	public List<Category> getAllCategory(){
		
		List<Category> categories = new ArrayList<Category>();
		categories = categoryDao.getAllCategory();
		return categories;
		
	}

	@Override
	public boolean addCategory(Category category) {
		
		return categoryDao.addCategory(category);
	}

	@Override
	public Category getCategorybyId(int idCategory) {
		return categoryDao.findCategoryById(idCategory);

	}
	
}
