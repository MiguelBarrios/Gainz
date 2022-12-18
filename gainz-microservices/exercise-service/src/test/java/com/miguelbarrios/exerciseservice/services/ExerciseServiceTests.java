package com.miguelbarrios.exerciseservice.services;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.List;

import com.miguelbarrios.exerciseservice.models.Exercise;
import com.miguelbarrios.exerciseservice.models.MuscleGroup;
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
class ExerciseServiceTests {
	
	@Autowired
	private MuscleGroupRepository mgRepository;
	
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
	void exercise_entity_mapping_test() {
		
	}
	
	@Test
	void should_create_global_exercise() {
		Exercise exercise = Exercise.builder()
				.name("Bench Press")
				.isCustomExercise(false)
				.build();
		
		MuscleGroup a = new MuscleGroup("Chest");
		MuscleGroup b = new MuscleGroup("Shoulders");
		
		
		Exercise managedExercise = exerciseService.createExercise(exercise);
		
		assertNotNull(exercise);
		assertTrue(managedExercise.getId() > 0);
		assertTrue(managedExercise.getName().equals("Bench Press"));
		
	}

	@Test
	void should_return_all_muscle_groups() {
		mgRepository.save(new MuscleGroup("Back"));
		mgRepository.save(new MuscleGroup("Chest"));
		mgRepository.save(new MuscleGroup("Quads"));
		mgRepository.save(new MuscleGroup("Shoulders"));
		
		List<MuscleGroup> muscles = exerciseService.getAllMuscleGroups();
		assertNotNull(muscles.size() >= 4);
	}

}
