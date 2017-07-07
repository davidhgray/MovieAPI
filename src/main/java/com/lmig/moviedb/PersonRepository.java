//this repository was copied from the MovieRepository.java class that existed first

package com.lmig.moviedb;

import com.lmig.moviedb.Person;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface PersonRepository extends JpaRepository<Person, Integer> {
	// @Query("SELECT m FROM Movie m WHERE m.movie = :movie")
	//// public String find(@Param("movie") String movie);
	// List<Movie> find(@Param("movie") String movie);
	//// return m;
	
	Person findById(Integer id);
	
//	List<Person> findByBirthPlace(String birthPlace);

//	List<Person> findByGender(String gender);

	List<Person> findByName(String name);

//	List<Person> findByPopScore(Integer popScore);

//	List<Person> findByGenreAndLanguage(String genre, String language);
	// List<Movie> findByIdOrMovieOrYearOrRatingOrScoreOrGenreOrLanguage(Integer
	// Id, String Movie, Integer Year, String Rating, Integer Score, String
	// Genre, String Language);
	
	@Query("SELECT p FROM Person p WHERE p.name LIKE CONCAT('%', :name, '%') "
//			+ " AND (0 = :popScore OR p.popScore = :popScore) "
//			+ " AND ('' = :birthPlace OR p.birthPlace = :birthPlace) "
//			+ " AND ('' = :gender OR p.gender = :gender) "
			)
//	List<Movie> search(@Param("movie") String Movie, @Param("year") Integer Year, @Param("rating") String Rating);
	
//	old version
//	List<Person> search(@Param("name") String Name, @Param("popScore") Integer PopScore, @Param("birthPlace") String BirthPlace, @Param("gender") String Gender);
//	new version
	List<Person> search(@Param("name") String Name);
//	List<Movie> search(@Param("movie") String Movie, @Param("movie") Integer Year, @Param("movie") String Rating,
//			@Param("score") String Score, @Param("genre") String Genre, @Param("language") String Language);
}