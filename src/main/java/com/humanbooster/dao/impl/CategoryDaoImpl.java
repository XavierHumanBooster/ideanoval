package com.humanbooster.dao.impl;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.humanbooster.dao.CategoryDao;
import com.humanbooster.business.Category;

@SuppressWarnings("unchecked")
@Repository
public class CategoryDaoImpl implements CategoryDao {
	
	@Autowired
	private SessionFactory sessionFactory;

	public CategoryDaoImpl() {
		// TODO Auto-generated constructor stub
	}
	
	public CategoryDaoImpl(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	@Override
	@Transactional(readOnly=true)
	public List<Category> getAllCategory(){
	
		try {
			Query query = sessionFactory.getCurrentSession().createQuery("SELECT c FROM Category c");
			return query.list();

		} catch (HibernateException ex) {
			ex.printStackTrace();
			return null;
		}
		
	}

	@Override
	public boolean addCategory(Category category) {
		try{
			this.sessionFactory.getCurrentSession().save(category);
			return true;
		}catch(Exception e){
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public Category findCategoryById(int idCategory) {
		String queryString = "FROM Category c WHERE c.idCategory = :idCategory";
		Query query = this.sessionFactory.getCurrentSession().createQuery(queryString);
		query.setInteger("idCategory", idCategory);
		return (Category)query.uniqueResult();
	}

	@Override
	public Category findCategoryByLabel(String labelCategory) {
		String queryString = "FROM Category c WHERE c.labelCategory = :labelCategory";
		Query query = this.sessionFactory.getCurrentSession().createQuery(queryString);
		query.setString("labelCategory", labelCategory);
		return (Category)query.uniqueResult();
	}

	@Override
	public boolean updateCategory(Category category) {
		try{
			this.sessionFactory.getCurrentSession().update(category);
			return true;
		}catch(Exception e){
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean deleteCategory(Category category) {
		try{
			this.sessionFactory.getCurrentSession().delete(category);
			return true;
		}catch(Exception e){
			e.printStackTrace();
			return false;
		}
	}

}
