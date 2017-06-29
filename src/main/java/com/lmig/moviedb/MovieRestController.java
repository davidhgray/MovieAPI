package com.lmig.moviedb;

import java.util.ArrayList;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
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

//		personArray.add(new Person(person.getName(), "indy", "male", 5, "ravi is going to gfc"));
//		personArray.add(new Person(personName, "indy", "male", 5, "ravi is going to gfc"));
//		System.out.println(resultArray.toString());
//		return personArray;
	}
}
