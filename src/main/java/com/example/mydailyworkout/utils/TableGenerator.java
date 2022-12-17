package com.example.mydailyworkout.utils;

import com.example.mydailyworkout.models.Exercise;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class TableGenerator {

    public void showTableExercice(List<Exercise> exercisesResponse){

        StringBuilder sb = new StringBuilder();

        sb.append(String.format("%-40s %-20s %-20s %-20s %-20s %-100s", ConsoleColors.BLUE_UNDERLINED + "Name", "Type",
                "Muscle",
                "Equipment",
                "Difficulty", "Instructions")).append("\n");

        for (Exercise exercise : exercisesResponse) {
            sb.append(String.format("%-40s %-20s %-20s %-20s %-20s %-100s",ConsoleColors.BLUE + exercise.getName(),
                    exercise.getType(),
                    exercise.getMuscle(),
                    exercise.getEquipment(), exercise.getDifficulty(), exercise.getInstructions().substring(0, 100))).append("\n");
        }

        System.out.println("");
        System.out.println("");
        System.out.println(sb);
        System.out.println("");
        System.out.println("");
    }
}
