package com.app.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.pojos.Category;

public interface CategoryRepos extends JpaRepository<Category, Long> {
	Category save(Category category);

	List<Category> findAll();

	Optional<Category> findById(Long id);
}
