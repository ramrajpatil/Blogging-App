package com.app.controllers;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.app.pojos.Category;
import com.app.service.CategoryService;

@Controller
@RequestMapping("/cat")
public class CategoryController {

	@Autowired
	CategoryService catService;

	@GetMapping("/add")
	public String addCategory() {
		return "/cat/addCat";
	}

	@GetMapping("/insert")
	public String insertCategory(HttpSession session, RedirectAttributes flash, @RequestParam String title,
			@RequestParam String description) {
		Category cat = new Category(title, description);
		String insertionStatus = catService.saveCategory(cat);
		// Fetching all categories to show at successful log in itself
		session.setAttribute("cats", catService.fetchAllCategories());
		flash.addFlashAttribute("insertionStatus", insertionStatus);
		return "redirect:/cat/add";
	}

	@GetMapping("/allCats")
	public String allCategories() {
		return "/cat/allCats";
	}

}
