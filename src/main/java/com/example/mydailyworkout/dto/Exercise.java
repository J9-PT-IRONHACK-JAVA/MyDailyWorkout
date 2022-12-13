package com.example.mydailyworkout.dto;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table( name = "exercices")
public class Exercise {

    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY)
    private Long id;
}
