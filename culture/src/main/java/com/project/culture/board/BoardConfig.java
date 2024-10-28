package com.project.culture.board;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "BOARD_CONFIG")
public class BoardConfig {

	/* 게시판 설정 번호*/
	@Id
	@Column(name = "CONFIG_SEQ", unique = true, nullable = false)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "IdGenerator")
	private int configSeq;
	
	/* 게시판 이름 */
	@Column(name = "BOARD_NM", unique = false, nullable = false)
	private String boardNm;
	
	/* 게시판 사용여부 */
	@Column(name = "BOARD_USE_YN", unique = false, nullable = false)
	private String boardUseYn;
	
	/* 댓글 사용여부 */
	@Column(name = "COMMENT_USE_YN", unique = false, nullable = false)
	private String commentUseYn;
	
	/* 에디터 사용여부 */
	@Column(name = "EDITOR_USE_YN", unique = false, nullable = false)
	private String editorUseYn;
	
	/* 익명 사용여부 */
	@Column(name = "ANONYMOUS_USE_YN", unique = false, nullable = false)
	private String anonymousUseYn;
				   
	/* 비밀글 사용여부 */
	@Column(name = "SECRET_USE_YN", unique = false, nullable = false)
	private String secretUseYn;
	
	/* 게시판 생성일자 */
	@Column(name = "REG_DATE", unique = false, nullable = false)
	private String regDate;
	
	/* 게시판 설정 수정일자 */
	@Column(name = "EDIT_DATE", unique = false, nullable = false)
	private String editDate;

	public int getConfigSeq() {
		return configSeq;
	}

	public void setConfigSeq(int configSeq) {
		this.configSeq = configSeq;
	}

	public String getBoardNm() {
		return boardNm;
	}

	public void setBoardNm(String boardNm) {
		this.boardNm = boardNm;
	}

	public String getBoardUseYn() {
		return boardUseYn;
	}

	public void setBoardUseYn(String boardUseYn) {
		this.boardUseYn = boardUseYn;
	}

	public String getCommentUseYn() {
		return commentUseYn;
	}

	public void setCommentUseYn(String commentUseYn) {
		this.commentUseYn = commentUseYn;
	}

	public String getEditorUseYn() {
		return editorUseYn;
	}

	public void setEditorUseYn(String editorUseYn) {
		this.editorUseYn = editorUseYn;
	}

	public String getAnonymousUseYn() {
		return anonymousUseYn;
	}

	public void setAnonymousUseYn(String anonymousUseYn) {
		this.anonymousUseYn = anonymousUseYn;
	}

	public String getSecretUseYn() {
		return secretUseYn;
	}

	public void setSecretUseYn(String secretUseYn) {
		this.secretUseYn = secretUseYn;
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

	@Override
	public String toString() {
		return "BoardConfig [configSeq=" + configSeq + ", boardNm=" + boardNm + ", boardUseYn=" + boardUseYn
				+ ", commentUseYn=" + commentUseYn + ", editorUseYn=" + editorUseYn + ", anonymousUseYn="
				+ anonymousUseYn + ", secretUseYn=" + secretUseYn + ", regDate=" + regDate + ", editDate=" + editDate
				+ "]";
	}


	
	
}
