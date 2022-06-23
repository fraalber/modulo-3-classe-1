package com.esercizio1.jpa;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.Table;

@Entity
@Table(name = "movie")
public class MovieEntity implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "movie_id", unique = true)
	private int movie_id;

	@Column(name = "title", nullable = false)
	private String title;

	@Column(name = "year_of_release", nullable = false)
	private int year_of_release;

	@ManyToOne
	@JoinColumn(name = "genre_id")
	private GenreEntity genreEntity;
	
	@ManyToMany(mappedBy = "movies")
    private Set<ActorEntity> actors;

	public int getId() {
		return movie_id;
	}

	public void setId(int movie_id) {
		this.movie_id = movie_id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public int getYear_of_release() {
		return year_of_release;
	}

	public void setYear_of_release(int year_of_release) {
		this.year_of_release = year_of_release;
	}

	public GenreEntity getGenre() {
		return genreEntity;
	}

	public void setGenre(GenreEntity genre) {
		this.genreEntity = genre;
	}

	@Override
	public String toString() {
		return "Movie [id=" + movie_id + ", title=" + title + ", year_of_release=" + year_of_release + ", genre_id="
				+ genreEntity + "]";
	}

}