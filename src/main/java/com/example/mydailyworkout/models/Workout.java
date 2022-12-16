package com.example.mydailyworkout.models;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table ( name = "workouts")
public class Workout {

    @Id
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    //@OneToMany(mappedBy = "workout")
    //private List<Exercise> exercises = new ArrayList<>();

    private String sets;
    private String reps;

    /*
    public Workout(User user, List<Exercise> exercises, String sets, String reps) {
        this.user = user;
        this.exercises = exercises;
        this.sets = sets;
        this.reps = reps;
    }*/
}
