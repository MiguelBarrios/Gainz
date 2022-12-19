package com.miguelbarrios.exerciseservice.models;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

import lombok.AllArgsConstructor;
import lombok.Builder;

@Builder
@AllArgsConstructor
@Entity
public class Exercise {

	
	@Id
	@GeneratedValue(strategy= GenerationType.AUTO)
	private int id;
	
	private String name;
	
	@Column(name="custom_exercise")
	private boolean isCustomExercise;
	
	
	@Column(name="user_id")
	private Integer userId;

	@Column(name="target_muscle")
	private Set<String> targetedMuscles;
	
	
	public Exercise() {
		
	}
	

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Exercise other = (Exercise) obj;
		return id == other.id;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public boolean isCustomExercise() {
		return isCustomExercise;
	}

	public void setCustomExercise(boolean isCustomExercise) {
		this.isCustomExercise = isCustomExercise;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public void setId(int id) {
		this.id = id;
	}


	@Override
	public String toString() {
		return "Exercise [id=" + id + ", name=" + name + ", isCustomExercise=" + isCustomExercise + ", userId=" + userId
				+ ", targetedMuscles=" + targetedMuscles + "]";
	}

	
	
	
	
}
