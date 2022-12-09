package com.miguelbarrios.gainz.workoutservice.repositories;

import java.util.List;

import com.miguelbarrios.gainz.workoutservice.models.Workout;

import org.springframework.data.jpa.repository.JpaRepository;

public interface WorkoutRepository extends JpaRepository<Workout, Integer> {
	List<Workout> findAllByUserId(Integer userId);
}
