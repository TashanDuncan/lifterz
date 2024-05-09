package com.codingmugen.Lifterz;

import com.codingmugen.Lifterz.lift.Exercise;
import com.codingmugen.Lifterz.lift.Lift;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.time.LocalDate;

@SpringBootApplication
public class LifterzApplication {

    private static final Logger log = LoggerFactory.getLogger(LifterzApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(LifterzApplication.class, args);
    }

    @Bean
    CommandLineRunner runner() {
        return args -> {
            Lift lift = new Lift(1, Exercise.SQUAT, 5, 225, LocalDate.now(), 5);
            log.info("Lift: {}", lift);
        };
    }
}
