package com.lmig.moviedb;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MovieController {
	
	@Autowired
	private MovieRepository movieRepository;
	
//	@RequestMapping(path = "/person", method = RequestMethod.GET)
//	public String person(Model model, String name, String city, int age) {
//		Person p = new Person(name, city, age);
//		model.addAttribute("person", p);
//		return "person";
//	}

	@RequestMapping(path = "/", method = RequestMethod.GET)
	public String home(Model model, HttpSession session) {
		model.addAttribute("name", session.getAttribute("userName"));
		return "home";
	}

	@RequestMapping(path = "/login", method = RequestMethod.POST)
	public String login(HttpSession session, String userName, String other) {
		System.out.println(other);
		session.setAttribute("userName", userName);
		return "redirect:/";
	}	
	
//	added as part of JUnit testing
	@RequestMapping(value = "/api/addMovie2", method = RequestMethod.POST)
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
}