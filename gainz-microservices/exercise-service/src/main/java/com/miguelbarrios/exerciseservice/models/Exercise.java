package com.miguelbarrios.exerciseservice.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Exercise {

	
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private int id;
}