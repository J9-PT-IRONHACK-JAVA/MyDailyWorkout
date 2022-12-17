package com.example.mydailyworkout.service;

import com.example.mydailyworkout.models.Exercise;
import com.example.mydailyworkout.repository.ExerciseRepository;
import com.example.mydailyworkout.utils.ConsoleColors;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Scanner;

@AllArgsConstructor
@Service
public class ExerciseService {

    private final ExerciseRepository exerciseRepository;

    public List<Exercise> getAllExercice() {
        return exerciseRepository.findAll();
    }

    public void showExercices(){
        List<Exercise> exercises = getAllExercice();

        StringBuilder sb = new StringBuilder();

        sb.append(String.format("%-40s %-20s %-20s %-20s %-20s %-100s", ConsoleColors.BLUE_UNDERLINED + "Name", "Type",
                "Muscle",
                "Equipment",
                "Difficulty", "Instructions")).append("\n");

        for (Exercise exercise : exercises) {
            sb.append(String.format("%-40s %-20s %-20s %-20s %-20s %-100s", ConsoleColors.BLUE + exercise.getName(),
                    exercise.getType(),
                    exercise.getMuscle(),
                    exercise.getEquipment(), exercise.getDifficulty(), exercise.getInstructions().substring(0, 100))).append("\n");
        }

        System.out.println(sb);
    }

    public void saveToDataBase(Scanner sc, List<Exercise> exResponse) {

        String saveResponse = "";

        System.out.println("");
        System.out.println("");
        System.out.println(ConsoleColors.BLUE_BOLD_BRIGHT + """
                Want to save these exercise on your profile?
                1.Yes
                2.No
                """ + ConsoleColors.RESET);

        saveResponse = sc.nextLine();

        if (saveResponse.equals("1")) {

            for (Exercise exercise : exResponse) {
                var newExercise = new Exercise(exercise.getName(), exercise.getType(), exercise.getMuscle(),
                        exercise.getEquipment(), exercise.getDifficulty(), exercise.getInstructions());

                exerciseRepository.save(newExercise);
            }

            System.out.println("");
            System.out.println("");
            System.out.println(ConsoleColors.GREEN_BOLD_BRIGHT + "Workout and exercises saved successfully on your " +
                    "profile" + ConsoleColors.RESET);
            System.out.println("");
            System.out.println("");
            System.out.println("");
            System.out.println("");
        }
    }

    public void saveOneToDataBase(Scanner sc, Exercise exercise) {

        String saveResponse = "";

        System.out.println("");
        System.out.println("");
        System.out.println(ConsoleColors.BLUE_BOLD_BRIGHT + """
                Want to save these exercise on your profile?
                1.Yes
                2.No
                """ + ConsoleColors.RESET);

        saveResponse = sc.nextLine();

        if (saveResponse.equals("1")) {


                var newExercise = new Exercise(exercise.getName(), exercise.getType(), exercise.getMuscle(),
                        exercise.getEquipment(), exercise.getDifficulty(), exercise.getInstructions());

                exerciseRepository.save(newExercise);


            System.out.println("");
            System.out.println("");
            System.out.println(ConsoleColors.GREEN_BOLD_BRIGHT + "Workout and exercises saved successfully on your " +
                    "profile" + ConsoleColors.RESET);
            System.out.println("");
            System.out.println("");
            System.out.println("");
            System.out.println("");
        }

    }
}
