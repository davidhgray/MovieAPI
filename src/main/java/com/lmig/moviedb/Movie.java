package com.lmig.moviedb;

import java.io.Serializable;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import io.swagger.annotations.ApiModelProperty;

import javax.persistence.JoinColumn;



@Entity
@Table(name = "movie")
public class Movie implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue
	int id;
//third customization
	@ApiModelProperty(value = "Title of the movie", required = true)
	String movie;
	@ApiModelProperty(value = "Movie Year", required = true)
	int year;
	String genre;
	String rating;
	@ApiModelProperty(value = "Score", required = true)
	int score;
	String language;
	String person;
	
//	@ManyToMany(cascade={CascadeType.PERSIST, CascadeType.MERGE})
	@ManyToMany(cascade=CascadeType.ALL)
	@JoinColumn(name="PersonId")
	private List<Person> persons;

	//keep adding more code like this ManyToMany to add additional roles, one @manytomany for each
	public Movie() {
//		this.persons = new HashSet<Person>();
	}

    public Movie(String movie, Integer year, String genre, String rating, Integer score, String language, String person) {
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
//    @JsonIgnore
	public List<Person> getPersons()  
    {  
        return persons;  
    }  
    public void setPersons(List<Person> persons)  
    {  
        this.persons = persons;  
    }  
    
    //PUT method
    public void merge(Movie other) {
        if (other.movie != null) {
            this.movie = other.movie;
        }
        if (other.genre != null){
            this.genre=other.genre;
        }
        if (other.language != null){
            this.language=other.language;
        }
        if (other.rating != null){
            this.rating=other.rating;
        }
        if (other.year != 0){
            this.year=other.year;
        }
        if (other.score != 0){
            this.score=other.score;
        }
    }
}