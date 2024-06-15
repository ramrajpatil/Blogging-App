package com.app.controllers;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.app.pojos.Blog;
import com.app.pojos.Category;
import com.app.pojos.User;
import com.app.service.BlogService;
import com.app.service.CategoryService;
import com.app.service.UserService;

@Controller
@RequestMapping("/blog")
public class BlogController {

	@Autowired
	BlogService blogService;
	@Autowired
	UserService userService;
	@Autowired
	CategoryService catService;

	public BlogController() {
		System.out.println("Inside " + getClass());
	}

	// Add blog
	@GetMapping("/add")
	public String addBlog() {
		return "/blog/addBlog";
	}

	@GetMapping("/blogHome")
	public String blogs(Model map) {
		System.out.println("Inside blogs()");
		List<Blog> blogs = blogService.fetchAllBlogs();
		map.addAttribute("allBlogs", blogs);
		return "/blog/blogs";

	}

	@GetMapping("/insert")
	public String inserBlog(RedirectAttributes flash, @RequestParam String title, @RequestParam String contents,
			@RequestParam long category_id, @RequestParam long user_id) {
		User malak = userService.getUserById(user_id);
		Category category = catService.getCategoryById(category_id);
		Blog blog = new Blog(title, contents, LocalDate.now(), malak, category);
		blogService.insertBlog(blog);
		flash.addFlashAttribute("msg", "Blog added Successfully!!!");
		return "redirect:/blog/add";
	}

	@GetMapping("/update")
	public String updateBlog(@RequestParam long blogId, Model map) {
		Blog blog = blogService.getBlog(blogId);
		map.addAttribute("myBlog", blog);
		return "/blog/updateBlog";
	}

	@GetMapping("/saveUpdated")
	public String saveUpdatedBlog(@RequestParam long blogId, @RequestParam long category_id, @RequestParam long user_id,
			@RequestParam String title, @RequestParam String contents, RedirectAttributes flash, Model map) {
		User malak = userService.getUserById(user_id);
		Category category = catService.getCategoryById(category_id);
		Blog blog = new Blog(blogId, title, contents, LocalDate.now(), malak, category);
		blogService.insertBlog(blog);
		flash.addFlashAttribute("update_msg", "Blog updated Successfully!!!");
		flash.addFlashAttribute("blogId", blogId);
		return "redirect:/blog/blogHome";
	}

	@GetMapping("/delete")
	public String deleteBlog(@RequestParam long blogId, RedirectAttributes flash) {
		blogService.deleteBlog(blogId);
		flash.addFlashAttribute("deleteStatus", "Blog successfully removed!");
		return "redirect:/blog/blogHome";
	}
	
	@GetMapping("/search")
	public String findBlog() {
		return "/blog/findBlog";
	}
	
	@GetMapping("/searchBlog")
	public String searchBlog(@RequestParam String searchedText, Model map) {
		map.addAttribute("allBlogs", blogService.searchBlog(searchedText));
		return "/blog/findBlog";
	}
	
	
}