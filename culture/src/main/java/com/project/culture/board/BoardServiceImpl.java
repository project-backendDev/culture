package com.project.culture.board;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BoardServiceImpl implements BoardService {

	@Autowired
	private BoardService boardService;
	
	@Override
	public BoardConfig getBoardSeq(int configSeq) {
		return boardService.getBoardSeq(configSeq);
	}
	
	@Override
	public List<BoardArtcl> getArtclList(int configSeq) {
		return boardService.getArtclList(configSeq);
	}
	
	@Override
	public void artclRegist(BoardArtcl artcl) {
		boardService.artclRegist(artcl);
	}

	@Override
	public void configRegist(BoardConfig config) {
		boardService.configRegist(config);
	}

	@Override
	public List<BoardConfig> getConfigList() {
		return boardService.getConfigList();
	}

	@Override
	public BoardConfig selectByConfigSeq(int configSeq) {
		return boardService.selectByConfigSeq(configSeq);
	}

	@Override
	public void configUpdate(BoardConfig config) {
		boardService.configUpdate(config);
	}

	@Override
	public void deleteConfig(int configSeq) {
		boardService.deleteConfig(configSeq);
	}


	


}
