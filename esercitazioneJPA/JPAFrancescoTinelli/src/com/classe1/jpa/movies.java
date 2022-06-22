package com.classe1.jpa;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.MapsId;
import javax.persistence.Table;


public class movies {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)//genero automaticamente l'ID
	@Column(name = "id")
	private int id;
	
	@Column(name = "title", nullable = false)
	private int title;
	
	@Column(name = "year_of_release", nullable = false)
	private String year_of_release;
	
	@ManyToMany
	@JoinColumn(name = "gerner_id")
	@MapsId
	private genres genres;
	
	
	@ManyToMany (mappedBy = "actors_to_movies")
	private Set<actors> actors;
}
