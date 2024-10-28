package com.project.culture;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.project.culture.board.BoardConfig;
import com.project.culture.board.BoardServiceImpl;

@Controller
public class Index {

	@Autowired
	private BoardServiceImpl boardServiceImpl;
	
	@RequestMapping(value = "/")
	public String index(ModelMap model) {

		List<BoardConfig> configList = boardServiceImpl.getConfigList();
		System.out.println("Index	::	" + configList);
		
		model.addAttribute("configList", configList);
		
		return "/index";
	}
}
