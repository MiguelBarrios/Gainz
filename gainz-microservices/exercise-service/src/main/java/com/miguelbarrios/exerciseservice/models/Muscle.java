package com.miguelbarrios.exerciseservice.models;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="muscle")
public class Muscle {
	
	@Id
	private String name;
	
	public Muscle() {
		
	}
	
	public Muscle(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Muscle [name=" + name + "]";
	}
	
	

}
