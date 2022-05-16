package com.nexturn.mavenproject1;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Movie 
{
  @Override
	public String toString() {
		return "Movie [movieId=" + movieId + ", movieName=" + movieName + ", language=" + language + ", releasedln="
				+ releasedln + ", revInDollars=" + revInDollars + "]";}
	@Id
  @Column(name = "movieId", length = 100)
   private String movieId;
  
  
   private String movieName;
   private String language;
   private int releasedln;
   private int revInDollars;
   

public String getMovieId() {
	return movieId;
}
public void setMovieId(String movieId) {
	this.movieId = movieId;
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
public int getReleasedln() {
	return releasedln;
}
public void setReleasedln(int releasedln) {
	this.releasedln = releasedln;
}
public int getRevenuelnDollars() {
	return revInDollars;
}
public void setRevenuelnDollars(int revenuelnDollars) {
	this.revInDollars = revenuelnDollars;
}
   

public Movie() 
{
	super();
	// TODO Auto-generated constructor stub
}
public Movie(String movieId, String movieName, String language, int releasedln, int revenuelnDollars) {
	super();
	this.movieId = movieId;
	this.movieName = movieName;
	this.language = language;
	this.releasedln = releasedln;
	this.revInDollars = revenuelnDollars;
}
	
}


