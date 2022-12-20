package com.miguelbarrios.exerciseservice.controllers;

import com.miguelbarrios.exerciseservice.models.Exercise;
import com.miguelbarrios.exerciseservice.services.ExerciseService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("api/v1/exercise")
@RestController
public class ExerciseController {
	
	@Autowired
	private ExerciseService exerciseService;
	
	@PostMapping
	public Exercise createExercise(@RequestBody Exercise exercise) {
		System.out.println("here");
		System.out.println(exercise);
		return exerciseService.createExercise(exercise);
	}
	
	@GetMapping
	public String ping() {
		return "pong";
	}
	
}
