package com.classi.jpa;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "actor")
public class Actor implements Serializable {

	
	private int id;
	
	
	private String name;
	
	
	private String lastName;
	
	
	private int birthdate;


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
		return birthdate;
	}


	public void setBirthdate(int birthdate) {
		this.birthdate = birthdate;
	}


	@Override
	public String toString() {
		return "Actor [id=" + id + ", name=" + name + ", lastName=" + lastName + ", birthdate=" + birthdate + "]";
	}
	
	
	
	
}