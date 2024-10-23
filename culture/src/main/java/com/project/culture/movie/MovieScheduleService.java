package com.project.culture.movie;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;

import org.json.JSONException;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Service
public class MovieScheduleService {
	
	@Value("${tmdb.auth.apiKey}")
	String tmdbApiKey;
	
	// cron - 초 - 분 - 시 - 일 - 월 - 요일
//	@Scheduled(cron = "0 1 0 0 0 0")
//	public void movieDataRead() {
//		BufferedReader bf;
//		JSONObject jsonObj;
//		JSONParser jsonParser = new JSONParser();
//		JSONArray jsonArr = new JSONArray();
//		
//		try {
//			URL url = new URL("https://api.themoviedb.org/3/discover/movie?api_key=" + tmdbApiKey + "&watch_region=KR&language=ko&sort_by=primary_release_date.asc");
//			
//			bf = new BufferedReader(new InputStreamReader(url.openStream(), "UTF-8"));
//			String result = bf.readLine();
//
//			jsonObj = (JSONObject) jsonParser.parse(result);
//			jsonArr = (JSONArray) jsonObj.get("results");
//			int page = Integer.valueOf(jsonObj.get("page").toString());
//			int total_page = Integer.valueOf(jsonObj.get("total_pages").toString());
//			
//			while (page <= total_page) {
//				System.out.println("CurrentPage  [" + page +"]");
//				for (int i = 1; i < jsonArr.size(); i++) {
//					JSONObject jsonObj_ = (JSONObject) jsonArr.get(i);
//					System.out.println("[" + i + "]***********************************************");
//					System.out.println("jsonObj		::	" + jsonObj);
//					System.out.println("jsonObj_	::	" + jsonObj_);
//					System.out.println("***********************************************");
//				}
//				page++;
//			}
//		} catch (MalformedURLException e) {
//			System.out.println("MalformedURLException 	" + e.getMessage());
//		} catch (JSONException e) {
//			System.out.println("JSONException 	" + e.getMessage());
//		} catch (Exception e) {
//			System.out.println("Exception 	" + e.getMessage());
//		}
//	}
}
