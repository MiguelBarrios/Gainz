package com.miguelbarrios.gainz.workoutservice.repositories;

import com.miguelbarrios.gainz.workoutservice.models.Workout;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WorkoutRepository extends JpaRepository<Workout, Integer> {

}
