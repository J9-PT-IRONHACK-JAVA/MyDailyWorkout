package com.example.mydailyworkout.models;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@Entity
@Table(name = "exercices")
public class Exercise {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String type;
    private String muscle;
    private String equipment;
    private String difficulty;

    @ManyToMany( mappedBy = "exercises" )
    private List<Workout> workouts = new ArrayList<>();

    @Column(length = 100000)
    private String instructions;

    public Exercise(String name, String muscle, String equipment) {
        this.name = name;
        this.muscle = muscle;
        this.equipment = equipment;
    }

    public Exercise(String name, String type, String muscle, String equipment, String difficulty, String instructions) {
        this.name = name;
        this.type = type;
        this.muscle = muscle;
        this.equipment = equipment;
        this.difficulty = difficulty;
        this.instructions = instructions;
    }

}