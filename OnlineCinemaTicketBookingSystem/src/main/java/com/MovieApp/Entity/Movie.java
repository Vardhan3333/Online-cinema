package com.MovieApp.Entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import javax.persistence.GenerationType;

@Entity
public class Movie {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer movieID;
	private String movieName;
	private String language;
	private String duration;
	
	
	public Movie() {
		super();
	}


	public Integer getMovieID() {
		return movieID;
	}


	public void setMovieID(Integer movieID) {
		this.movieID = movieID;
	}


	public String getMovieName() {
		return movieName;
	}


	public void setMovieName(String movieName) {
		this.movieName = movieName;
	}


	public String getLanguage() {
		return language;
	}


	public void setLanguage(String language) {
		this.language = language;
	}


	public String getDuration() {
		return duration;
	}


	public void setDuration(String duration) {
		this.duration = duration;
	}


	@Override
	public String toString() {
		return "Movie [movieID=" + movieID + ", movieName=" + movieName + ", language=" + language + ", duration="
				+ duration + "]";
	}
	
	

}
