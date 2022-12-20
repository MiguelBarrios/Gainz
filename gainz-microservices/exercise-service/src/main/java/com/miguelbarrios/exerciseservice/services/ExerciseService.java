package com.miguelbarrios.exerciseservice.services;

import java.util.List;

import com.miguelbarrios.exerciseservice.models.Exercise;

public interface ExerciseService {
	Exercise createExercise(Exercise exercise);
	Exercise createCustomExercise(Exercise exercise, int userId);
	Exercise getExerciseById(int id);
	boolean deleteExercise(int exerciseId, int userId);
	List<Exercise> getExercise();
	List<Exercise> getAllCustomExercises();	
	List<Exercise> getExercisesCreatedbyUser(int userId);
	void removeAllCustomExercisesCreatedByUser(int userid);
}
