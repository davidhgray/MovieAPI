package com.lmig.moviedb;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.JoinColumn;



@Entity
@Table(name = "movie")
public class Movie implements Serializable {
	@Id
	@GeneratedValue
	int id;

	String movie;
	int year;
	String genre;
	String rating;
	int score;
	String language;
	String person;
	
	@ManyToMany(cascade=CascadeType.ALL)
	private Set<Person> persons;

	public Movie() {
		this.persons = new HashSet<Person>();
	}

    public Movie(String movie, int year, String genre, String rating, int score, String language, String person) {
    	this();
    	this.movie= movie;
    	this.year=year;
    	this.genre=genre;
    	this.rating=rating;
    	this.score=score;
    	this.language=language;
    	this.person=person;

    }
    
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
    public String getMovie() {
		return movie;
	}

	public void setMovie(String movie) {
		this.movie = movie;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}

	public String getRating() {
		return rating;
	}

	public void setRating(String rating) {
		this.rating = rating;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

	public String getLanguage() {
		return language;
	}

	public void setLanguage(String language) {
		this.language = language;
	}

	public String getPerson() {
		return person;
	}

	public void setPerson(String person) {
		this.person = person;
	}

//	@ManyToMany(cascade=CascadeType.ALL)
//	@JoinTable(name="person_movie", joinColumns=@JoinColumn(name="id"), inverseJoinColumns=@JoinColumn(name="id"))
    public Set<Person> getPersons()  
    {  
        return persons;  
    }  
    public void setPersons(Set<Person> persons)  
    {  
        this.persons = persons;  
    }  
}