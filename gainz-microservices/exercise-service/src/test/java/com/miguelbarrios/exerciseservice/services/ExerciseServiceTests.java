package com.miguelbarrios.exerciseservice.services;

import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;

import com.miguelbarrios.exerciseservice.models.Muscle;
import com.miguelbarrios.exerciseservice.repositories.MuscleRepository;

import org.junit.Before;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class ExerciseServiceTests {
	
	@Mock
	private MuscleRepository muscleRepository;
	
	@InjectMocks
	private ExerciseServiceImpl exerciseService;
	
	@Before
	public void setup() {
		MockitoAnnotations.initMocks(this);
		List<Muscle> muscleGroups = new ArrayList<>();
		muscleGroups.add(new Muscle("Back"));
		muscleGroups.add(new Muscle("Chest"));
		muscleGroups.add(new Muscle("Shoulders"));
		muscleGroups.add(new Muscle("Legs"));
		muscleRepository.saveAll(muscleGroups);
		
		
	}

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
	}

	@BeforeEach
	void setUp() throws Exception {
		muscleRepository = Mockito.mock(MuscleRepository.class);
		exerciseService = new ExerciseServiceImpl(muscleRepository);
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	void should_return_all_muscle_groups() {
		List<Muscle> muscles = exerciseService.getAllMuscles();
		assertNotNull(muscles);
		assertEquals(4,muscles.size());
	}

}
