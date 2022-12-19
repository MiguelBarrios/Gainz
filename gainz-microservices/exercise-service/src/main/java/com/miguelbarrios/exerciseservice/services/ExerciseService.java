package com.miguelbarrios.exerciseservice.services;

import java.util.List;

import com.miguelbarrios.exerciseservice.models.Exercise;
import com.miguelbarrios.exerciseservice.models.MuscleGroup;

public interface ExerciseService {
	Exercise createExercise(Exercise exercise);
	Exercise createCustomExercise(Exercise exercise, int userId);
	Exercise getExerciseById();
	boolean deleteExercise(int exerciseId, int userId);
	List<Exercise> getExercise();
	List<Exercise> getAllCustomExercises();	
	List<Exercise> getExercisesCreatedbyUser(int userId);
	void removeAllCustomExercisesCreatedByUser(int userid);
}
