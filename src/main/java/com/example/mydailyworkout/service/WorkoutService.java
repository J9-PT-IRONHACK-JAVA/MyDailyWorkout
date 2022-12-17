package com.example.mydailyworkout.service;

import com.example.mydailyworkout.models.Exercise;
import com.example.mydailyworkout.models.Workout;
import com.example.mydailyworkout.repository.ExerciseRepository;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Service
@Data
@NoArgsConstructor
public class WorkoutService {

    @Autowired
    private ExerciseRepository exerciseRepository;

    public Workout createRandomWorkout(List<Exercise> exercisesList, String userLevel, String strengthType){

        //////////////IMPORTAM///////////////
        List<Exercise> workoutExercises = selectRandomExercises(exercisesList, userLevel);
        var storedWorkoutExercise = exerciseRepository.saveAll(workoutExercises);
        ///////////////////////////////
        String workoutSets = setWorkoutSets( userLevel );
        String workoutReps = setWorkoutReps( strengthType );

        Workout workout = new Workout( storedWorkoutExercise, workoutSets, workoutReps);

        return workout;
    }
    public List<Exercise> selectRandomExercises(List<Exercise> exercisesList, String userLevel) {

        int selectedExercises = 0;
        int arrSize = exercisesList.size();
        List<Exercise> filteredExercisesList = new ArrayList<>();

        if( userLevel.equals("beginner")) selectedExercises = 2;
        else if( userLevel.equals("intermediate")) selectedExercises = 3;
        else if( userLevel.equals("expert")) selectedExercises = 4;

        Random rand = new Random();

        int ind = (selectedExercises > arrSize )?arrSize:selectedExercises;

        for (int i = 0; i < ind; i++) {
            int randomIndex = rand.nextInt(exercisesList.size());
            Exercise randomElement = exercisesList.get(randomIndex);
            filteredExercisesList.add(randomElement);
            exercisesList.remove(randomIndex);
        }

        return filteredExercisesList;
    }

    public String setWorkoutSets(String userLevel){

        String selectedSets = "";

        if( userLevel.equals("beginner")) selectedSets = "2";
        else if( userLevel.equals("intermediate")) selectedSets = "3";
        else if(userLevel.equals("expert")) selectedSets = "4";

        return selectedSets;
    }

    public String setWorkoutReps(String returnStrengthType){

        String selectedReps = "";

        if( returnStrengthType.equals("Resistance")) selectedReps = "15";
        else if( returnStrengthType.equals("Hipertrofy")) selectedReps = "10";
        else if( returnStrengthType.equals("Max strength")) selectedReps = "5";

        return selectedReps;
    }



}
