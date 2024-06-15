package com.app.service;

import java.util.List;

import com.app.pojos.Category;

public interface CategoryService {
	String saveCategory(Category category);

	List<Category> fetchAllCategories();

	Category getCategoryById(long id);
}
