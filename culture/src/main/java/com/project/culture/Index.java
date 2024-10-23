package com.project.culture;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import org.hibernate.internal.build.AllowSysOut;
import org.json.JSONException;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class Index {

	@Value("${tmdb.auth.apiKey}")
	String tmdbApiKey;
	
	@RequestMapping(value = "/")
	public String index(ModelMap model, @RequestParam(value="page", defaultValue = "1") int page) {
		
		Date today = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		BufferedReader bf;
		JSONObject jsonObj;
		JSONObject jsonObj_ = null;
		JSONParser jsonParser = new JSONParser();
		JSONArray jsonArr = new JSONArray();
		
		try {
			URL url = new URL("https://api.themoviedb.org/3/discover/movie?api_key=" + tmdbApiKey + "&watch_region=KR&language=ko&page=" + page + "&sort_by=primary_release_date.desc&primary_release_date.lte=" + sdf.format(today));
			bf = new BufferedReader(new InputStreamReader(url.openStream(), "UTF-8"));
			String result = bf.readLine();
			ArrayList<String> moviList = new ArrayList();

			jsonObj = (JSONObject) jsonParser.parse(result);
			jsonArr = (JSONArray) jsonObj.get("results");
			//int page = Integer.valueOf(jsonObj.get("page").toString());
			int total_page = Integer.valueOf(jsonObj.get("total_pages").toString());
			
			System.out.println("total_page	" + total_page);
			System.out.println("jsonObj		" + jsonObj);
			System.out.println("jsonArr		" + jsonArr);
			
			while (page <= total_page) {
				System.out.println("지금 몇 페이지??	" + page);
				
				for (int i = 0; i < jsonArr.size(); i++) {
					System.out.println("여기야?");
					jsonObj_ = (JSONObject) jsonArr.get(i);
					System.out.println("여긴가?");
					
					// JSON 파싱한 데이터를 list에 넣고 JSP로 보내야할지
					// JSON 데이터 전체를 JSP로 보내야할지 결정하기
//					moviList.add((String) jsonObj_.get("original_language"));
//					moviList.add((String) jsonObj_.get("original_title"));
//					moviList.add((String) jsonObj_.get("video"));
//					moviList.add((String) jsonObj_.get("title"));
//					moviList.add((String) jsonObj_.get("genre_ids"));
//					moviList.add((String) jsonObj_.get("poster_path"));
//					moviList.add((String) jsonObj_.get("backdrop_path"));
//					moviList.add((String) jsonObj_.get("release_date"));
//					moviList.add((String) jsonObj_.get("popularity"));
//					moviList.add((String) jsonObj_.get("vote_average"));
//					moviList.add((String) jsonObj_.get("id"));
//					moviList.add((String) jsonObj_.get("adult"));
//					moviList.add((String) jsonObj_.get("vote_count"));
					
					System.out.println("[" + i + "]");
					System.out.println(jsonObj_);
					System.out.println();
					
//					model.addAttribute("movieList", moviList);
				}				
				
				if (page == 10) {
					break;
				}
				page++;
			}
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (JSONException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		return "/index";
	}
}
