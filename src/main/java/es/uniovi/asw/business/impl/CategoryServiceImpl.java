package es.uniovi.asw.business.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import es.uniovi.asw.business.CategoryService;
import es.uniovi.asw.infraestructure.Factories;
import es.uniovi.asw.persistence.model.Category;
import es.uniovi.asw.persistence.model.Comment;

@Service
public class CategoryServiceImpl implements CategoryService{
	
	@Autowired
	private Factories factories;

	@Override
	public void save(Category category) {
		factories.getPersistenceFactory().getCategoryRepository().save(category);
	}

	@Override
	public void delete(Category category) {
		
		
	}

	@Override
	public List<Category> findAll() {
		return factories.getPersistenceFactory().getCategoryRepository().findAll();
	}

}
