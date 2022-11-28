package com.miguelbarrios.gainz.workoutservice.services;

import com.miguelbarrios.gainz.workoutservice.models.ExerciseGroup;
import com.miguelbarrios.gainz.workoutservice.models.Workout;

public interface WorkoutService {

    void createWorkout(int userId, Workout workout);

    void getWorkout(int userId, int workoutId);

    void updateWorkout(int userId, Workout workout);

    void deleteWorkout(int userId, int workoutId);

    void getUserWorkouts(int userId);
}
