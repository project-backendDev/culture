package com.project.culture.movie;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface MovieService {

//	public String insertMovie(Map<String, Object> map);
	public void insertMovie(List<Movie> movieList);
//	public String insertMovie(List<Movie> movie[]);
	
	public List<Movie> getMovieList(String titleKor, String titleEng);
	
	public List<Movie> getAlltMovieList();
}
