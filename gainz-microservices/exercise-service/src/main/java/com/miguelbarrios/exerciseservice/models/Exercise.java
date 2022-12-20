package com.miguelbarrios.exerciseservice.models;

import java.util.Objects;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Builder;

@Builder
@AllArgsConstructor
@Entity
public class Exercise {

	
	@Id
	@GeneratedValue(strategy= GenerationType.AUTO)
	private Integer id;
	
	private String name;
	
	@Column(name="custom_exercise")
	private boolean isCustomExercise;
	
	
	@Column(name="user_id")
	private Integer userId;

	@Column(name="target_muscles")
	@ElementCollection(targetClass=String.class)
	private Set<String> targetedMuscles;
	
	
	public Exercise() {
		
	}

	public Exercise(String name, boolean isCustomExercise, Integer userId, Set<String> targetedMuscles) {
		super();
		this.name = name;
		this.isCustomExercise = isCustomExercise;
		this.userId = userId;
		this.targetedMuscles = targetedMuscles;
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

	


	@Override
	public String toString() {
		return "Exercise [id=" + id + ", name=" + name + ", isCustomExercise=" + isCustomExercise + ", userId=" + userId
				+ ", targetedMuscles=" + targetedMuscles + "]";
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


	public Integer getUserId() {
		return userId;
	}


	public void setUserId(Integer userId) {
		this.userId = userId;
	}


	public Set<String> getTargetedMuscles() {
		return targetedMuscles;
	}


	public void setTargetedMuscles(Set<String> targetedMuscles) {
		this.targetedMuscles = targetedMuscles;
	}
	
	
}
