package com.example.mydailyworkout.proxy;

import com.example.mydailyworkout.dto.Exercise;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name = "fitness", url = "https://exercises-by-api-ninjas.p.rapidapi.com/v1/exercises/")

public interface FitnessClient {
    @GetMapping
    List<Exercise> getAll();
}
