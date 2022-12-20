package com.miguelbarrios.exerciseservice.models;

import java.util.List;
import java.util.Objects;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
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
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private Integer id;
	
	private String name;
	
	@Column(name="custom_exercise")
	private boolean isCustomExercise;
	
	
	@Column(name="user_id")
	private Integer userId;

	@ManyToMany
	@JoinTable(name="exercise_activates_muscle",
	   joinColumns=@JoinColumn(name="exercise_id"),
	   inverseJoinColumns=@JoinColumn(name="muscle_name")
	 )
	 private List<Muscle> activatedMuscles;
	
	
	public Exercise() {
		
	}

	public Exercise(String name, boolean isCustomExercise, Integer userId, Set<String> targetedMuscles) {
		super();
		this.name = name;
		this.isCustomExercise = isCustomExercise;
		this.userId = userId;
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


	public Integer getUserId() {
		return userId;
	}


	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public List<Muscle> getActivatedMuscles() {
		return activatedMuscles;
	}

	public void setActivatedMuscles(List<Muscle> activatedMuscles) {
		this.activatedMuscles = activatedMuscles;
	}
	
	
	
	
	
	
	
}
