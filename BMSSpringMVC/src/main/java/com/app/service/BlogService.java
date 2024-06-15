package com.app.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.app.pojos.Blog;

@Service
public interface BlogService {
	Blog insertBlog(Blog blog);

	List<Blog> fetchAllBlogs();

	Blog getBlog(long blogId);
	
	void deleteBlog(long blogId);

	List<Blog> searchBlog(String searchedText);

}

