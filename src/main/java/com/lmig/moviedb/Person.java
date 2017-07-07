package com.lmig.moviedb;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "person")
public class Person implements Serializable {
	@Id
	@GeneratedValue
	int id;

	String name;
//	String birthPlace;
//	String gender;
//	Integer popScore;
//	String about;

//	@ManyToMany(mappedBy = "persons")
//	private Set<Movie> movies;

	public Person() {
//		this.movies = new HashSet<Movie>();
	}

//	public Person(String name, String birthPlace, String gender, Integer popScore, String about) {
	public Person(String name) {
		this();
		this.name = name;
//		this.birthPlace = birthPlace;
//		this.gender = gender;
//		this.popScore = popScore;
//		this.about = about;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

//	public String getBirthPlace() {
//		return birthPlace;
//	}
//
//	public void setBirthPlace(String birthPlace) {
//		this.birthPlace = birthPlace;
//	}
//
//	public String getGender() {
//		return gender;
//	}
//
//	public void setGender(String gender) {
//		this.gender = gender;
//	}
//
//	public Integer getPopScore() {
//		return popScore;
//	}
//
//	public void setPopScore(Integer popScore) {
//		this.popScore = popScore;
//	}
//
//	public String getAbout() {
//		return about;
//	}
//
//	public void setAbout(String about) {
//		this.about = about;
//	}
//
//	public Set<Movie> getMovies() {
//		return movies;
//	}
//
//	public void setMovies(Set<Movie> movies) {
//		this.movies = movies;
//	}
    //PUT method
    public void merge(Person other) {
        if (other.name != null) {
            this.name = other.name;
        }
//        if (other.about != null){
//            this.about=other.about;
//        }
//        if (other.birthPlace != null){
//            this.birthPlace=other.birthPlace;
//        }
//        if (other.gender != null){
//            this.gender=other.gender;
//        }
//        if (other.popScore != null){
//            this.popScore=other.popScore;
//        }
    }
}