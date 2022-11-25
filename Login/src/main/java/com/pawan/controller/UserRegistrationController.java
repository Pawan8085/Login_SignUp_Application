package com.pawan.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.pawan.dto.UserDTO;
import com.pawan.dto.UserLoginDTO;
import com.pawan.model.User;
import com.pawan.service.UserService;

@Controller
@RequestMapping({"/", "/registration"})
public class UserRegistrationController {
	@Autowired
	private UserService userService;
	

	@ModelAttribute("user")
    public UserDTO userRegistrationDto() {
        return new UserDTO();
    }
	
	@GetMapping
	public String showRegistrationForm() {
		return "registration";
	}
	
	@PostMapping
	public String registerUserAccount(@ModelAttribute("user") UserDTO registrationDto) {
		User myuser = userService.save(registrationDto);
		
		if(myuser == null) {
			return "redirect:/registration?sameEmail";
		}
		return "redirect:/registration?success";
	}
	
	
	
}
