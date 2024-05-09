package com.codingmugen.Lifterz.lift;

import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;

public record Lift(
        Integer id,
        @NotNull
        Exercise exercise,
        @NotNull
        Integer reps,
        @NotNull
        Integer weight,
        @NotNull
        LocalDate date,
        @NotNull
        Integer RPE) {
}
