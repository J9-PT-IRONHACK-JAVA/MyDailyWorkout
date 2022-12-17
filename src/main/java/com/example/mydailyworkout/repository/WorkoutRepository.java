package com.example.mydailyworkout.repository;

import com.example.mydailyworkout.dto.WorkoutExerciseDto;
import com.example.mydailyworkout.models.Exercise;
import com.example.mydailyworkout.models.Workout;
import jakarta.persistence.Tuple;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface WorkoutRepository extends JpaRepository<Workout, Long> {

    @Query(value = "SELECT e.name, e.muscle, e.equipment, w.sets, w.reps\n" +
            "FROM workouts as w\n" +
            "         INNER JOIN exercices as e\n" +
            "         INNER JOIN workout_exercises as we\n" +
            "                    ON we.exercise_id = we.workout_id;", nativeQuery = true)

    public List<Tuple> showCustomWorkout();
}
