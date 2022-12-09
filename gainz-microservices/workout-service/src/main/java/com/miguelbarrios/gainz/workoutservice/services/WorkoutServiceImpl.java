package com.miguelbarrios.gainz.workoutservice.services;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import com.miguelbarrios.gainz.workoutservice.models.Workout;
import com.miguelbarrios.gainz.workoutservice.repositories.WorkoutRepository;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class WorkoutServiceImpl implements WorkoutService{
	
	private final WorkoutRepository workoutRepository;
	
	
    @Override
    public Workout createWorkout(int userId, Workout workout) {
    	workout.setUserId(userId);
    	LocalDateTime startTime = LocalDateTime.now();
    	workout.setStartTime(startTime);
    	workout = workoutRepository.save(workout);
        return workout;
    }

    @Override
    public Workout getWorkout(int userId, int workoutId) {
    	
    	
        return null;
    }

    @Override
    public Workout updateWorkout(int userId, Workout workout) {
        return null;
    }

    @Override
    public void deleteWorkout(int userId, int workoutId) {

    }

    @Override
    public List<Workout> getUserWorkouts(int userId) {
        return null;
    }
}
