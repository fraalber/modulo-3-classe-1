package com.classe1.jpa;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="movie")
public class Movie implements  Serializable{
	@Id
	@Column(name="movie_id", unique = true)
	private int id;
	
	@Id
	@Column(name="movie_title", nullable = false)
	private String title;
	
	@Id
	@Column(name="movie_year_release", nullable = false)
	private int yearOfRelease;
	
	@Id
	@Column(name="movie_genre", nullable = false)
	private int genreId;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public int getYearOfRelease() {
		return yearOfRelease;
	}

	public void setYearOfRelease(int yearOfRelease) {
		this.yearOfRelease = yearOfRelease;
	}

	public int getGenreId() {
		return genreId;
	}

	public void setGenreId(int genreId) {
		this.genreId = genreId;
	}

	@Override
	public String toString() {
		return "Movie [id=" + id + ", title=" + title + ", yearOfRelease=" + yearOfRelease + ", genreId=" + genreId
				+ "]";
	}
	
	
}
