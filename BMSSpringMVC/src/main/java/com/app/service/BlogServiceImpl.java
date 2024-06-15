package com.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.custom_exception.CustomNoResultException;
import com.app.pojos.Blog;
import com.app.repository.BlogRepo;

@Service
public class BlogServiceImpl implements BlogService {
	@Autowired
	BlogRepo blogRepo;

	@Override
	public Blog insertBlog(Blog blog) {
		return blogRepo.save(blog);
	}

	@Override
	public List<Blog> fetchAllBlogs() {
		return blogRepo.findAll();
	}

	@Override
	public Blog getBlog(long blogId) {
		return blogRepo.findById(blogId).orElseThrow(() -> new CustomNoResultException("No blog with id= " + blogId));
	}

	@Override
	public void deleteBlog(long blogId) {
		blogRepo.deleteById(blogId);
	}

	@Override
	public List<Blog> searchBlog(String searchedText) {
		return blogRepo.findByContentsContaining(searchedText);
	}
}
