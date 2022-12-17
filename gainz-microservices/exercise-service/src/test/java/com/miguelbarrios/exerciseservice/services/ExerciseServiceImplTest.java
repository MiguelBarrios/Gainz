package com.miguelbarrios.exerciseservice.services;

import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

import java.util.List;

import com.miguelbarrios.exerciseservice.models.Muscle;
import com.miguelbarrios.exerciseservice.repositories.ExerciseRepository;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

class ExerciseServiceImplTest {
	
	@Autowired
	private ExerciseService exerciseService;
	
	@Autowired
	private ExerciseRepository exerciseRepository;

    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void createExercise() {
        fail("implement");
    }

    @Test
    void deleteExercise() {
        fail("implement");

    }

    @Test
    void getExercise() {
        fail("implement");

    }

    @Test
    void getUserExercises() {
        fail("implement");

    }

    @Test
    void getTargetedMuscles() {
        fail("implement");

    }

    @Test
    void getAllCustomExercises() {
        fail("implement");
    }
    
    @Test
    void should_return_all_muscle_groups() {
    	List<Muscle> muslces = exerciseService.getAllMuscles();
    	assertNotNull(muslces);
    	assertEquals(12, muslces.size());
    }
}