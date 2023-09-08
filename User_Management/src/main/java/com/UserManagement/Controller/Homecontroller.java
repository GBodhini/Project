package com.UserManagement.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.UserManagement.Model.UserDtls;
import com.UserManagement.Service.UserService;

import jakarta.servlet.http.HttpSession;

@Controller
public class Homecontroller {
	
	@Autowired
	private UserService userService;
	
	@GetMapping("/")
	public String index() {
		return "index";
	}

	@GetMapping("/signin")
	public String login() {
		return "login";
	}

	@GetMapping("/register")
	public String register() {
		return "register";
	}
	
	@PostMapping("/createUser")
	public String createuser(@ModelAttribute UserDtls user,HttpSession session)
	{
		boolean f=userService.checkEmail(user.getEmail());
		
		if(f)
		{
			session.setAttribute("msg","Email id already Exists");
		
		}
		else
		{
			UserDtls userDtls=userService.createUser(user);
			if(userDtls!=null)
			{
				session.setAttribute("msg","Register Successfully");
				
			}
			else
			{
				session.setAttribute("msg","Something went Wrong");
			}
		}
		
		return "register";
	}

}
