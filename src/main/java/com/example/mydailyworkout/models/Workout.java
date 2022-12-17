package com.example.mydailyworkout.models;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table ( name = "workouts")
public class Workout {

    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY)
    private Long id;


    /*
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;*/

    @ManyToMany
    @JoinTable(
            name = "workout_exercises",
            joinColumns = @JoinColumn(name = "workout_id"),
            inverseJoinColumns = @JoinColumn(name = "exercise_id"))
    private List<Exercise> exercises = new ArrayList<>();

    private String sets;
    private String reps;


    public Workout(List<Exercise> exercises, String sets, String reps) {
        this.exercises = exercises;
        this.sets = sets;
        this.reps = reps;
    }
}
