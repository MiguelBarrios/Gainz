package com.miguelbarrios.exerciseservice.services;

import java.util.List;

import com.miguelbarrios.exerciseservice.models.Exercise;
import com.miguelbarrios.exerciseservice.models.Muscle;

import org.springframework.stereotype.Service;

@Service
public class ExerciseServiceImpl implements ExerciseService{
    @Override
    public Exercise createExercise() {
        return null;
    }

    @Override
    public boolean deleteExercise() {
        return false;
    }

    @Override
    public List<Exercise> getExercise() {
        return null;
    }

    @Override
    public List<Exercise> getUserExercises(int userId) {
        return null;
    }

    @Override
    public List<Muscle> getTargetedMuscles(Exercise exercise) {
        return null;
    }

    @Override
    public List<Exercise> getAllCustomExercises() {
        return null;
    }

	@Override
	public List<Muscle> getAllMuscles() {
		// TODO Auto-generated method stub
		return null;
	}
}
