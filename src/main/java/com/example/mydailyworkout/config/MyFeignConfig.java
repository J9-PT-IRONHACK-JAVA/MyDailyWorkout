package com.example.mydailyworkout.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.boot.autoconfigure.http.HttpMessageConverters;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;

@Configuration
public class MyFeignConfig {

    // Este codigo es el que nos dio Salva, de momento lo dejo comentado.
    //    @Bean
    //    public HttpMessageConverters customConverters() {
    //        HttpMessageConverter<?> additional = new MappingJackson2HttpMessageConverter();
    //        return new HttpMessageConverters(additional);
    //    }

    @Bean
    public HttpMessageConverters customConverters() {
        ObjectMapper objectMapper = new ObjectMapper();
        HttpMessageConverter<?> additional = new MappingJackson2HttpMessageConverter(objectMapper);
        return new HttpMessageConverters(additional);
    }
}
