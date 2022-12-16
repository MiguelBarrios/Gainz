package com.miguelbarrios.exerciseservice.services;

import com.miguelbarrios.exerciseservice.models.Exercise;
import com.miguelbarrios.exerciseservice.models.Muscle;

import java.util.List;

public class ExerciseServiceImpl implements ExerciseService{
    @Override
    public Exercise createExercise() {
        return null;
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
    public List<Muscle> getTargetedMuscles(Exercise exercise) {
        return null;
    }

    @Override
    public Muscle addMuscleGroup() {
        return null;
    }

    @Override
    public Muscle removeMuscleGroup(Muscle muscle) {
        return null;
    }

    @Override
    public List<Exercise> getAllCustomExercises() {
        return null;
    }
}
