package com.project.culture.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/user")
public class UserInfoController {

	@Autowired
	private UserInfoServiceImpl userServiceImpl;
	
	@RequestMapping("/registView")
	public String registView() {
		return "/user/registView";
	}
	
	@RequestMapping("/registUser")
	public String registUser(UserInfo userInfo) {
		
		userServiceImpl.insertUser(userInfo);
		
		return "redirect:/";
	}
}
