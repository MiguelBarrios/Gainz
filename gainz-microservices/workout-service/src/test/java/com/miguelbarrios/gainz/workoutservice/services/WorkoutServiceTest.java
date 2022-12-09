package com.miguelbarrios.gainz.workoutservice.services;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.LocalDateTime;

import com.miguelbarrios.gainz.workoutservice.models.Workout;
import com.miguelbarrios.gainz.workoutservice.repositories.WorkoutRepository;

import org.junit.Assert;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.junit4.SpringRunner;

import exceptions.UnauthorizedException;
import exceptions.WorkoutNotFoundException;

@RunWith( SpringRunner.class )
@SpringBootTest
@ExtendWith(SpringExtension.class)
class WorkoutServiceTest {

    @Autowired
    private WorkoutRepository workoutRepository;

    @Autowired
    private WorkoutService workoutService;

    private Workout workout;

    private static Integer userId = 1;
    

    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
    }


    @Test
    void should_create_empty_workout() {
        Workout workout = Workout.builder()
                .build();

        Workout result = workoutService.createWorkout(1, workout);
        assertNotNull(result);
        assertNotNull(result.getStartTime());
        assertNull(result.getEndTime());
        assertTrue(result.getId() > 0);
    }

    @Test
    void should_get_workout_if_owned_by_user() {	
    	
    	Workout workout = Workout.builder()
    			.id(1)
    			.startTime(LocalDateTime.now())
    			.userId(userId)
    			.build();
    	workout = workoutRepository.save(workout);
    	
    	Workout actual = workoutService.getWorkout(userId, workout.getId());
    	assertNotNull(actual);
    	assertEquals(userId, actual.getUserId());
    }
    
    @Test
    void should_throw_unauthorized_exception_if_workout_does_not_belong_to_user() {
    	Workout workout = Workout.builder()
    			.id(1)
    			.startTime(LocalDateTime.now())
    			.userId(userId)
    			.build();
    	workout = workoutRepository.save(workout);
    	
    	try {
        	Workout actual = workoutService.getWorkout(userId + 1, workout.getId());
        	assertNull(actual);
    	} catch (UnauthorizedException e) {
    		return;
    	}
    	 	  
    	Assert.fail("User should not be able to access workout");
    }
    
    @Test
    void should_throw_not_found_exception_for_invalid_workout_id() {
    	try {
    		Workout workout = workoutService.getWorkout(userId, 12);
    		assertNull(workout);
    	}
    	catch(WorkoutNotFoundException e) {
    		return;
    	}
    	
    	Assert.fail("Should not return workout");
    }

    @Test
    void updateWorkout() {
        assertTrue(false);

    }

    @Test
    void deleteWorkout() {
        assertTrue(false);
    }

    @Test
    void getUserWorkouts() {
        assertTrue(false);

    }
}