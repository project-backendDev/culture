package com.project.culture.movie;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.json.JSONException;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.mybatis.spring.MyBatisSystemException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/movie")
public class MovieUserController {

	@Autowired
	private MovieServiceImpl movieServiceImpl;
	
	@Value("${tmdb.auth.apiKey}")
	String tmdbApiKey;
	
	public String getJsonData(String apiUrl) throws Exception {
	    URL url = new URL(apiUrl);
	    HttpURLConnection connection = (HttpURLConnection) url.openConnection();
	    connection.setRequestMethod("GET");
	
	    BufferedReader bf = new BufferedReader(new InputStreamReader(url.openStream(), "UTF-8"));
	    String inputLine;
	    StringBuilder response = new StringBuilder();
	
	    while ((inputLine = bf.readLine()) != null) {
	        response.append(inputLine);
	    }
	    
	    bf.close();
	
	    return response.toString();
	}
	

	@RequestMapping("/movieList")
	public List<Movie> movieList(ModelMap model, @RequestParam(value="page", defaultValue = "1") int page) {
		System.out.println("[S] Controller	Start!!!!!");
		Instant start = Instant.now();
		
		Date today = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		JSONObject jsonObj;
		JSONObject jsonObj_;
		JSONParser jsonParser = new JSONParser();
		JSONArray jsonArr = new JSONArray();
		
		try {
			// watch_region = 시청가능한 지역
			// sort_by = 정렬기준 (popularity.desc > 인기순)
			// language = 언어
			// primary_release_date = 특정날짜에 개봉한 영화
			String apiUrl = "https://api.themoviedb.org/3/discover/movie?api_key=" + tmdbApiKey + "&sort_by=popularity.desc&language=ko&release_date.gte=1980-01-01&primary_release_date.lte=" + sdf.format(today) + "&page=" + page;
			String jsonData = getJsonData(apiUrl);
			jsonObj = (JSONObject) jsonParser.parse(jsonData);
			jsonArr = (JSONArray) jsonObj.get("results");
			int total_page = Integer.valueOf(jsonObj.get("total_pages").toString());
			System.out.println("url		::	" + apiUrl);
			System.out.println("total_page		::	" + total_page);
			
			ArrayList<Movie> movieList = new ArrayList<>();
			Movie movie = null;
			
			for (int currentPage = page; currentPage <= total_page; currentPage++) {
				System.out.println("[ " + page + " ]");
				
				for (int i =0; i < jsonArr.size(); i++) {
					jsonObj_ = (JSONObject) jsonArr.get(i);
					
					String title 		  = jsonObj_.containsKey("title") ? jsonObj_.get("title").toString() : "제목 없음";
					String originTitle 	  = jsonObj_.containsKey("original_title") ? jsonObj_.get("original_title").toString() : "원제 없음";
					String genre 		  = jsonObj_.containsKey("genre_ids") ? (String) jsonObj_.get("genre_ids").toString() : "장르 없음";
					String originLanguage = jsonObj_.containsKey("original_language") ? jsonObj_.get("original_language").toString() : "언어 없음";
					String overview  	  = jsonObj_.containsKey("overview") ? jsonObj_.get("overview").toString() : "개요 없음";
					String releaseDate 	  = jsonObj_.containsKey("release_date") ? jsonObj_.get("release_date").toString() : "개봉일 없음";
					String backdropPath   = jsonObj_.containsKey("backdrop_path") ? jsonObj_.get("backdrop_path").toString() : "배경 없음";
					String posterPath 	  = jsonObj_.containsKey("poster_path") ? jsonObj_.get("poster_path").toString() : "포스터 없음";
					String voteCnt 	  	  = jsonObj_.containsKey("vote_count") ? jsonObj_.get("vote_count").toString() : "0";
					String voteAvg 	 	  = jsonObj_.containsKey("vote_average") ? jsonObj_.get("vote_count").toString() : "0";
					String adult 		  = jsonObj_.containsKey("adult") ? jsonObj_.get("adult").toString() : "false";
					int rank 		  	  = jsonObj_.containsKey("rank") ? (int) jsonObj_.get("rank") : 0;
					
					if (page > 30000) {
						System.out.println(jsonObj_);
					}
					
					movie = new Movie(title, originTitle, genre, originLanguage, overview, releaseDate, backdropPath, posterPath, voteCnt, voteAvg, adult, rank, "");
					movieList.add(movie);
					
				}
				// 저장된 데이터가 중복인건가..?? 왜>?>??
				// 2500개 >  63278m/s (63.27 초)
				// 5000개 >  60116m/s (60.11 초)
				// 10000개 > 62840m/s (62.84 초)  >>>>>>>>> 실행시간 어케 줄이지??
				if (page % 5000 == 0) {
					System.out.println("Complete!!!");
					movieServiceImpl.insertMovie(movieList);
					movieList.clear();
				}
				page++;
			}
			Instant end = Instant.now();
			long executionTime = Duration.between(start, end).toMillis();
			System.out.println("for문 나옴");
			System.out.println("걸린 시간		" + executionTime);
		} catch (MyBatisSystemException e) {
			Throwable cause = e.getCause();
		    if (cause != null) {
		        cause.printStackTrace();
		    } else {
		        e.printStackTrace();
		    }
		} catch (JSONException e) {
			e.printStackTrace();
		} catch (NullPointerException e) { 
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		System.out.println("[E] Controller End");
		
		return null;
	}
	
	
}
