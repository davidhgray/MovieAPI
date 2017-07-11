package com.lmig.moviedb;

import java.lang.annotation.Repeatable;
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

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.*;
import io.swagger.annotations.ApiResponses;
import io.swagger.annotations.ApiResponse;

//import com.google.gson.Gson;

@RestController
//first customization
@Api(value="Movie API", description = "Operations for the Movie API")
public class MovieRestController {
	@Autowired
	private MovieRepository movieRepository;
	
	@Autowired
	private PersonRepository personRepository;
	
	@Autowired
	private UserRepository userRepository;

	//second customization
	@ApiOperation(value = "Add a Person", notes = "Adds a person to the database")
	@ApiResponses(value = {
	        @ApiResponse(code = 201, message = "Successfully added"),
	        @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
	        @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
	        @ApiResponse(code = 404, message = "The resource you were trying to reach is not found")
	}
	)
	
	@RequestMapping(value = "/api/addPerson", method = RequestMethod.POST)
	public HttpStatus addPerson(@RequestBody Person person) {
		if (person == null) {
			 return HttpStatus.BAD_REQUEST;
		}
		personRepository.save(person);
		return HttpStatus.OK;
	}
	
	@ApiOperation(value = "Adds a User", notes = "Adds a user to the database")
	@ApiResponses(value = {
	        @ApiResponse(code = 201, message = "Successfully added"),
	        @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
	        @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
	        @ApiResponse(code = 404, message = "The resource you were trying to reach is not found")
	}
	)
	
	@RequestMapping(value = "/api/addUser", method = RequestMethod.POST)
	public HttpStatus addUser(@RequestBody User user) {
		if (user == null) {
			 return HttpStatus.BAD_REQUEST;
		}
		userRepository.save(user);
		return HttpStatus.OK;
	}
	
	//second customization
	@ApiOperation(value = "Adds a Movie", notes = "Adds a movie to the database")
	@ApiResponses(value = {
	        @ApiResponse(code = 201, message = "Successfully added"),
	        @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
	        @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
	        @ApiResponse(code = 404, message = "The resource you were trying to reach is not found")
	}
	)

	@RequestMapping(value = "/api/addMovie", method = RequestMethod.POST)
//	added the @ResponseBody as part of JUnit testing
	@ResponseBody
	public HttpStatus addMovie(@RequestBody Movie movie) {
		if (movie == null) {
			 return HttpStatus.BAD_REQUEST;
		}
		System.out.println("ok from JUnit");
		movieRepository.save(movie);
		return HttpStatus.OK;
	}

	//second customization
	@ApiOperation(value = "Updates a Movie", notes = "Updates a movie in the database")
	@ApiResponses(value = {
	        @ApiResponse(code = 201, message = "Successfully updated"),
	        @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
	        @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
	        @ApiResponse(code = 404, message = "The resource you were trying to reach is not found")
	}
	)
	
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
	
	//second customization
	@ApiOperation(value = "Updates a Person", notes = "Updates a person in the database")
	@ApiResponses(value = {
	        @ApiResponse(code = 201, message = "Successfully updated"),
	        @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
	        @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
	        @ApiResponse(code = 404, message = "The resource you were trying to reach is not found")
	}
	)
    
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
	
	//second customization
	@ApiOperation(value = "Updates a User", notes = "Updates a user in the database")
	@ApiResponses(value = {
	        @ApiResponse(code = 201, message = "Successfully updated"),
	        @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
	        @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
	        @ApiResponse(code = 404, message = "The resource you were trying to reach is not found")
	}
	)
	
    @RequestMapping(path = "/api/putUser", method = RequestMethod.PUT)
    public ResponseEntity<User> updateUser(@RequestBody User u) {  
        System.out.println(" PUT/api/user id is" + u.getId());
        if (u.getId() == 0) {
            return new ResponseEntity<User>(HttpStatus.BAD_REQUEST);
        }
        System.out.println(userRepository.findById(u.getId()));
        User existing = userRepository.findById(u.getId());
        if (existing == null) {
			return new ResponseEntity<User>(existing, HttpStatus.NOT_FOUND);
		}
        System.out.println(existing.name);
//        existing.name="david";
        existing.merge(u);
        userRepository.save(existing);
        System.out.println("");
        System.out.println("ok 2");
        return new ResponseEntity<User>(existing, HttpStatus.OK);
    }
	
