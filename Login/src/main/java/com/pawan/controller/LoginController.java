package com.pawan.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.pawan.dto.UserLoginDTO;
import com.pawan.model.User;
import com.pawan.service.UserService;



@Controller
public class LoginController {
	@Autowired
	private UserService userService;
	@GetMapping("/login")
	public String login(@ModelAttribute("userlogindto") UserLoginDTO uld) {
		return "login";
	}
	
	@PostMapping("/savedata")
	public String saveData(UserLoginDTO uld, RedirectAttributes rd) {
		
//		System.out.println(uld);
		User myuser=  userService.UserLoggin(uld);
		if(myuser == null) {
			rd.addFlashAttribute("errorMessage","Invalid UserName or Password");
		    return "redirect:/login";
		}
		rd.addFlashAttribute("saveddata", uld);
		return "redirect:/loggedin";
	}
	
	@GetMapping("/loggedin")
	public String showDetails() {
		return "index";
	}
	
}
