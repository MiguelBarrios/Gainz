package com.miguelbarrios.exerciseservice.services;

import java.util.List;
import java.util.Set;

import javax.transaction.Transactional;

import com.miguelbarrios.exerciseservice.models.Exercise;
import com.miguelbarrios.exerciseservice.models.MuscleGroup;
import com.miguelbarrios.exerciseservice.repositories.ExerciseRepository;
import com.miguelbarrios.exerciseservice.repositories.MuscleGroupRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class ExerciseServiceImpl implements ExerciseService{
	
	@Autowired
	private ExerciseRepository exerciseRepository;

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

	@Override
	public Exercise getExerciseById() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean deleteExercise(int exerciseId, int userId) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<Exercise> getExercise() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Exercise> getAllCustomExercises() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Exercise> getExercisesCreatedbyUser(int userId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void removeAllCustomExercisesCreatedByUser(int userid) {
		// TODO Auto-generated method stub
		
	} 
	
	

}
