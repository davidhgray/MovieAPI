package com.lmig.moviedb;


public class Person {
	String name;
	String birthPlace;
	String gender;
	Integer popScore;
	String about;


    public Person(String name, String birthPlace, String gender, Integer popScore,String about) {
    	this.name=name;
    	this.birthPlace=birthPlace;
    	this.gender=gender;
    	this.popScore=popScore;
    	this.about=about;
    }

     public Person () {
    	 
     }


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getBirthPlace() {
		return birthPlace;
	}


	public void setBirthPlace(String birthPlace) {
		this.birthPlace = birthPlace;
	}


	public String getGender() {
		return gender;
	}


	public void setGender(String gender) {
		this.gender = gender;
	}


	public Integer getPopScore() {
		return popScore;
	}


	public void setPopScore(Integer popScore) {
		this.popScore = popScore;
	}

	public String getAbout() {
		return about;
	}


	public void setAbout(String about) {
		this.about = about;
	}
 

}