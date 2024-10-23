package com.project.culture.user;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.culture.util.Decrypt;
import com.project.culture.util.Encrypt;
import com.project.culture.util.WebUtil;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

@Service
public class UserInfoServiceImpl implements UserInfoService {

	@Autowired
	private UserInfoService userInfoService;
	
	@Autowired
	private HttpServletRequest request;
	
	@Autowired
	private Encrypt encrypt;
	
	@Autowired
	private Decrypt decrypt;
	
	@Autowired
	private WebUtil webUtil;
	
	/**
	 * 회원가입
	 */
	@Override
	public void insertUser(UserInfo userInfo) {
		
		try {
			if ("site".equals(userInfo.getLoginType())) {
				String userId = userInfo.getUserId().replaceAll(",", "").replaceAll(" ", "");
				String encPw = encrypt.encrypt(userInfo.getUserPw());
				String tel = userInfo.getTel().replaceAll(",", "-");
				
				userInfo.setUserId(userId);
				userInfo.setUserPw(encPw);
				userInfo.setTel(tel);
			} else {
				userInfo.setUserPw("");
			}
			
			userInfoService.insertUser(userInfo);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	
	/**
	 * 사이트에서 회원가입 시 아이디 중복검사
	 */
	@Override
	public int duplicationUserId(String userId) {
		return userInfoService.duplicationUserId(userId);
	}


	/*
	 * 사이트에서 로그인 시 아이디와 비밀번호 체크
	 */
	@Override
	public UserInfo loginUserInfo(String userId, String userPw) {
		
		try {
			String encryptPw = encrypt.encrypt(userPw);
			UserInfo userInfo = userInfoService.loginUserInfo(userId, encryptPw);
			
			if (userInfo != null) {
				// 현재 날짜 구하기        
				Date now = new Date();
				// 로그인 시 마지막 로그인 날짜 갱신
				lastLoginUpdate(now, userId);
				HttpSession session = request.getSession();
				session.setAttribute("userInfo", userInfo);
			}
			
			return userInfo;
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return null;
	}


	@Override
	public void lastLoginUpdate(Date lastLogin, String userId) {
		userInfoService.lastLoginUpdate(lastLogin, userId);
	}


}
