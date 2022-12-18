package com.miguelbarrios.exerciseservice.services;

import java.util.List;

import com.miguelbarrios.exerciseservice.models.Exercise;
import com.miguelbarrios.exerciseservice.models.MuscleGroup;
import com.miguelbarrios.exerciseservice.repositories.MuscleGroupRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ExerciseServiceImpl implements ExerciseService{
	
	
	private MuscleGroupRepository muscleRepository;
	
	public ExerciseServiceImpl(MuscleGroupRepository muscleRepository) {
		this.muscleRepository = muscleRepository;
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
    public List<MuscleGroup> getTargetedMuscles(Exercise exercise) {
        return null;
    }

    @Override
    public List<Exercise> getAllCustomExercises() {
        return null;
    }

	@Override
	public List<MuscleGroup> getAllMuscleGroups() {
		return muscleRepository.findAll();
	}


	@Override
	public Exercise getExerciseById() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Exercise createExercise(Exercise exercise) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Exercise createCustomExercise(Exercise exercise, int userId) {
		// TODO Auto-generated method stub
		return null;
	}
}
