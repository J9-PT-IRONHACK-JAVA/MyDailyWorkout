package com.example.mydailyworkout.repository;

import com.example.mydailyworkout.models.Exercise;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ExerciseRepository extends JpaRepository<Exercise, Long> {
}
