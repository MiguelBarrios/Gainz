package com.miguelbarrios.exerciseservice.services;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import com.miguelbarrios.exerciseservice.models.Muscle;
import com.miguelbarrios.exerciseservice.repositories.MuscleRepository;

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
	private MuscleRepository muscleRepository;
	
	
	@Autowired
	private ExerciseServiceImpl exerciseService;
	

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
	void should_return_all_muscle_groups() {
		muscleRepository.save(new Muscle("Back"));
		muscleRepository.save(new Muscle("Chest"));
		muscleRepository.save(new Muscle("Quads"));
		muscleRepository.save(new Muscle("Shoulders"));
		
		List<Muscle> muscles = exerciseService.getAllMuscleGroups();
		assertNotNull(muscles.size() >= 4);
	}

}
