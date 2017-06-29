package com.lmig.moviedb;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

//import com.google.gson.Gson;

@RestController
public class MovieRestController {
	@Autowired
	private MovieRepository movieRepository;

	@RequestMapping(path = "/api/Movie", method = RequestMethod.GET)
	public Movie movie(String movie, Integer year, String genre, String rating, Integer score, String language,
			String person) {
		if (year == null) {
			year = 2000;
		}
		if (score == null) {
			score = 2;
		}
		return new Movie(movie, year, genre, rating, score, language, person);
	}

	@RequestMapping(path = "/api/Person", method = RequestMethod.GET)
	public ArrayList<Person> person(String name, String birthPlace, String gender, Integer popScore) {
		if (popScore == null) {
			popScore = 1;
		}
		ArrayList<Person> personArray = new ArrayList<Person>();
		ArrayList<Person> resultArray = new ArrayList<Person>();
		;
		System.out.println("ok1");
		// String about="";
		personArray.add(new Person("ravi", "indy", "male", 5, "ravi is going to gfc"));
		personArray.add(new Person("ravi", "Seattle", "male", 5, "ravi is going to gfc"));
		personArray.add(new Person("David", "Dover", "male", 5, "David is going to gfc"));
		personArray.add(new Person("Tracilyn", "indy", "Female", 5, "Tracilyn is going to gfc"));
		System.out.println("ok2");
		for (int i = 0; i < personArray.size(); i++) {
			if (personArray.get(i).name.equals(name)) {
				System.out.println("ok3");
				resultArray.add(personArray.get(i));
			}

		}
		System.out.println(resultArray.toString());
		return resultArray;
	}

	@RequestMapping(value = "/api/AddPerson", method = RequestMethod.POST)
	public ArrayList<Person> add(@RequestBody Person person, String personName) {

		ArrayList<Person> personArray = new ArrayList<Person>();
		ArrayList<Person> resultArray = new ArrayList<Person>();

		System.out.println("ok1");
		// String about="";
		personArray.add(new Person("ravi", "Seattle", "male", 5, "ravi is going to gfc"));
		personArray.add(new Person("David", "Dover", "male", 5, "David is going to gfc"));
		personArray.add(new Person("Tracilyn", "indy", "Female", 5, "Tracilyn is going to gfc"));
		personArray.add(new Person(person.getName(), "indy", "male", 5, "ravi is going to gfc"));
		personArray.add(new Person(personName, "indy", "male", 5, "ravi is going to gfc"));
		System.out.println(resultArray.toString());
		return personArray;
	}

	@RequestMapping(value = "/api/addMovie", method = RequestMethod.POST)
	public void addMovie(@RequestBody Movie movie) {
		movieRepository.save(movie);

		// personArray.add(new Person(person.getName(), "indy", "male", 5, "ravi
		// is going to gfc"));
		// personArray.add(new Person(personName, "indy", "male", 5, "ravi is
		// going to gfc"));
		// System.out.println(resultArray.toString());
		// return personArray;
	}

	@RequestMapping(value = "/api/putMovie", method = RequestMethod.PUT)
	public void updateMovie(@RequestBody Movie movie) {
		movieRepository.save(movie);
		// post man URL for putting it is http://localhost:8080/api/putMovie/.
		// Input JSON if id is existing, it will get updated.

	}

	// this deletes single movie using Pathvariable
	@RequestMapping(value = "/api/deleteMovie/{id}", method = RequestMethod.DELETE)
	public void deleteMovie(@PathVariable(name = "id", required = true) int id) {
		movieRepository.delete(id);
		// post man URL for putting it is
		// http://localhost:8080/api/deleteMovie/98.
		// Anything in the body will get ignored

	}

	// this deletes single movie using delete method and data supplied thru body
	@RequestMapping(value = "/api/deleteMovie", method = RequestMethod.DELETE)
	public void deleteMovie(@RequestBody Integer id) {
		movieRepository.delete(id);
		// post man URL for putting it is
		// http://localhost:8080/api/deleteMovie/98.
		// Anything in the body will get ignored

	}

	// multiple movies deleted supplied in the form of a list from the postman
	// body
	// http://localhost:8080/api/deleteMovies is the URL in post man and the
	// body is supplied
	// in the list form as [1,2] where 1 and 2 are the IDs that we want to pass
	// to the list
	@RequestMapping(value = "/api/deleteMovies", method = RequestMethod.DELETE)
	public void deleteMovie(@RequestBody List<Integer> ids) {
		for (Iterator iterator = ids.iterator(); iterator.hasNext();) {
			Integer integer = (Integer) iterator.next();
			movieRepository.delete(integer);
		}

	}

	// Get function using @Query.
	@RequestMapping(value = "/api/getMovieQuery2", method = RequestMethod.GET)
	public List<Movie> getMovieQuery(@RequestParam(defaultValue = "") String movie,
			@RequestParam(defaultValue = "0") Integer year, @RequestParam(defaultValue = "") String rating,
			@RequestParam(defaultValue = "") String score, @RequestParam(defaultValue = "") String genre,
			@RequestParam(defaultValue = "") String language) {
		// @Param("movie") String movie,@Param("year") String
		// year,@Param("rating") String rating,@Param("score") String
		// score,@Param("genre") String genre,@Param("language") String
		// language) {
		List<Movie> result = new ArrayList<>();
		System.out.println(language + genre);
		// result = movieRepository.findByMovie(movie);
		// for (int i = 0; i < result.size(); i++) {
		// Movie m = result.get(i);
		// System.out.println(m.year);
		// }
		// result = movieRepository.findByLanguage(language);
		// for (int i = 0; i < result.size(); i++) {
		// Movie m = result.get(i);
		// System.out.println(m.language);
		// }
		// return result;

		// result = movieRepository.findByMovieAndGenre(movie,genre);
		//// for (int i = 0; i < result.size(); i++) {
		//// Movie m = result.get(i);
		//// System.out.println(m.language);
		//// }
		// return result;

		// result = movieRepository.findByGenreAndLanguage(genre,language);
		// for (int i = 0; i < result.size(); i++) {
		// Movie m = result.get(i);
		// System.out.println(m.language);
		// }
		// return result;

		// result =
		// movieRepository.findByIdAndMovieAndYearAndRatingAndScoreAndGenreAndLanguage
		// (id, movie,year,rating,score,genre,language);
		// for (int i = 0; i < result.size(); i++) {
		// Movie m = result.get(i);
		// System.out.println(m.language);
		// }
//		result = movieRepository.search(movie, year, rating, score, genre, language);
		result = movieRepository.search(movie, year, rating);
		System.out.println("result" + result);
		return result;
	}

}
