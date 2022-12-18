package com.miguelbarrios.exerciseservice.services;

import java.util.List;

import com.miguelbarrios.exerciseservice.models.Exercise;
import com.miguelbarrios.exerciseservice.models.MuscleGroup;

public interface ExerciseService {
	Exercise createExercise(Exercise exercise);
	Exercise createCustomExercise(Exercise exercise, int userId);
	Exercise getExerciseById();
	boolean deleteExercise();
	List<Exercise> getExercise();
	List<Exercise> getUserExercises(int userId);
	List<MuscleGroup> getTargetedMuscles(Exercise exercise);
	List<MuscleGroup> getAllMuscleGroups();
	List<Exercise> getAllCustomExercises();
}
