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

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith( SpringRunner.class )
@SpringBootTest
@ExtendWith(SpringExtension.class)
class ExerciseServiceTests {
	
	@Autowired
	private ExerciseRepository exerciseRepository;
	
	@Autowired
	private ExerciseServiceImpl exerciseService;
	
	private static int userId = 1;
	
	private static int userId2 = 2;
	

	@BeforeAll
	static void setUpBeforeClass() throws Exception {

	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
	}

	@BeforeEach
	void setUp() throws Exception {
	}

	@AfterEach
	void tearDown() throws Exception {
	}
	
	@Test
	void should_get_exercise_by_id() {
		Set<String> targetedMuscles = new HashSet<>();
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
		exercises.add(new Exercise("Bench Press", false, null, null));
		exercises.add(new Exercise("Shoulder Press", false, null, null));
		exercises.add(new Exercise("Lat Pull", false, null, null));
		exercises.add(new Exercise("Squat", false, userId, null));
		exercises.add(new Exercise("DeadLift", false, userId, null));
		
		List<Exercise> actual = exerciseService.getExercise();
		assertNotNull(actual);
		assertTrue(actual.size() > 0);
	}
	
	@Test
	void should_get_user_created_exercises() {
		List<Exercise> exercises = new ArrayList<>();
		exercises.add(new Exercise("Bench Press", true, userId, null));
		exercises.add(new Exercise("Shoulder Press", false, null, null));
		exercises.add(new Exercise("Lat Pull", false, null, null));
		exercises.add(new Exercise("Squat", true, userId2, null));
		exercises.add(new Exercise("DeadLift", true, userId2, null));
		exerciseRepository.saveAllAndFlush(exercises);
		
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
		exerciseRepository.deleteAll();
		
		int userId = 4;
		List<Exercise> exercises = new ArrayList<>();
		exercises.add(new Exercise("Bench Press", true, userId, null));
		exercises.add(new Exercise("Squat", true, userId, null));
		exercises.add(new Exercise("DeadLift", true, userId, null));
		exerciseRepository.saveAllAndFlush(exercises);
		
		exerciseService.removeAllCustomExercisesCreatedByUser(userId);
		List<Exercise> userExercises = exerciseRepository.findAllByUserId(userId); 
		assertNotNull(userExercises);
		assertEquals(0, userExercises.size());
	}
	
	@Test
	void should_delete_exercise_by_id() {
		exerciseRepository.deleteAll();
		List<Exercise> exercises = new ArrayList<>();
		exercises.add(new Exercise("Bench Press", true, userId, null));
		exercises.add(new Exercise("Squat", true, userId, null));
		exercises.add(new Exercise("DeadLift", true, userId, null));
		exerciseRepository.saveAllAndFlush(exercises);
		
		List<Exercise> userExercises = exerciseRepository.findAllByUserId(userId);
		int exerciseId = userExercises.get(0).getId();
		
		boolean deleted = exerciseService.deleteExercise(exerciseId, userId);
		assertTrue(deleted);
		userExercises = exerciseRepository.findAllByUserId(userId);
		
		assertEquals(2, userExercises.size());

	}
	
	@Test
	void should_get_all_user_created_exercises() {
		exerciseRepository.deleteAll();
		List<Exercise> exercises = new ArrayList<>();
		exercises.add(new Exercise("Bench Press", true, 1, null));
		exercises.add(new Exercise("Squat", true, 1, null));
		exercises.add(new Exercise("DeadLift", true, 2, null));
		exercises.add(new Exercise("DeadLift 2", false, null, null));
		exerciseRepository.saveAllAndFlush(exercises);
		
		List<Exercise> userCreatedExercises =  exerciseService.getAllCustomExercises();
		assertNotNull(userCreatedExercises);
		assertEquals(3, userCreatedExercises.size());
	}
	
	

}
