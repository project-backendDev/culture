package com.project.culture.user;

import java.util.Date;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserInfoService {
	
	/*
	 * 회원가입
	 */
	public void insertUser(UserInfo userInfo);
	
	/*
	 * 사이트에서 회원가입 시 아이디 중복검사
	 */
	public int duplicationUserId(String userId);
	
	/*
	 * 사이트에서 로그인 시 아이디와 비밀번호 체크
	 */
	public UserInfo loginUserInfo(String userId, String userPw);
	
	/*
	 * 로그인 시 마지막 로그인 날짜 업데이트
	 */
	public void lastLoginUpdate(Date lastLogin, String userId);
	
}
