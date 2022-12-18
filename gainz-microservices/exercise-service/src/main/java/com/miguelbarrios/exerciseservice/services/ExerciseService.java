package com.miguelbarrios.exerciseservice.services;

import java.util.List;

import com.miguelbarrios.exerciseservice.models.Exercise;
import com.miguelbarrios.exerciseservice.models.MuscleGroup;

public interface ExerciseService {
	Exercise createExercise();
	boolean deleteExercise();
	
	List<Exercise> getExercise();
	List<Exercise> getUserExercises(int userId);
	List<MuscleGroup> getTargetedMuscles(Exercise exercise);
	List<MuscleGroup> getAllMuscleGroups();

	//Admin methods
	List<Exercise> getAllCustomExercises();
	
	

}
