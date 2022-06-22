package com.classi.jpa;

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
@Table(name = "actor")
public class Actor implements Serializable {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "actor_id", unique = true)
	private int id;
	
	@Column(name = "actor_firstname", nullable = false)
	private String name;
	
	@Column(name = "actor_lastname", nullable = false)
	private String lastName;
	
	@Column(name = "actor_birthdate_year", nullable = false)
	private int birthdateYear;
	
	@ManyToMany
	Set<Movie> actedMovies;


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


	public String getLastName() {
		return lastName;
	}


	public void setLastName(String lastName) {
		this.lastName = lastName;
	}


	public int getBirthdate() {
		return birthdateYear;
	}


	public void setBirthdate(int birthdateYear) {
		this.birthdateYear = birthdateYear;
	}


	@Override
	public String toString() {
		return "Actor [id=" + id + ", name=" + name + ", lastName=" + lastName + ", birthdate=" + birthdateYear + "]";
	}
	
	
	
	
}