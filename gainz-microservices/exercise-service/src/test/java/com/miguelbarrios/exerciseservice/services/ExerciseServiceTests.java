package com.miguelbarrios.exerciseservice.services;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.miguelbarrios.exerciseservice.exceptions.ExerciseNotFoundException;
import com.miguelbarrios.exerciseservice.models.Exercise;
import com.miguelbarrios.exerciseservice.repositories.ExerciseRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class ExerciseServiceTests {
	
	@Autowired
	private ExerciseRepository exerciseRepository;
	
	@Autowired
	private ExerciseServiceImpl exerciseService;
	
	private static int userId = 1;
	private static int userId2 = 2;

	@BeforeEach
	void setUp() throws Exception {
		
		resetDB();
	}
	
	void resetDB() {
		exerciseRepository.deleteAll();
		List<Exercise> exercises = new ArrayList<>();
		exercises.add(new Exercise("Bench Press", false, null, null));
		exercises.add(new Exercise("Shoulder Press", false, null, null));
		exercises.add(new Exercise("Lat Pull", false, null, null));
		exercises.add(new Exercise("Squat", true, userId, null));
		exercises.add(new Exercise("DeadLift", true, userId, null));
		exercises.add(new Exercise("Power Clean", true, userId, null));
		exercises.add(new Exercise("Leg Press", true, userId2, null));
		exercises.add(new Exercise("Curls", true, userId2, null));
	
		exerciseRepository.saveAll(exercises);
	}
	
	@Test
	void should_get_exercise_by_id() {
		Exercise exercise = Exercise.builder()
				.name("Bench Press")
				.build();
		Exercise expected = exerciseRepository.save(exercise);
		Exercise actual = exerciseService.getExerciseById(expected.getId());
		assertNotNull(actual);
		assertEquals(expected, actual);
		
	}
	
	@Test
	void should_throw_exception_for_invalid_id(){
		try{
			exerciseService.getExerciseById(999);	
		}
		catch(ExerciseNotFoundException e) {
			return;
		}
		
		fail("Exercise returned with invalid id");
	}
	
	@Test
	void should_get_all_exercises() {
		List<Exercise> exercises = new ArrayList<>();
		exerciseRepository.saveAll(exercises);
		
		List<Exercise> actual = exerciseService.getExercise();
		assertNotNull(actual);
		assertTrue(actual.size() > 0);
	}
	
	@Test
	void should_get_user_created_exercises() {
		List<Exercise> userExercises = exerciseService.getExercisesCreatedbyUser(userId2);
		assertNotNull(userExercises);
		assertEquals(2, userExercises.size());
		for(Exercise e : userExercises) {
			assertEquals(e.getUserId(), userId2);
		}
	}
	
	@Test
	void should_create_global_exercise() {
		Exercise e = new Exercise("Bench Press", false, null, null);
		Set<String> targetedMuscles = new HashSet<>();
		targetedMuscles.add("Chest");
		targetedMuscles.add("Shoulders");
		e.setTargetedMuscles(targetedMuscles);
		
		Exercise exercise = exerciseService.createExercise(e);
		assertNotNull(exercise);
		assertTrue(exercise.getId() > 0);
		assertEquals("Bench Press", exercise.getName());
		assertEquals(2, exercise.getTargetedMuscles().size());
		
	}
	
	@Test
	void should_create_custom_exercise() {
		Set<String> targetedMuscles = new HashSet<>();
		targetedMuscles.add("Legs");
		Exercise e = new Exercise("Leg Press", true, userId, targetedMuscles);
		
		Exercise exercise = exerciseService.createCustomExercise(e, userId);
		assertNotNull(exercise);
		assertNotNull(exercise.getUserId());
		assertNotNull(exercise.getTargetedMuscles());
		
		assertTrue(exercise.getId() > 0);
		assertEquals("Leg Press", exercise.getName());
		assertEquals(1, exercise.getTargetedMuscles().size());
	}
	
	@Test
	void should_delete_all_user_created_exercises() {		
		exerciseService.removeAllCustomExercisesCreatedByUser(userId);
		List<Exercise> userExercises = exerciseRepository.findAllByUserId(userId); 
		assertNotNull(userExercises);
		assertEquals(0, userExercises.size());
	}
	
	@Test
	void should_delete_exercise_by_id() {
		List<Exercise> userExercises = exerciseRepository.findAllByUserId(userId);
		int exerciseId = userExercises.get(0).getId();
		
		boolean deleted = exerciseService.deleteExercise(exerciseId, userId);
		assertTrue(deleted);
		userExercises = exerciseRepository.findAllByUserId(userId);
		assertEquals(2, userExercises.size());
	}
	
	@Test
	void should_get_all_user_created_exercises() {		
		List<Exercise> userCreatedExercises =  exerciseService.getAllCustomExercises();
		assertNotNull(userCreatedExercises);
		assertEquals(5, userCreatedExercises.size());
	}
	
	

}
