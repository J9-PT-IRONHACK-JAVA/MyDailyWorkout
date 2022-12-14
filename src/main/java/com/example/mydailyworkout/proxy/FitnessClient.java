package com.example.mydailyworkout.proxy;

import com.example.mydailyworkout.dto.Exercise;
import feign.Headers;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name = "fitness", url = "https://exercises-by-api-ninjas.p.rapidapi.com/v1/exercises/?rapidapi-key=28ee619730mshf9fcf6a8eddebcep16ab2bjsn1a3db9f6b5da")
public interface FitnessClient {
    @GetMapping
    List<Exercise> getData();
}
