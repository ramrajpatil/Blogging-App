package com.app.controllers;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.app.pojos.User;
import com.app.service.CategoryService;
import com.app.service.UserService;

@Controller
@RequestMapping("/user")
public class UserController {
	@Autowired
	UserService userService;
	@Autowired
	CategoryService catService;

	public UserController() {
		System.out.println("Inside " + getClass());
	}

	@PostMapping("/register")
	public String addUser(Model map, @RequestParam String firstName, @RequestParam String lastName,
			@RequestParam String email, @RequestParam String password, @RequestParam String phoneNo) {

		System.out.println("Inside addUser()");

		User user = new User(firstName, lastName, email, password, phoneNo);
		userService.addUser(user);
		map.addAttribute("message", "Thank Your For Registering With Us!, Please LogIn!");
		return "/login";
	}

	@GetMapping("/validate")
	public String validateUser(@RequestParam String email, @RequestParam String password, Model map,
			RedirectAttributes flash, HttpSession session) {
		System.out.println("Inside validateUser()");
		try {
			// Fetching all categories to show at successful log in itself
			User user = userService.getUser(email, password);
			session.setAttribute("user_details", user);
			session.setAttribute("cats", catService.fetchAllCategories());
			System.out.println("Categories added in Session Scope");
			flash.addFlashAttribute("msg", "LogIn Success");
			return "redirect:/blog/blogHome";
		} catch (RuntimeException e) {
			System.out.println("Error in validateUser()");
			map.addAttribute("err", "Invalid Login, Try again!!!");
			return "/login";
		}
	}

	@GetMapping("/logout")
	public String logoutUser(HttpSession session, HttpServletRequest req, HttpServletResponse res, Model map) {
		map.addAttribute("user", session.getAttribute("user_details"));
		session.invalidate();
		System.out.println("Session invalidated");
		res.setHeader("refresh", "5;url=" + req.getContextPath());
		return "/user/logout";
	}

}