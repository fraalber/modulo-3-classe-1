package com.classe1.jpa;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "movies")
public class Movie implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE)  
	@Column(name = "movie_id", unique = true)
	private int id;
	
	@Column(name = "title", nullable = false)
	private String title;

	@Column(name = "year_of_release", nullable = false)
	private int yearOfRelease;
	
	@Column(name = "genre_id", nullable = false)
	private int genreId;
	
	@ManyToMany
	private Set<Actor> actor;

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

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "Movie [id=" + id + ", title=" + title + ", yearOfRelease=" + yearOfRelease + ", genreId=" + genreId
				+ "]";
	}
	
	
}
