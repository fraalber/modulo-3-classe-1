package com.classe1.jpa;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name ="actor")
public class Actor implements Serializable{
	
	@Id
	@Column(name = "actor_id", unique = true)
	private int id;
	
	@Column(name="actor_name", nullable = false)
	private String name;
	
	@Column(name="actor_last_name", nullable = false)
	private String lastName;
	
	@Column(name="actor_year_birth", nullable = false)
	private int yearOfBirth;

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

	public int getYearOfBirth() {
		return yearOfBirth;
	}

	public void setYearOfBirth(int yearOfBirth) {
		this.yearOfBirth = yearOfBirth;
	}

	@Override
	public String toString() {
		return "Actor [id=" + id + ", name=" + name + ", lastName=" + lastName + ", yearOfBirth=" + yearOfBirth + "]";
	}
	
	
	

}
