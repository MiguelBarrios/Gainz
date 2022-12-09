package com.miguelbarrios.gainz.workoutservice.controllers;

import com.miguelbarrios.gainz.workoutservice.models.Workout;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/workout")
public class WorkoutController {

    public static final int testUserId = 1;

    @PostMapping
    public Workout createWorkout(){
        return null;
    }

    @GetMapping("/{workoutId}")
    public Workout getWorkoutById(@PathVariable Integer id){
        return null;
    }

    @PutMapping("/{workoutId}")
    public Workout updateWorkout(@RequestBody Workout workout){
        return null;
    }
    @DeleteMapping("/{workoutId}")
    public void deleteWorkoutById(@PathVariable Integer workoutId){

    }







}
