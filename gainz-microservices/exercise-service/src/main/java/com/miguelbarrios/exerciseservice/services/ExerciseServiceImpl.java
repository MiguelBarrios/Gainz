package com.miguelbarrios.exerciseservice.services;

import java.util.List;

import com.miguelbarrios.exerciseservice.models.Exercise;
import com.miguelbarrios.exerciseservice.models.Muscle;
import com.miguelbarrios.exerciseservice.repositories.MuscleRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ExerciseServiceImpl implements ExerciseService{
	
	
	private MuscleRepository muscleRepository;
	
	public ExerciseServiceImpl(MuscleRepository muscleRepository) {
		this.muscleRepository = muscleRepository;
	}
	
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
		return muscleRepository.findAll();
	}
}
