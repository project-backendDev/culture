package com.project.culture.board;


import java.io.File;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


@Controller
@RequestMapping("/board")
public class BoardUserController {

	@Autowired
	private BoardServiceImpl boardServiceImpl;
	
	@Autowired
	private HttpServletRequest request;
	
	@Autowired
	private HttpServletResponse response;
	
	@RequestMapping(value = "/{configSeq}/artclList")
	public String artclList(@PathVariable("configSeq") int configSeq, BoardVo vo, ModelMap model) {
		
		System.out.println("[S] list");
		BoardConfig config = boardServiceImpl.getBoardSeq(vo.getConfigSeq());
		List<BoardArtcl> artclList = boardServiceImpl.getArtclList(vo.getConfigSeq());
		System.out.println("vo			::	" + vo);
		System.out.println("들어온값		::	" + configSeq);
//		System.out.println("config		::	" + config);
		System.out.println("artclList	::	" + artclList.toString());
		

		model.addAttribute("config", config);
		model.addAttribute("artclList", artclList);
		System.out.println("[E] list");
		
		return "/board/artclList";
	}
	
	@RequestMapping(value = "/{configSeq}/artclRegistView")
	public String artclRegistView(@PathVariable("configSeq") int configSeq, @ModelAttribute( "vo" ) BoardVo vo, ModelMap model) {
//		BoardConfig config = boardServiceImpl.getBoardSeq(configSeq);
		
//		model.addAttribute("config", config);
		
		return "/board/artclRegistView";
	}
	
	@RequestMapping(value = "/{configSeq}/artclRegist.do")
	public String artclRegist(@PathVariable("configSeq") int configSeq, @ModelAttribute( "vo" ) BoardVo vo, BoardArtcl artcl) {
		
		System.out.println("[S] artclReist Controller");
		System.out.println(artcl.toString());
		boardServiceImpl.artclRegist(artcl);
		System.out.println("[E] artclReist Controller");
		
		return "redirect:/board/{configSeq}/artclList";
	}
	
	
	/**
	 * CKEditor 이미지 업로드
	 * @param board
	 * @param artcl
	 * @param request
	 * @param response
	 * @param multiFile
	 * @return
	 * @throws IOException
	 */
	@RequestMapping("/{configSeq}/imageUpload.do")
	@ResponseBody
	public String imgUpload(@PathVariable("configSeq") int configSeq, BoardArtcl artcl, 
						  MultipartHttpServletRequest multiFile) throws IOException {
		
		System.out.println("Controller	imgUpload	Start!!!!");
		
		// 폴더 생성 시 날짜로 구분하기 위해 사용
		LocalDate now = LocalDate.now();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMdd");
		String today = now.format(formatter);
		// 파일을 가져오기 위해 MultipartHttpServletRequest의 getFile 메소드 사용
		MultipartFile file = multiFile.getFile("upload");
		
		if (file.isEmpty()) {
			return "{\"uploaded\": 0, \"error\": {\"message\": \"파일이 비어있습니다.\"}}";
		}
		
		try {
			// 파일이름
			String fileName = file.getOriginalFilename();
			System.out.println("fileName	::	" + fileName);
			
			// 파일이 실제로 저장되는 경로
			String uploadPath = request.getSession().getServletContext().getRealPath("/images/bbs/" + today);
			System.out.println("uploadPath	::	" + uploadPath);
			
            File uploadFile = new File(uploadPath, fileName);
            file.transferTo(uploadFile);
			
			return "{\"uploaded\": 1, \"url\": \"" + "/uploaded/images/" + fileName + "\"}";
		} catch (IOException e) {
			return "{\"uploaded\": 0, \"error\": {\"message\": \"업로드 실패: " + e.getMessage() + "\"}}";
		}
		
		
		// Json 객체 생성
//		JsonObject json = new JsonObject();
//		
//		// Json 객체를 출력하기 위해 PrintWriter 생성
//		PrintWriter printWriter = null;
//		OutputStream out = null;
//
//		// 파일을 가져오기 위해 MultipartHttpServletRequest의 getFile 메소드 사용
//		MultipartFile file = multiFile.getFile("upload");
//		
//		// 폴더 생성 시 날짜로 구분하기 위해 사용
//		LocalDate now = LocalDate.now();
//		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMdd");
//		String today = now.format(formatter);
//		
//		// 파일이 비어있지 않고 (비어 있다면 null 반환)
//		if (file != null) {
//			// 파일 사이즈가 0보다 크고, 파일이름이 공백이 아닐때
//			if(file.getSize() >0 && StringUtils.isNotBlank(file.getName())) {
//				if(file.getContentType().toLowerCase().startsWith("image/")) {
//					try {
//						// 파일 이름 설정
//						String fileName = file.getOriginalFilename();
//						System.out.println("fileName	::	" + fileName);
//						
//						// 바이트 타입설정
//						byte[] bytes = file.getBytes();
//						System.out.println("bytes		::	" + bytes);
//						
//						// 파일이 실제로 저장되는 경로
//						String uploadPath = request.getSession().getServletContext().getRealPath("/images/bbs/" + today); //저장경로
//						File uploadFile = new File(uploadPath);
//						System.out.println("uploadPath-1		::	" + request.getSession().getServletContext());
//						System.out.println("uploadPath-2		::	" + uploadPath);
//						System.out.println("uploadFile			::	" + uploadFile);
//						
//			            if(!uploadFile.exists()) {
//			            	System.out.println("여기!");
//			            	uploadFile.mkdir();
//			            	System.out.println("여기요~~~~~~~~~~");
//			            }
//						
//						// 파일이름을 랜덤하게 생성
//						String fileName2 = UUID.randomUUID().toString();
////						uploadPath = uploadPath + "/" + fileName2 + fileName;
//						uploadPath = uploadPath + "/" + fileName2;
//						System.out.println("Upload Path: " + uploadPath);
//						System.out.println("Upload File Exists: " + uploadFile.exists());
//						
//						out = new FileOutputStream(new File(uploadPath));
//			            out.write(bytes);
//			            System.out.println("여기는??");
//			            
//			            // 클라이언트에 이벤트 추가
//			            printWriter = response.getWriter();
//			            response.setContentType("text/html");
//			            
//			            // 파일이 연결되는 Url 주소 설정
//			            String fileUrl = request.getContextPath() + "/images/bbs/" + today +	"/" + fileName2 + fileName;
//			            
//			            // 생성된 Json 객체를 이용해 파일 업로드 + 이름 + 주소를 CkEditor에 전송
//			            json.addProperty("uploaded", 1);
//			            json.addProperty("fileName", fileName);
//			            json.addProperty("url", fileUrl);
//			            
//			            printWriter.print(json);
//					} catch (IOException e) {
//						e.printStackTrace();
//					} finally {
//						if (out != null) {
//							out.close();
//						}
//						if (printWriter != null) {
//							printWriter.close();
//						}
//					}
//				}
//			}
//		}
		
		
		
		
		
		
	}
}
