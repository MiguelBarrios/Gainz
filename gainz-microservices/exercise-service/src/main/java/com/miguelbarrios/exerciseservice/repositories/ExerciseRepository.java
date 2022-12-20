package com.miguelbarrios.exerciseservice.repositories;

import java.util.List;

import com.miguelbarrios.exerciseservice.models.Exercise;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ExerciseRepository extends JpaRepository<Exercise, Integer> {
	
	List<Exercise> findAllByUserId(int userId);

}
