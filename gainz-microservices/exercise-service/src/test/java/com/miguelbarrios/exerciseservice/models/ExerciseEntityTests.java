package com.miguelbarrios.exerciseservice.models;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

import com.miguelbarrios.exerciseservice.repositories.ExerciseRepository;
import com.miguelbarrios.exerciseservice.repositories.MuscleGroupRepository;

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
class ExerciseEntityTests {
	
	@Autowired
	private ExerciseRepository exerciseRepository;
	
	@Autowired
	private MuscleGroupRepository mgRepository;

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
	void basic_exercise_entity_mapping_test() {
		Exercise exercise = Exercise.builder()
				.isCustomExercise(false)
				.name("Chin ups").build();
		
		Exercise managed = exerciseRepository.save(exercise);
		assertThat(managed.getId() > 0);	
	}
	
	@Test
	void exercise_entity_mapping_tests() {
		
		MuscleGroup a = new MuscleGroup("Chest");
		MuscleGroup b = new MuscleGroup("Shoulders");
		mgRepository.saveAndFlush(a);
		mgRepository.saveAndFlush(b);
		
		
		Exercise exercise = Exercise.builder()
				.isCustomExercise(false)
				.name("BenchPress").build();
		
		exercise.addMuscleGroup(a);
		exercise.addMuscleGroup(b);
		
		Exercise managed = exerciseRepository.saveAndFlush(exercise);
		assertNotNull(managed);
		assertTrue(managed.getId() > 0);
		assertEquals(2, managed.getTargetedMuscles().size());
	}

}
