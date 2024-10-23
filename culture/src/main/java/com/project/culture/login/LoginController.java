package com.project.culture.login;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.project.culture.user.UserInfo;
import com.project.culture.user.UserInfoServiceImpl;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("/login")
public class LoginController {
	
	@Autowired
	private UserInfoServiceImpl userInfoServiceImpl;

	@RequestMapping("/loginView")
	public String loginView() {
		System.out.println("로그인 페이지");
		return "/login/loginView";
	}
	
	@RequestMapping("/userLogin.do")
	public String userLogin(ModelMap model, HttpServletRequest request, 
							@RequestParam(value = "userId") String userId, 
							@RequestParam(value = "userPw") String userPw) {
		
		UserInfo userInfo = userInfoServiceImpl.loginUserInfo(userId, userPw);
		
		return "redirect:/";
	}
	
	@RequestMapping("/userLogout.do")
	public String userLogout(HttpServletRequest request) {
		
		HttpSession session = request.getSession(false);
		session.invalidate();
		
		return "redirect:/";
	}
	
	
}
