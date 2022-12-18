package com.miguelbarrios.exerciseservice.models;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name="target_muscle")
public class MuscleGroup {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;
    
    @ManyToMany(mappedBy="targetedMuscles")
    private Set<Exercise> exercises;

    public MuscleGroup(){}
    
    public MuscleGroup(String name) {
    	this.name = name;
    }
    
    public void addExercise(Exercise exercise) {
    	if(exercises == null) {
    		exercises = new HashSet<>();
    	}
    	
    	if(!exercises.contains(exercise)) {
    		exercises.add(exercise);
    		exercise.addMuscleGroup(this);
    	}
    }
    
    public void removeExercise(Exercise exercise) {
    	if(exercises == null && exercises.contains(exercise)) {
    		exercises.remove(exercise);
    		exercise.removeMuscleGroup(this);
    	}
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
		MuscleGroup other = (MuscleGroup) obj;
		return id == other.id;
	}

	@Override
    public String toString() {
        return "Muscle{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
