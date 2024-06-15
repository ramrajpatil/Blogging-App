package com.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.custom_exception.CustomNoResultException;
import com.app.pojos.Category;
import com.app.repository.CategoryRepos;

@Service
public class CategoryServiceImpl implements CategoryService {

	@Autowired
	CategoryRepos catRepo;

	@Override
	public String saveCategory(Category category) {
		catRepo.save(category);
		return "Category Saved Successfully!!!";
	}

	@Override
	public List<Category> fetchAllCategories() {
		return catRepo.findAll();
	}

	@Override
	public Category getCategoryById(long id) {
		return catRepo.findById(id).orElseThrow(() -> new CustomNoResultException("No Such Category with given id"));
	}

}
