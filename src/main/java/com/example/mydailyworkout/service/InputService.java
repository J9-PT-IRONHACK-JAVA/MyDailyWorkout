package com.example.mydailyworkout.service;

import com.example.mydailyworkout.models.Exercise;
import com.example.mydailyworkout.proxy.FitnessClient;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.hibernate.boot.archive.scan.spi.ScanEnvironment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Scanner;

@Data
@NoArgsConstructor

@Service
@EnableFeignClients
public class InputService {

    private WorkoutService workoutService;

    @Autowired
    private FitnessClient fitnessClient;

    public void main(Scanner sc, String input){

        switch ( input ){
            case "1":
                askForCustomEx(sc);
                break;
        }
    }

    public void askForCustomEx( Scanner sc){

        String difficulty = null;
        String workoutType = null;
        String muscle = null;

        var selectedDifficulty =  switchToDifficulty(sc, difficulty);
        var selectedWorkoutType = switchTodType(sc, workoutType);
        var selectedMuscle = switchToMuscleType( sc, muscle);

       List<Exercise> exercisesResponse = fitnessClient.getExercicesByParams(selectedWorkoutType, selectedMuscle);
        System.out.println(exercisesResponse.size());
    }

    public String  switchToDifficulty(Scanner sc, String difficulty){

        String difficultyResponse = "";

        System.out.println("""
                Select your Experience:
                1.Beginer
                2.Intermediate
                3.Expert
                """);

        difficultyResponse =  sc.nextLine();

        switch ( difficultyResponse ){

            case "1" :
                difficulty = "beginner";
                break;
            case "2" :
                difficulty = "intermediate";
                break;
            case "3" :
                difficulty = "expert";
                break;
            default:
                System.out.println("Command no recognized");
        }

        return difficulty;
    }

    public String switchToMuscleType(Scanner sc, String muscle){

        String muscleResponse = "";

        System.out.println("""
                Select a muscle to train:
                1.abdominals
                2.abductors
                3.adductors
                4.biceps
                5.calves
                6.chest
                7.forearms
                8.glutes
                9.hamstrings
                10.lats
                11.lowerback 
                12.neck
                13.quadriceps
                14.traps
                15.triceps
                16.middleback
                """);

        muscleResponse =  sc.nextLine();

        switch ( muscleResponse ){

            case "1" :
                muscle = "abdominals";
                break;
            case "2":
                muscle = "abductors";
                break;
            case "3" :
                muscle = "adductors";
                break;
            case "4" :
                muscle = "biceps";
                break;
            case "5" :
                muscle = "calves";
                break;
            case "6" :
                muscle = "chest";
                break;
            case "7" :
                muscle = "forearms";
                break;
            case "8" :
                muscle = "glutes";
                break;
            case "9" :
                muscle = "hamstrings";
                break;
            case "10" :
                muscle = "lats";
                break;
            case "11" :
                muscle = "lowerback";
                break;
            case "12" :
                muscle = "neck";
                break;
            case "13" :
                muscle = "quadriceps";
                break;
            case "14" :
                muscle = "traps";
                break;
            case "15" :
                muscle = "triceps";
                break;
            case "16" :
                muscle = "middleback";
                break;
            default:
                System.out.println("Command no recognized");
        }

        return muscle;
    }

    public String  switchTodType(Scanner sc, String workoutType){

        String typeResponse = "";

        System.out.println("""
                Select workout type:
                1.cardio
                2.olympic_weightlifting
                3.plyometrics
                4.powerlifting
                5.strength
                6.stretching
                7.strongman
                """);

        typeResponse =  sc.nextLine();

        switch ( typeResponse ){

            case "1" :
                workoutType = "cardio";
                break;
            case "2" :
                workoutType = "olympic_weightlifting";
                break;
            case "3" :
                workoutType = "plyometrics";
                break;
            case "4" :
                workoutType = "powerlifting";
                break;
            case "5" :
                workoutType = "strength";
                break;
            case "6" :
                workoutType = "stretching";
                break;
            case "7" :
                workoutType = "strongman";
                break;
            default:
                System.out.println("Command no recognized");
        }

        return workoutType;
    }


}
