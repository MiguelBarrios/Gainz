package com.miguelbarrios.gainz.workoutservice.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/workout")
public class WorkoutController {

    public static final int testUserId = 1;

    @PostMapping
    public void createWorkout(){

    }

    @PostMapping("/addset")
    public void addExerciseSetToWorkout(){

    }


}
