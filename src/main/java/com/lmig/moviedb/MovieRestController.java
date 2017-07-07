package com.lmig.moviedb;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import com.lmig.moviedb.MovieRepository;

//import com.google.gson.Gson;

@RestController
public class MovieRestController {
	@Autowired
	private MovieRepository movieRepository;
	
	@Autowired
	private PersonRepository personRepository;
	
	@Autowired
	private UserRepository userRepository;
	
//TODO do we need this route anymore? 	
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
	
	//TODO do we need this route anymore? 
//	@RequestMapping(path = "/api/Person", method = RequestMethod.GET)
//	public ArrayList<Person> person(String name, String birthPlace, String gender, Integer popScore) {
//		if (popScore == null) {
//			popScore = 1;
//		}
//		ArrayList<Person> personArray = new ArrayList<Person>();
//		ArrayList<Person> resultArray = new ArrayList<Person>();
//		;
//		System.out.println("ok1");
		// String about="";
//		personArray.add(new Person("ravi", "indy", "male", 5, "ravi is going to gfc"));
//		personArray.add(new Person("ravi", "Seattle", "male", 5, "ravi is going to gfc"));
//		personArray.add(new Person("David", "Dover", "male", 5, "David is going to gfc"));
//		personArray.add(new Person("Tracilyn", "indy", "Female", 5, "Tracilyn is going to gfc"));
//		System.out.println("ok2");
//		for (int i = 0; i < personArray.size(); i++) {
//			if (personArray.get(i).name.equals(name)) {
//				System.out.println("ok3");
//				resultArray.add(personArray.get(i));
//			}
//
//		}
//		System.out.println(resultArray.toString());
//		return resultArray;
//	}

//	TODO do we need this route anymore?
	@RequestMapping(value = "/api/AddPerson", method = RequestMethod.POST)
	public ArrayList<Person> add(@RequestBody Person person, String personName) {

		ArrayList<Person> personArray = new ArrayList<Person>();
		ArrayList<Person> resultArray = new ArrayList<Person>();

		System.out.println("ok1");
		// String about="";
//		personArray.add(new Person("ravi", "Seattle", "male", 5, "ravi is going to gfc"));
//		personArray.add(new Person("David", "Dover", "male", 5, "David is going to gfc"));
//		personArray.add(new Person("Tracilyn", "indy", "Female", 5, "Tracilyn is going to gfc"));
//		personArray.add(new Person(person.getName(), "indy", "male", 5, "ravi is going to gfc"));
//		personArray.add(new Person(personName, "indy", "male", 5, "ravi is going to gfc"));
		System.out.println(resultArray.toString());
		return personArray;
	}

	@RequestMapping(value = "/api/addPerson", method = RequestMethod.POST)
	public void addPerson(@RequestBody Person person) {
		personRepository.save(person);
	}
	
	@RequestMapping(value = "/api/addUser", method = RequestMethod.POST)
	public void addUser(@RequestBody User user) {
		userRepository.save(user);
	}

	@RequestMapping(value = "/api/addMovie", method = RequestMethod.POST)
//	added the @ResponseBody as part of JUnit testing
	@ResponseBody
	public void addMovie(@RequestBody Movie movie) {
		movieRepository.save(movie);

		// personArray.add(new Person(person.getName(), "indy", "male", 5, "ravi
		// is going to gfc"));
		// personArray.add(new Person(personName, "indy", "male", 5, "ravi is
		// going to gfc"));
		// System.out.println(resultArray.toString());
		// return personArray;
	}
//old version of putmovie
//	@RequestMapping(value = "/api/putMovie", method = RequestMethod.PUT)
//	public void updateMovie(@RequestBody Movie movie) {
//		movieRepository.save(movie);
//		// post man URL for putting it is http://localhost:8080/api/putMovie/.
//		// Input JSON if id is existing, it will get updated.
//	}
	
    @RequestMapping(path = "/api/putMovie", method = RequestMethod.PUT)
    public ResponseEntity<Movie> updateMovie(@RequestBody Movie m) {  
        System.out.println(" PUT/api/movie id is" + m.getId());
        if (m.getId() == 0) {
            return new ResponseEntity<Movie>(HttpStatus.BAD_REQUEST);
        }
        System.out.println(movieRepository.findById(m.getId()));
        Movie existing = movieRepository.findById(m.getId());
        System.out.println(existing.year);
        existing.merge(m);
        movieRepository.save(existing);
        return new ResponseEntity<Movie>(existing, HttpStatus.OK);
    }
    
