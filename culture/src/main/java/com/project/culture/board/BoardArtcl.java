package com.project.culture.board;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "BOARD_ARTCLE")
public class BoardArtcl {

	/* 게시글 번호 */
	@Id
	@Column(name = "BOARD_SEQ", unique = true, nullable = false)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "IdGenerator")
	private int boardSeq;
	
	/* 게시판 설정 번호 */
	@Column(name = "CONFIG_SEQ", unique = true, nullable = false)
	private int configSeq;
	
	/* 제목 */
	@Column(name = "TITLE", unique = false, nullable = false)
	private String title;
	
	/* 내용 */
	@Column(name = "CONTENT", unique = false, nullable = false)
	private String content;
	
	/* 작성자 */
	@Column(name = "WRITER", unique = false, nullable = false)
	private String writer;
	
	/* 작성일자 */
	@Column(name = "REG_DATE", unique = false, nullable = false)
	private String regDate;
	
	/* 수정일자 */
	@Column(name = "EDIT_DATE", unique = false, nullable = false)
	private String editDate;
	
	/* 조회수 */
	@Column(name = "VIEW_CO", unique = false, nullable = false)
	private String viewCo;
	
	/* 작성자 ip */
	@Column(name = "IP", unique = false, nullable = false)
	private String ip;
	
	/* 썸네일 원본 이름 */
	@Column(name = "THUMB_ORIGIN_NM", unique = false, nullable = false)
	private String thumbOriginNm;
	
	/* 썸네일 변경 이름 */
	@Column(name = "THUMB_CHANGE_NM", unique = false, nullable = false)
	private String thumnChangeNm;
	
	/* 썸네일 경로 */
	@Column(name = "THUMB_PATH", unique = false, nullable = false)
	private String thumbPath;
	
	/* 휴지통 이동 여부 */
	@Column(name = "TRASH_YN", unique = false, nullable = false)
	private String trashYn;
	
	@Column(name = "ADD_ITEM01", unique = false, nullable = false)
	private String addItem01;
	
	@Column(name = "ADD_ITEM02", unique = false, nullable = false)
	private String addItem02;
	
	@Column(name = "ADD_ITEM03", unique = false, nullable = false)
	private String addItem03;
	
	@Column(name = "ADD_ITEM04", unique = false, nullable = false)
	private String addItem04;
	
	@Column(name = "ADD_ITEM05", unique = false, nullable = false)
	private String addItem05;

	public int getBoardSeq() {
		return boardSeq;
	}

	public void setBoardSeq(int boardSeq) {
		this.boardSeq = boardSeq;
	}

	public int getConfigSeq() {
		return configSeq;
	}

	public void setConfigSeq(int configSeq) {
		this.configSeq = configSeq;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getWriter() {
		return writer;
	}

	public void setWriter(String writer) {
		this.writer = writer;
	}

	public String getRegDate() {
		return regDate;
	}

	public void setRegDate(String regDate) {
		this.regDate = regDate;
	}

	public String getEditDate() {
		return editDate;
	}

	public void setEditDate(String editDate) {
		this.editDate = editDate;
	}

	public String getViewCo() {
		return viewCo;
	}

	public void setViewCo(String viewCo) {
		this.viewCo = viewCo;
	}

	public String getIp() {
		return ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}

	public String getThumbOriginNm() {
		return thumbOriginNm;
	}

	public void setThumbOriginNm(String thumbOriginNm) {
		this.thumbOriginNm = thumbOriginNm;
	}

	public String getThumnChangeNm() {
		return thumnChangeNm;
	}

	public void setThumnChangeNm(String thumnChangeNm) {
		this.thumnChangeNm = thumnChangeNm;
	}

	public String getThumbPath() {
		return thumbPath;
	}

	public void setThumbPath(String thumbPath) {
		this.thumbPath = thumbPath;
	}

	public String getTrashYn() {
		return trashYn;
	}

	public void setTrashYn(String trashYn) {
		this.trashYn = trashYn;
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

	public String getAddItem04() {
		return addItem04;
	}

	public void setAddItem04(String addItem04) {
		this.addItem04 = addItem04;
	}

	public String getAddItem05() {
		return addItem05;
	}

	public void setAddItem05(String addItem05) {
		this.addItem05 = addItem05;
	}

	@Override
	public String toString() {
		return "BoardArtcl [boardSeq=" + boardSeq + ", configSeq=" + configSeq + ", title=" + title + ", content="
				+ content + ", writer=" + writer + ", regDate=" + regDate + ", editDate=" + editDate + ", viewCo="
				+ viewCo + ", ip=" + ip + ", thumbOriginNm=" + thumbOriginNm + ", thumnChangeNm=" + thumnChangeNm
				+ ", thumbPath=" + thumbPath + ", trashYn=" + trashYn + ", addItem01=" + addItem01 + ", addItem02="
				+ addItem02 + ", addItem03=" + addItem03 + ", addItem04=" + addItem04 + ", addItem05=" + addItem05
				+ "]";
	}


	
	
}
