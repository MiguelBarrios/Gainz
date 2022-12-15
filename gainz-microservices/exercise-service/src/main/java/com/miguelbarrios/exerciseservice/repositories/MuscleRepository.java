package com.miguelbarrios.exerciseservice.repositories;

import com.miguelbarrios.exerciseservice.models.Muscle;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MuscleRepository extends JpaRepository<Muscle, Integer> {

}
