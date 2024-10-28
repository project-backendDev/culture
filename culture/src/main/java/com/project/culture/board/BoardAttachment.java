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
@Table(name = "BOARD_ATTACHMENT")
public class BoardAttachment {

	/* 첨부파일 번호 */
	@Id
	@Column(name = "ATTACHMENT_SEQ", unique = true, nullable = false)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "IdGenerator")
	private int attachmentSeq;
	
	/* 게시글 번호 */
	@Column(name = "BOARD_SEQ", unique = true, nullable = false)
	private int boardSeq;
	
	/* 파일 원본 이름 */
	@Column(name = "ORIGINAL_NM", unique = false, nullable = false)
	private String originalNm;
	
	/* 파일 변경 이름 */
	@Column(name = "CHANGE_NM", unique = false, nullable = false)
	private String changeNm;
	
	/* 등록일자 */
	@Column(name = "REG_DATE", unique = false, nullable = false)
	private String regDate;
	
	/* 파일 크기 */
	@Column(name = "FILE_SIZE", unique = false, nullable = false)
	private int fileSize;

	public int getAttachmentSeq() {
		return attachmentSeq;
	}

	public void setAttachmentSeq(int attachmentSeq) {
		this.attachmentSeq = attachmentSeq;
	}

	public int getBoardSeq() {
		return boardSeq;
	}

	public void setBoardSeq(int boardSeq) {
		this.boardSeq = boardSeq;
	}

	public String getOriginalNm() {
		return originalNm;
	}

	public void setOriginalNm(String originalNm) {
		this.originalNm = originalNm;
	}

	public String getChangeNm() {
		return changeNm;
	}

	public void setChangeNm(String changeNm) {
		this.changeNm = changeNm;
	}

	public String getRegDate() {
		return regDate;
	}

	public void setRegDate(String regDate) {
		this.regDate = regDate;
	}

	public int getFileSize() {
		return fileSize;
	}

	public void setFileSize(int fileSize) {
		this.fileSize = fileSize;
	}

	@Override
	public String toString() {
		return "BoardAttachment [attachmentSeq=" + attachmentSeq + ", boardSeq=" + boardSeq + ", originalNm="
				+ originalNm + ", changeNm=" + changeNm + ", regDate=" + regDate + ", fileSize=" + fileSize + "]";
	}

	
	
}
