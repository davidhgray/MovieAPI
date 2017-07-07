package com.lmig.moviedb;

import com.lmig.moviedb.Movie;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface MovieRepository extends JpaRepository<Movie, Integer> {
	// @Query("SELECT m FROM Movie m WHERE m.movie = :movie")
	//// public String find(@Param("movie") String movie);
	// List<Movie> find(@Param("movie") String movie);
	//// return m;
	List<Movie> findByGenre(String genre);

	Movie findById(Integer id);

	List<Movie> findByLanguage(String language);

	List<Movie> findByMovieAndGenre(String movie, String genre);

	List<Movie> findByGenreAndLanguage(String genre, String language);
	// List<Movie> findByIdOrMovieOrYearOrRatingOrScoreOrGenreOrLanguage(Integer
	// Id, String Movie, Integer Year, String Rating, Integer Score, String
	// Genre, String Language);

	@Query("SELECT m FROM Movie m WHERE m.movie LIKE CONCAT('%', :movie, '%') "
			+ " AND (0 = :year OR m.year = :year) "
			+ " AND ('' = :rating OR m.rating = :rating) "
			+ " AND (0 = :score OR m.score = :score) "
			+ " AND ('' = :genre OR m.genre = :genre) "
			+ " AND ('' = :language OR language = :language)"
			)
//	List<Movie> search(@Param("movie") String Movie, @Param("year") Integer Year, @Param("rating") String Rating);
	List<Movie> search(@Param("movie") String Movie, @Param("year") Integer Year, @Param("rating") String Rating, @Param("score") Integer Score, @Param("genre") String Genre, @Param("language") String Language);
//	List<Movie> search(@Param("movie") String Movie, @Param("movie") Integer Year, @Param("movie") String Rating,
//			@Param("score") String Score, @Param("genre") String Genre, @Param("language") String Language);
}