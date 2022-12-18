package com.miguelbarrios.exerciseservice.repositories;

import com.miguelbarrios.exerciseservice.models.Exercise;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ExerciseRepository extends JpaRepository<Exercise, Integer> {

}
