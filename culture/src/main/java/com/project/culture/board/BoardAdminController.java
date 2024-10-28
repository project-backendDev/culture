package com.project.culture.board;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin")
public class BoardAdminController {

	@Autowired
	private BoardServiceImpl boardServiceImpl;
	
	/* 생성된 게시판 리스트 출력 */
	@RequestMapping(value = "/board/configList")
	public String boardConfigList(ModelMap model) {
		
		List<BoardConfig> configList = boardServiceImpl.getConfigList();
		
		model.addAttribute("configList", configList);
		
		return "/admin/configList";
	}
	
	/* 게시판 추가 페이지 */
	@RequestMapping(value = "/board/configRegistView")
	public String boardConfigRegistView() {
		
		return "/admin/configRegistView";
	}
	
	/* 게시판 추가 동작 메소드 */
	@RequestMapping(value = "/board/configRegist.do")
	public String boardConfigRegist(BoardConfig config) {
		
		boardServiceImpl.configRegist(config);
		
		return "redirect:/admin/board/configList"; 
	}
	
	/* 게시판 수정 페이지 */
	@RequestMapping(value = "/board/{configSeq}/configUpdtView")
	public String boardConfigUpdtView(@PathVariable("configSeq") int configSeq, ModelMap model) {
		
		BoardConfig config = boardServiceImpl.selectByConfigSeq(configSeq);

		model.addAttribute("config", config);
		
		return "/admin/configUpdtView";
	}
	
	/* 게시판 수정 동작 메소드 */
	@RequestMapping(value = "/board/{configSeq}/configUpdt.do")
	public String boardConfigUpdt(@PathVariable("configSeq") int configSeq, BoardConfig config) {
		
		System.out.println("수정 시작!!!");
		System.out.println(configSeq);
		boardServiceImpl.configUpdate(config);
		System.out.println("수정 끝!!!");
		
		return "redirect:/admin/board/configList"; 
	}
	
	/* 게시판 삭제 동작 메소드 */
	@RequestMapping(value = "/board/{configSeq}/configDelete.do")
	public String boardConfigDelete(@PathVariable("configSeq") int configSeq, BoardConfig config) {
		
		System.out.println("삭제 시작");
		boardServiceImpl.deleteConfig(configSeq);
		System.out.println("삭제 끝");
		
		return "redirect:/admin/board/configList"; 
	}
	
	
	
	
	
	
	
	
	
}
