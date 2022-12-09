package com.miguelbarrios.gainz.workoutservice.services;

import com.miguelbarrios.gainz.workoutservice.models.ExerciseGroup;
import com.miguelbarrios.gainz.workoutservice.models.Workout;

import java.util.List;

public interface WorkoutService {

    Workout createWorkout(int userId, Workout workout);

    Workout getWorkout(int userId, int workoutId);

    Workout updateWorkout(int userId, Workout workout);

    void deleteWorkout(int userId, int workoutId);

    List<Workout> getUserWorkouts(int userId);
}
