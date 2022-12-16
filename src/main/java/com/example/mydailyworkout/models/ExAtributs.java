package com.example.mydailyworkout.models;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Embeddable
public class ExAtributs {

    private String name;
    private Enum exerciseType;
    private Enum exerciseMuscle;
    private String muscle;
    private String equipment;
    private String difficulty;

    @Column(length = 100000)
    private String instructions;

}


