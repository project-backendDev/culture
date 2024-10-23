package com.project.culture.movie;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MovieServiceImpl implements MovieService {

	@Autowired
	private MovieService movieService;
	
//	@Override
//	public String insertMovie(Map<String, Object> map) {
//		System.out.println("[S] Impl");
//		System.out.println(map);
//		System.out.println("[E] Impl");
//		return movieService.insertMovie(map);
//	}
	
//	@Override
//	public String insertMovie(List<Movie> movie) {
//		System.out.println("[S] Impl");
//		System.out.println(movie);
//		System.out.println("[E] Impl");
//		return movieService.insertMovie(movie);
//	}
	
	@Override
	public void insertMovie(List<Movie> movieList) {
//		System.out.println("[S] Impl");
		if (!movieList.isEmpty()) {
			movieService.insertMovie(movieList);
		}
//		System.out.println("[E] Impl");
	}

	@Override
	public List<Movie> getMovieList(String titleKor, String titleEng) {
		return movieService.getMovieList(titleKor, titleEng);
	}

	@Override
	public List<Movie> getAlltMovieList() {
		List<Movie> list = movieService.getAlltMovieList();
		
		return list;
	}

	

}
