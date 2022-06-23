package com.esercizio1.jpa;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "actor")
public class ActorEntity implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "actor_id", unique = true)
	private int actor_id;

	@Column(name = "name", nullable = false)
	private String name;

	@Column(name = "last_name", nullable = false)
	private String last_name;

	@Column(name = "year_of_birth", nullable = false)
	private int year_of_birth;
	
	@ManyToMany(cascade = { CascadeType.ALL })
    @JoinTable(
        name = "actors_to_movies", 
        joinColumns = { @JoinColumn(name = "actor_id") }, 
        inverseJoinColumns = { @JoinColumn(name = "movie_id") }
    )
    private Set<MovieEntity> movies;

	public int getId() {
		return actor_id;
	}

	public void setId(int actor_id) {
		this.actor_id = actor_id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLast_name() {
		return last_name;
	}

	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}

	public int getYear_of_birth() {
		return year_of_birth;
	}

	public void setYear_of_birth(int year_of_birth) {
		this.year_of_birth = year_of_birth;
	}

	@Override
	public String toString() {
		return "Actor [id=" + actor_id + ", name=" + name + ", last_name=" + last_name + ", year_of_birth=" + year_of_birth
				+ "]";
	}

}