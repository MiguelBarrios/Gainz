package com.miguelbarrios.gainz.workoutservice.services;

import com.miguelbarrios.gainz.workoutservice.models.Workout;
import org.hibernate.jdbc.Work;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WorkoutServiceImpl implements WorkoutService{
	
    @Override
    public Workout createWorkout(int userId, Workout workout) {
        return null;
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
