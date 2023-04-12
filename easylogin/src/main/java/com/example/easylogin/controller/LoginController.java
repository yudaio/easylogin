package com.example.easylogin.controller;

import java.util.List;
import com.example.easylogin.model.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.easylogin.model.dao.UserRepository;

@Controller
public class LoginController {

	@Autowired
	UserRepository UserRepos;
	
	@RequestMapping("/")
	public String login(
	@RequestParam("userName") String userName,
	@RequestParam("password") String password,
	Model m){
		String message= "Welcome!";
		
		List<User> users = UserRepos.findByUserNameAndPassword(userName, password);
			if(users.size()>0){
				User user = users.get(0);
				message += user.getFullName();
			} else {
				message += "guest";
			}
			
			m.addAttribute("message", message);
			return "login";
			}
}