	//second customization
	@ApiOperation(value = "Deletes a Movie", notes = "Deletes a movie from the database")
	@ApiResponses(value = {
	        @ApiResponse(code = 201, message = "Successfully deleted"),
	        @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
	        @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
	        @ApiResponse(code = 404, message = "The resource you were trying to reach is not found")
	}
	)    
    
	// this deletes single movie using Pathvariable
	@RequestMapping(value = "/api/deleteMovie/{id}", method = RequestMethod.DELETE)
	public HttpStatus deleteMovie(@PathVariable(name = "id", required = true) int id) {
		if (id == 0) {
			return HttpStatus.BAD_REQUEST;
		}
		movieRepository.delete(id);
			return HttpStatus.OK;
		// post man URL for putting it is
		// http://localhost:8080/api/deleteMovie/98.
		// Anything in the body will get ignored

	}

	// this deletes single movie using delete method and data supplied thru body
//	@RequestMapping(value = "/api/deleteMovie", method = RequestMethod.DELETE)
//	public void deleteMovie(@RequestBody Integer id) {
//		movieRepository.delete(id);
		// post man URL for putting it is
		// http://localhost:8080/api/deleteMovie/98.
		// Anything in the body will get ignored
//	}

	// multiple movies deleted supplied in the form of a list from the postman
	// body
	// http://localhost:8080/api/deleteMovies is the URL in post man and the
	// body is supplied
	// in the list form as [1,2] where 1 and 2 are the IDs that we want to pass
	// to the list
//	@RequestMapping(value = "/api/deleteMovies", method = RequestMethod.DELETE)
//	public void deleteMovie(@RequestBody List<Integer> ids) {
//		for (Iterator iterator = ids.iterator(); iterator.hasNext();) {
//			Integer integer = (Integer) iterator.next();
//			movieRepository.delete(integer);
//		}
//
//	}
	
	//second customization
	@ApiOperation(value = "Deletes a Person", notes = "Deletes a person from the database")
	@ApiResponses(value = {
	        @ApiResponse(code = 201, message = "Successfully deleted"),
	        @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
	        @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
	        @ApiResponse(code = 404, message = "The resource you were trying to reach is not found")
	}
	)

	// this deletes single Person using Pathvariable
	@RequestMapping(value = "/api/deletePerson/{id}", method = RequestMethod.DELETE)
	public void deletePerson(@PathVariable(name = "id", required = true) int id) {
		personRepository.delete(id);
		// post man URL for putting it is
		// http://localhost:8080/api/deletePerson/98.
		// Anything in the body will get ignored

	}
	
	//second customization
	@ApiOperation(value = "Deletes a User", notes = "Deletes a user from the database")
	@ApiResponses(value = {
	        @ApiResponse(code = 201, message = "Successfully deleted"),
	        @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
	        @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
	        @ApiResponse(code = 404, message = "The resource you were trying to reach is not found")
	}
	)
	
	// this deletes single User using Pathvariable
	@RequestMapping(value = "/api/deleteUser/{id}", method = RequestMethod.DELETE)
	public void deleteUser(@PathVariable(name = "id", required = true) int id) {
		userRepository.delete(id);
		// post man URL for putting it is
		// http://localhost:8080/api/deleteUser/98.
		// Anything in the body will get ignored

	}
	
	//second customization
	@ApiOperation(value = "Get a person", notes = "Returns people from the database")
	@ApiResponses(value = {
	        @ApiResponse(code = 201, message = "Successfully returned people"),
	        @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
	        @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
	        @ApiResponse(code = 404, message = "The resource you were trying to reach is not found")
	}
	)
	
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
	
	//second customization
	@ApiOperation(value = "Get a Movie", notes = "Returns information about a movie")
	@ApiResponses(value = {
	        @ApiResponse(code = 201, message = "Movies successfully retrieved"),
	        @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
	        @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
	        @ApiResponse(code = 404, message = "The resource you were trying to reach is not found")
	}
	)
	
	// Get function using @Query.
	@RequestMapping(value = "/api/getMovieQuery2", method = RequestMethod.GET)
//	@ApiOperation(value = "Get a Movie", notes = "Returns information about a movie")
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
	
	//second customization
	@ApiOperation(value = "Get a user", notes = "Get a user from the database")
	@ApiResponses(value = {
	        @ApiResponse(code = 201, message = "Successfully retrieved list of users"),
	        @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
	        @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
	        @ApiResponse(code = 404, message = "The resource you were trying to reach is not found")
	}
	)
	
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
