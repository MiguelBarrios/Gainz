package com.miguelbarrios.exerciseservice.services;

import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.HashSet;
import java.util.Set;

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
	
	

}
