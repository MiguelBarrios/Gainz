package com.miguelbarrios.gainz.workoutservice.services;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import com.miguelbarrios.gainz.workoutservice.models.Workout;
import com.miguelbarrios.gainz.workoutservice.repositories.WorkoutRepository;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith( SpringRunner.class )
@SpringBootTest
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
    void getWorkout() {
        assertTrue(false);
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