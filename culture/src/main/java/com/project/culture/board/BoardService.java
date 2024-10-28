package com.project.culture.board;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface BoardService {

	// [S] 사용자
	
	/* 게시글 조회를 위한 시퀀스 가져오기 */
	public BoardConfig getBoardSeq(int configSeq);
	
	/* 게시글 조회 */
	public List<BoardArtcl> getArtclList(int configSeq);
	
	/* 게시글 작성 */
	public void artclRegist(BoardArtcl artcl);
	
	
	
	// [S] 관리자
	
	/* 게시판 설정 추가 */
	public void configRegist(BoardConfig config);
	
	/* 게시판 설정 조회 */
	public List<BoardConfig> getConfigList();
	
	/* 특정 게시판 설정 시퀀스로 조회 */
	public BoardConfig selectByConfigSeq(int configSeq);
	
	/* 게시판 설정 수정 */
	public void configUpdate(BoardConfig config);
	
	/* 게시판 설정 삭제 */
	public void deleteConfig(int configSeq);
}
