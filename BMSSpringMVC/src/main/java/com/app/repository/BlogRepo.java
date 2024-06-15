package com.app.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.app.pojos.Blog;

@Repository
public interface BlogRepo extends JpaRepository<Blog, Long> {

	Blog save(Blog blog);

	List<Blog> findAll();

	Optional<Blog> findById(Long id);

	void deleteById(Long id);

	List<Blog> findByContentsContaining(String searchedText);
}
