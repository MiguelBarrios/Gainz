package com.miguelbarrios.exerciseservice.models;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import com.miguelbarrios.exerciseservice.repositories.ExerciseRepository;
import com.miguelbarrios.exerciseservice.repositories.MuscleRepository;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class ExerciseEntityTests {

	@Autowired
	public ExerciseRepository exerciseRepository;
	
	@Autowired
	public MuscleRepository muscleRepository;

	@BeforeEach
	void setUp() throws Exception {
		exerciseRepository.deleteAll();
		Muscle a = new Muscle("Chest");
		Muscle b = new Muscle("Back");
		Muscle c = new Muscle("Shoulders");
		muscleRepository.save(a);
		muscleRepository.save(b);
		muscleRepository.save(c);
		
		List<Muscle> activatedMuscles = new ArrayList<>();
		activatedMuscles.add(a);
		activatedMuscles.add(c);
		
		Exercise exercise = Exercise.builder()
				.id(1)
				.name("Bench Press")
				.activatedMuscles(activatedMuscles)
				.build();
		exerciseRepository.save(exercise);
	}
	
	@Test
	void muscle_entity_test() {
		Optional<Muscle> option = muscleRepository.findById("Chest");
		if(option.isEmpty()){
			fail("entity not found");
		}
		
		String name = option.get().getName();
		assertEquals(name, "Chest");
	}
	
	@Test
	@Transactional
	void exercise_entity_test() {
		Optional<Exercise> option = exerciseRepository.findById(1);
		if(option.isEmpty()) {
			fail("Entity not found");
		}
		
		Exercise exercise = option.get();
		assertEquals("Bench Press", exercise.getName());
		assertEquals(2, exercise.getActivatedMuscles().size());
	}
	
	

}
