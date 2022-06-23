package com.classe1.jpa;


import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


public class genres {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)//genero automaticamente l'ID
	@Column(name = "id")
	private int id;
	
	@Column(name = "name", nullable = false)
	private int name;
}
