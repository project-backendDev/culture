package com.project.culture.user;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "USER_INFO")
public class UserInfo {

	@Id
	@Column(name = "USER_SEQ", unique = true, nullable = false)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "IdGenerator")
	private int userSeq;
	
	/** 아이디 (이메일) */
	@Column(name = "USER_ID", unique = false, nullable = false)
	private String userId;
	
	/** 비밀번호 */
	@Column(name = "USER_PW", unique = false, nullable = false)
	private String userPw;
	
	/** 이름 */
	@Column(name = "NAME", unique = false, nullable = false)
	private String name;
	
	/** 전화번호 */
	@Column(name = "TEL", unique = false, nullable = false)
	private String tel;
	
	/** 생일 */
	@Column(name = "BIRTHDAY", unique = false, nullable = false)
	private String birthday;
	
	/** 성별 */
	@Column(name = "GENDER", unique = false, nullable = false)
	private String gender;
	
	/** 우편번호 */
	@Column(name = "POSTCODE", unique = false, nullable = false)
	private String postcode;
	
	/** 주소 */
	@Column(name = "ADDR1", unique = false, nullable = false)
	private String addr1;
	
	/** 상세주소 */
	@Column(name = "ADDR2", unique = false, nullable = false)
	private String addr2;
	
	/** 가입일자 */
	@Column(name = "REG_DATE", unique = false, nullable = false)
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date regDate;
	
	/** 수정일자 */
	@Column(name = "EDIT_DATE", unique = false, nullable = false)
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date editDate;
	
	/** 최근 로그인 일자 */
	@Column(name = "LAST_LOGIN", unique = false, nullable = false)
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date lastLogin;

	/** 구분 (사용자 / 관리자) */
	@Column(name = "USER_TYPE", unique = false, nullable = false)
	private String userType;
	
	/** 로그인 구분 (site / SNS 로그인) */
	@Column(name = "LOGIN_TYPE", unique = false, nullable = false)
	private String loginType;
	
	@Column(name = "ADD_ITEM01", unique = false, nullable = false)
	private String addItem01;
	
	@Column(name = "ADD_ITEM02", unique = false, nullable = false)
	private String addItem02;
	
	@Column(name = "ADD_ITEM03", unique = false, nullable = false)
	private String addItem03;
	
	private String chkArr;

	public int getUserSeq() {
		return userSeq;
	}

	public void setUserSeq(int userSeq) {
		this.userSeq = userSeq;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getUserPw() {
		return userPw;
	}

	public void setUserPw(String userPw) {
		this.userPw = userPw;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public String getBirthday() {
		return birthday;
	}

	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getPostcode() {
		return postcode;
	}

	public void setPostcode(String postcode) {
		this.postcode = postcode;
	}

	public String getAddr1() {
		return addr1;
	}

	public void setAddr1(String addr1) {
		this.addr1 = addr1;
	}

	public String getAddr2() {
		return addr2;
	}

	public void setAddr2(String addr2) {
		this.addr2 = addr2;
	}

	public Date getRegDate() {
		return regDate;
	}

	public void setRegDate(Date regDate) {
		this.regDate = regDate;
	}

	public Date getEditDate() {
		return editDate;
	}

	public void setEditDate(Date editDate) {
		this.editDate = editDate;
	}

	public Date getLastLogin() {
		return lastLogin;
	}

	public void setLastLogin(Date lastLogin) {
		this.lastLogin = lastLogin;
	}

	public String getUserType() {
		return userType;
	}

	public void setUserType(String userType) {
		this.userType = userType;
	}

	public String getLoginType() {
		return loginType;
	}

	public void setLoginType(String loginType) {
		this.loginType = loginType;
	}

	public String getAddItem01() {
		return addItem01;
	}

	public void setAddItem01(String addItem01) {
		this.addItem01 = addItem01;
	}

	public String getAddItem02() {
		return addItem02;
	}

	public void setAddItem02(String addItem02) {
		this.addItem02 = addItem02;
	}

	public String getAddItem03() {
		return addItem03;
	}

	public void setAddItem03(String addItem03) {
		this.addItem03 = addItem03;
	}

	public String getChkArr() {
		return chkArr;
	}

	public void setChkArr(String chkArr) {
		this.chkArr = chkArr;
	}

	@Override
	public String toString() {
		return "UserInfo [userSeq=" + userSeq + ", userId=" + userId + ", userPw=" + userPw + ", name=" + name
				+ ", tel=" + tel + ", birthday=" + birthday + ", gender=" + gender + ", postcode=" + postcode
				+ ", addr1=" + addr1 + ", addr2=" + addr2 + ", regDate=" + regDate + ", editDate=" + editDate
				+ ", lastLogin=" + lastLogin + ", userType=" + userType + ", loginType=" + loginType + ", addItem01="
				+ addItem01 + ", addItem02=" + addItem02 + ", addItem03=" + addItem03 + ", chkArr=" + chkArr + "]";
	}


	
}
