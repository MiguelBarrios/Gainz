package com.miguelbarrios.exerciseservice.services;

import java.util.List;

import javax.transaction.Transactional;

import com.miguelbarrios.exerciseservice.exceptions.ExerciseNotFoundException;
import com.miguelbarrios.exerciseservice.models.Exercise;
import com.miguelbarrios.exerciseservice.repositories.ExerciseRepository;

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
		return exerciseRepository.save(exercise);
	}

	@Override
	public Exercise createCustomExercise(Exercise exercise, int userId) {
		exercise.setCustomExercise(true);
		exercise.setUserId(userId);
		return exerciseRepository.save(exercise);
	}

	@Override
	public Exercise getExerciseById(int id) {
		return exerciseRepository.findById(id).orElseThrow(() -> 
				new ExerciseNotFoundException("exercise with id: " + id + " not found"));
	}

	@Override
	public boolean deleteExercise(int exerciseId, int userId) {
		return false;
	}

	@Override
	public List<Exercise> getExercise() {
		return exerciseRepository.findAll();
	}

	@Override
	public List<Exercise> getAllCustomExercises() {
		return null;
	}

	@Override
	public List<Exercise> getExercisesCreatedbyUser(int userId) {
		return exerciseRepository.findAllByUserId(userId);
	}

	@Override
	@Transactional
	public void removeAllCustomExercisesCreatedByUser(int userid) {
		exerciseRepository.deleteByUserId(userid);
	}

	
	
	

}
