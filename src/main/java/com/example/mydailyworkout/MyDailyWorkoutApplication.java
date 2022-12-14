package com.example.mydailyworkout;

import com.example.mydailyworkout.dto.Exercise;
import com.example.mydailyworkout.proxy.FitnessClient;
import com.example.mydailyworkout.repository.ExerciseRepository;
import com.example.mydailyworkout.service.ExerciseService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.http.ResponseEntity;

import java.util.List;

@SpringBootApplication
@EnableFeignClients
@RequiredArgsConstructor
public class MyDailyWorkoutApplication implements CommandLineRunner {

    private final ExerciseRepository exerciseRepository;
    private final FitnessClient fitnessClient;

    public static void main(String[] args) {
        SpringApplication.run(MyDailyWorkoutApplication.class, args);
    }

    @Override
    public void run(String... args) {
        List<Exercise> response = fitnessClient.getData();

        System.out.println(response.get(1).getName());

        for (Exercise exercise: response) {
            var newExercise = new Exercise(exercise.getName(), exercise.getType(), exercise.getMuscle(),
                    exercise.getEquipment(), exercise.getDifficulty(), exercise.getInstructions());

            exerciseRepository.save(newExercise);
        }
    }

}
