package com.example.mydailyworkout.service;

import com.example.mydailyworkout.dto.Exercise;
import com.example.mydailyworkout.repository.ExerciseRepository;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class ExerciseService {

    private final ExerciseRepository exerciseRepository;

    public List<Exercise> getAllExercice() {
        return exerciseRepository.findAll();
    }
}
