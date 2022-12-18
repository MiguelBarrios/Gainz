package com.miguelbarrios.exerciseservice.models;

import java.util.HashSet;
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
import lombok.Data;

@Builder
@AllArgsConstructor
@Entity
public class Exercise {

	
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private int id;
	
	private String name;
	
	@Column(name="custom_exercise")
	private boolean isCustomExercise;
	
	
	@Column(name="user_id")
	private int userId;
	
	@ManyToMany
	@JoinTable(
			name="exercise_has_target_muscle",
			joinColumns=@JoinColumn(name="exercise_id"),
			inverseJoinColumns=@JoinColumn(name="target_muscle")
			
	)
	private Set<MuscleGroup> targetedMuscles;
	
	
	public Exercise() {
		
	}
	
	public void addMuscleGroup(MuscleGroup muscleGroup) {
		if(targetedMuscles == null) {
			targetedMuscles = new HashSet<>();
		}
		
		if(!targetedMuscles.contains(muscleGroup)) {
			targetedMuscles.add(muscleGroup);
			muscleGroup.addExercise(this);
			
		}
	}
	
	public void removeMuscleGroup(MuscleGroup muscleGroup) {
		if(targetedMuscles != null && targetedMuscles.contains(muscleGroup)) {
			targetedMuscles.remove(muscleGroup);
			muscleGroup.removeExercise(this);
		}
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

	public boolean isCustomExercise() {
		return isCustomExercise;
	}

	public void setCustomExercise(boolean isCustomExercise) {
		this.isCustomExercise = isCustomExercise;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public Set<MuscleGroup> getTargetedMuscles() {
		return targetedMuscles;
	}

	public void setTargetedMuscles(Set<MuscleGroup> targetedMuscles) {
		this.targetedMuscles = targetedMuscles;
	}
	
	
	
	
}
