package com.miguelbarrios.exerciseservice.repositories;

import com.miguelbarrios.exerciseservice.models.MuscleGroup;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MuscleGroupRepository extends JpaRepository<MuscleGroup, Integer> {

}
