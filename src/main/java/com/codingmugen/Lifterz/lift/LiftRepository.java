package com.codingmugen.Lifterz.lift;

import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class LiftRepository {

    private final List<Lift> lifts = new ArrayList<>();

    public List<Lift> findAll() {
        return lifts;
    }

    Optional<Lift> findById(Integer id) {
        return lifts.stream()
                .filter(lift -> lift.id().equals(id))
                .findFirst();
    }

    void create(Lift lift) {
        lifts.add(lift);
    }

    void update(Lift lift, Integer id) {
        Optional<Lift> existingLift = findById(id);
        existingLift.ifPresent(value -> lifts.set(lifts.indexOf(value), lift));
    }

    void delete(Integer id) {
        lifts.removeIf(lift -> lift.id().equals(id));
    }


    @PostConstruct
    private void init() {
        lifts.add(new Lift(1, Exercise.SQUAT,  5, 100, LocalDate.now(), 7));
        lifts.add(new Lift(2, Exercise.BENCH_PRESS, 5, 80, LocalDate.now(), 7));
    }

}
