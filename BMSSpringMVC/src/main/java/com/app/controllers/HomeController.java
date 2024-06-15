package com.app.controllers;

import java.time.LocalDateTime;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
	public HomeController() {
		System.out.println("Inside " + getClass());
	}

	@GetMapping("/")
	public String loadHomePage(Model map) {
		map.addAttribute("stamp", LocalDateTime.now());
		return "/login";
	}

	@GetMapping("/signup")
	public String loadRegisterPage() {
		System.out.println("Inside loadRegisterPage()");
		return "/user/register";
	}
}