    @RequestMapping(path = "/api/putPerson", method = RequestMethod.PUT)
    public ResponseEntity<Person> updatePerson(@RequestBody Person p) {  
        System.out.println(" PUT/api/person id is" + p.getId());
        if (p.getId() == 0) {
            return new ResponseEntity<Person>(HttpStatus.BAD_REQUEST);
        }
        System.out.println(personRepository.findById(p.getId()));
        Person existing = personRepository.findById(p.getId());
        System.out.println(existing.name);
//        existing.name="david";
        existing.merge(p);
        personRepository.save(existing);
        System.out.println("ok 2");
        return new ResponseEntity<Person>(existing, HttpStatus.OK);
    }
	
    @RequestMapping(path = "/api/putUser", method = RequestMethod.PUT)
    public ResponseEntity<User> updateUser(@RequestBody User u) {  
        System.out.println(" PUT/api/user id is" + u.getId());
        if (u.getId() == 0) {
            return new ResponseEntity<User>(HttpStatus.BAD_REQUEST);
        }
        System.out.println(userRepository.findById(u.getId()));
        User existing = userRepository.findById(u.getId());
        System.out.println(existing.name);
//        existing.name="david";
        existing.merge(u);
        userRepository.save(existing);
        System.out.println("ok 2");
        return new ResponseEntity<User>(existing, HttpStatus.OK);
    }
    
//	@RequestMapping(value = "/api/putPerson", method = RequestMethod.PUT)
//	public void updatePerson(@RequestBody Person person) {
//		personRepository.save(person);
//		// post man URL for putting it is http://localhost:8080/api/putPerson/.
//		// Input JSON if id is existing, it will get updated.
//	}

//   old code
//	@RequestMapping(value = "/api/putUser", method = RequestMethod.PUT)
//	public void updateUser(@RequestBody User user) {
//		userRepository.save(user);
//		// post man URL for putting it is http://localhost:8080/api/putUser/.
//		// Input JSON if id is existing, it will get updated.
//	}
	
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

	// this deletes single Person using Pathvariable
	@RequestMapping(value = "/api/deletePerson/{id}", method = RequestMethod.DELETE)
	public void deletePerson(@PathVariable(name = "id", required = true) int id) {
		personRepository.delete(id);
		// post man URL for putting it is
		// http://localhost:8080/api/deletePerson/98.
		// Anything in the body will get ignored

	}
	
	// this deletes single User using Pathvariable
	@RequestMapping(value = "/api/deleteUser/{id}", method = RequestMethod.DELETE)
	public void deleteUser(@PathVariable(name = "id", required = true) int id) {
		userRepository.delete(id);
		// post man URL for putting it is
		// http://localhost:8080/api/deleteUser/98.
		// Anything in the body will get ignored

	}
	
//	Get Person using @Query
	@RequestMapping(value = "/api/getPersonQuery2", method = RequestMethod.GET)
	public List<Person> getPersonQuery(@RequestParam(defaultValue = "") String name)
//			@RequestParam(defaultValue = "0") Integer popScore, @RequestParam(defaultValue = "") String birthPlace,
//			@RequestParam(defaultValue = "") String gender) 
			{
		List<Person> result = new ArrayList<>();
		result = personRepository.search(name);
		return result;
	}
	
	// Get function using @Query.
	@RequestMapping(value = "/api/getMovieQuery2", method = RequestMethod.GET)
	public List<Movie> getMovieQuery(@RequestParam(defaultValue = "") String movie,
			@RequestParam(defaultValue = "0") Integer year, @RequestParam(defaultValue = "") String rating,
			@RequestParam(defaultValue = "0") Integer score, @RequestParam(defaultValue = "") String genre,
			@RequestParam(defaultValue = "") String language) {
		List<Movie> result = new ArrayList<>();
		System.out.println(language + genre);
		
		result = movieRepository.search(movie, year, rating, score, genre, language);
		System.out.println("result" + result);
		return result;
	}
//	Get User using @Query
	@RequestMapping(value = "/api/getUserQuery2", method = RequestMethod.GET)
	public List<User> getUserQuery(@RequestParam(defaultValue = "") String name,
			@RequestParam(defaultValue = "") String location
//			, @RequestParam(defaultValue = "") Date dateJoined
			) 
	{
		List<User> result = new ArrayList<>();
		result = userRepository.search(name, location
//				, dateJoined
				);
		return result;
	}
}
