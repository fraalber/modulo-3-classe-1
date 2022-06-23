package com.classe1.jpa;

import java.io.Serializable;
import java.util.Objects;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;


@Entity
@Table(name = "actors")
public class actors implements Serializable{
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)//genero automaticamente l'ID
	@Column(name = "id")
	private int id;
	
	@Column(name = "year_of_birth", nullable = false)
	private int year_of_birth;
	
	@Column(name = "lastName", nullable = false)
	private String lastName;
	
	@Column(name = "name", nullable = false)
	private String name;
	
	
	//impostata relazione molti a molti
	@ManyToMany (mappedBy = "actors_to_movies")
	private Set<movies> movies;

	
	
	
	
	



	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public int getYear_of_birth() {
		return year_of_birth;
	}


	public void setYear_of_birth(int year_of_birth) {
		this.year_of_birth = year_of_birth;
	}


	public String getLastName() {
		return lastName;
	}


	public void setLastName(String lastName) {
		this.lastName = lastName;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	
	
	
}
