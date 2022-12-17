package com.example.mydailyworkout.dto;

import com.example.mydailyworkout.models.Exercise;
import com.example.mydailyworkout.models.Workout;
import com.example.mydailyworkout.repository.WorkoutRepository;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class WorkoutExerciseDto {

    private String name;
    private String muscle;
    private String equipment;
    private String sets;
    private String reps;

    public WorkoutExerciseDto toDto(Workout workout, Exercise exercise){

        return new WorkoutExerciseDto(exercise.getName(), exercise.getMuscle(), exercise.getEquipment(), workout.getSets(), workout.getReps());
    }
}
