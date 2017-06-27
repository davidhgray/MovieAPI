package com.lmig.moviedb;


public class Movie {
	String movie;
	int year;
	String genre;
	String rating;
	int score;
	String language;
	String person;


    public Movie(String movie, int year, String genre, String rating, int score, String language, String person) {
    	this.movie= movie;
    	this.year=year;
    	this.genre=genre;
    	this.rating=rating;
    	this.score=score;
    	this.language=language;
    	this.person=person;

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

}