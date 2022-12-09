package com.miguelbarrios.gainz.workoutservice.models;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import lombok.AllArgsConstructor;
import lombok.Builder;

@Builder
@AllArgsConstructor
@Entity
public class ExerciseGroup {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    
    @Column(name = "exercise_id")
    private Integer exerciseId;
    
    @Column(name = "workout_id")
    private Integer workoutId;
    
    @OneToMany(cascade = CascadeType.ALL)
    private List<ExerciseSet> exerciseSetList;
    
    public ExerciseGroup() {
    	
    }
    
    public void addSetToGroup(ExerciseSet set) {
    	exerciseSetList.add(set);
    }

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Integer getExerciseId() {
		return exerciseId;
	}

	public void setExerciseId(Integer exerciseId) {
		this.exerciseId = exerciseId;
	}

	public Integer getWorkoutId() {
		return workoutId;
	}

	public void setWorkoutId(Integer workoutId) {
		this.workoutId = workoutId;
	}

	public List<ExerciseSet> getExerciseSetList() {
		return exerciseSetList;
	}

	public void setExerciseSetList(List<ExerciseSet> exerciseSetList) {
		exerciseSetList = exerciseSetList;
	}
    
    
	
	
}
