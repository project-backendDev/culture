package com.project.culture.movie;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@Table(name = "MOVIE")
public class Movie {

	/* 순번 */
	@Id
	@Column(name = "MOVIE_ID", unique = true, nullable = false)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "IdGenerator")
	private int movieId;
	
	/* 영화제목 (한글) */
	@Column(name = "TITLE_KOR", unique = false, nullable = false)
	private String titleKor;
	
	/* 영화제목 (영어) */
	@Column(name = "TITLE_ENG", unique = false, nullable = false)
	private String titleEng;
	
	/* 장르 */
	@Column(name = "GENRE", unique = false, nullable = false)
	private String genre;
	
	/* 원본 언어 */
	@Column(name = "ORIGINAL_LANGUAGE", unique = false, nullable = false)
	private String originalLanguage;
	
	/* 설명 */
	@Column(name = "OVERVIEW", unique = false, nullable = false)
	private String overview;
	
	/* 개봉일 */
	@Column(name = "RELEASE_DATE", unique = false, nullable = false)
	private String releaseDate;
	
	/* 배경이미지 경로 */
	@Column(name = "BACKDROP_IMAGE_PATH", unique = false, nullable = false)
	private String backdropImagePath;
	
	/* 포스터이미지 경로 */
	@Column(name = "POSTER_IMAGE_PATH", unique = false, nullable = false)
	private String posterImagePath;
	
	/* 평가갯수 */
	@Column(name = "VOTE_COUNT", unique = false, nullable = false)
	private String voteCount;
	
	/*평점 */
	@Column(name = "VOTE_AVERAGE", unique = false, nullable = false)
	private String voteAverage;
	
	/* 성인 여부 */
	@Column(name = "ADULT", unique = false, nullable = false)
	private String adult;
	
	/* 순위 */
	@Column(name = "RANK", unique = false, nullable = false)
	private int rank;
	
	/* 데이터 입력일 */
	@Column(name = "REG_DATE", unique = false, nullable = false)
	private String regDate;
	
	
	

	public Movie(String titleKor, String titleEng, String genre, String originalLanguage, String overview,
			String releaseDate, String backdropImagePath, String posterImagePath, String voteCount, String voteAverage,
			String adult, int rank, String regDate) {
		super();
		this.titleKor = titleKor;
		this.titleEng = titleEng;
		this.genre = genre;
		this.originalLanguage = originalLanguage;
		this.overview = overview;
		this.releaseDate = releaseDate;
		this.backdropImagePath = backdropImagePath;
		this.posterImagePath = posterImagePath;
		this.voteCount = voteCount;
		this.voteAverage = voteAverage;
		this.adult = adult;
		this.rank = rank;
		this.regDate = regDate;
	}

//	public Movie(String title, String original_title, String genre_ids, String original_language, String overview, String release_date,
//			String backdrop_path, String poster_path, String vote_count, String vote_average, String adult, String regDate) {
//		this.titleKor			= title;
//		this.titleEng			= original_title;
//		this.adult				= genre_ids;
//		this.originalLanguage	= original_language;
//		this.overview			= overview;
//		this.releaseDate		= release_date;
//		this.backdropImagePath	= backdrop_path;
//		this.posterImagePath	= poster_path;
//		this.voteCount			= vote_count;
//		this.voteAverage		= vote_average;
//		this.adult				= adult;
//		this.regDate			= regDate;
//	}

	public int getMovieId() {
		return movieId;
	}

	public void setMovieId(int movieId) {
		this.movieId = movieId;
	}

	public String getTitleKor() {
		return titleKor;
	}

	public void setTitleKor(String titleKor) {
		this.titleKor = titleKor;
	}

	public String getTitleEng() {
		return titleEng;
	}

	public void setTitleEng(String titleEng) {
		this.titleEng = titleEng;
	}

	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}

	public String getOriginalLanguage() {
		return originalLanguage;
	}

	public void setOriginalLanguage(String originalLanguage) {
		this.originalLanguage = originalLanguage;
	}

	public String getOverview() {
		return overview;
	}

	public void setOverview(String overview) {
		this.overview = overview;
	}

	public String getReleaseDate() {
		return releaseDate;
	}

	public void setReleaseDate(String releaseDate) {
		this.releaseDate = releaseDate;
	}

	public String getBackdropImagePath() {
		return backdropImagePath;
	}

	public void setBackdropImagePath(String backdropImagePath) {
		this.backdropImagePath = backdropImagePath;
	}

	public String getPosterImagePath() {
		return posterImagePath;
	}

	public void setPosterImagePath(String posterImagePath) {
		this.posterImagePath = posterImagePath;
	}

	public String getVoteCount() {
		return voteCount;
	}

	public void setVoteCount(String voteCount) {
		this.voteCount = voteCount;
	}

	public String getVoteAverage() {
		return voteAverage;
	}

	public void setVoteAverage(String voteAverage) {
		this.voteAverage = voteAverage;
	}

	public int getRank() {
		return rank;
	}

	public void setRank(int rank) {
		this.rank = rank;
	}

	public String getAdult() {
		return adult;
	}

	public void setAdult(String adult) {
		this.adult = adult;
	}

	public String getRegDate() {
		return regDate;
	}

	public void setRegDate(String regDate) {
		this.regDate = regDate;
	}

	@Override
	public String toString() {
		return "Movie [movieId=" + movieId + ", titleKor=" + titleKor + ", titleEng=" + titleEng + ", genre=" + genre
				+ ", originalLanguage=" + originalLanguage + ", overview=" + overview + ", releaseDate=" + releaseDate
				+ ", backdropImagePath=" + backdropImagePath + ", posterImagePath=" + posterImagePath + ", voteCount="
				+ voteCount + ", voteAverage=" + voteAverage + ", rank=" + rank + ", adult=" + adult + ", regDate="
				+ regDate + "]";
	}

	
}
