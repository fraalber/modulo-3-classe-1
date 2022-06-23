package com.classe1.jpa;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.JoinColumn;

@Entity
@Table(name = "actors")
public class Actor extends Person implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Column(name = "total_film")
	private int totalFilm;
	
	//@ManyToMany
	@ManyToMany
    @JoinTable(name = "actors_to_movies",
            joinColumns = @JoinColumn(name = "person_id"),
            inverseJoinColumns = @JoinColumn(name = "movie_id"))
	private Set<Movie> movies;

	public int getTotalFilm() {
		return totalFilm;
	}

	public void setTotalFilm(int totalFilm) {
		this.totalFilm = totalFilm;
	}

	public Set<Movie> getMovies() {
		return movies;
	}

	public void setMovies(Set<Movie> movies) {
		this.movies = movies;
	}

	@Override
	public String toString() {
		return "Actor [totalFilm=" + totalFilm + ", name=" + getName() + ", last name()=" + getLastName()
				+ ", year of birth()=" + getYearOfBirth() + "]";
	}
	
	
	

}
