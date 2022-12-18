package com.miguelbarrios.exerciseservice.services;

import java.util.List;

import com.miguelbarrios.exerciseservice.models.Exercise;
import com.miguelbarrios.exerciseservice.models.Muscle;

public interface ExerciseService {
	Exercise createExercise();
	boolean deleteExercise();
	
	List<Exercise> getExercise();
	List<Exercise> getUserExercises(int userId);
	List<Muscle> getTargetedMuscles(Exercise exercise);
	List<Muscle> getAllMuscleGroups();

	//Admin methods
	List<Exercise> getAllCustomExercises();
	
	

}
