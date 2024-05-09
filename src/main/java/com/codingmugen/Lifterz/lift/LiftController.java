package com.codingmugen.Lifterz.lift;

import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/lifts")
public class LiftController {
    private final LiftRepository liftRepository;

    public LiftController(LiftRepository liftRepository) {
        this.liftRepository = liftRepository;
    }

    @GetMapping("")
    List<Lift> findAll() {
        return liftRepository.findAll();
    }

    @GetMapping("/{id}")
    Lift findById(@PathVariable Integer id) {
        Optional<Lift> lift = liftRepository.findById(id);

        if (lift.isEmpty()) {
            throw new LiftNotFoundException();
        }
        return lift.get();
    }

    // post
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("")
    void create(@Valid @RequestBody Lift lift) {
        liftRepository.create(lift);
    }

    // put
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @PutMapping("/{id}")
    void update(@Valid @RequestBody Lift lift, @PathVariable Integer id) {
        liftRepository.update(lift, id);
    }


    // delete
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{id}")
    void delete(@PathVariable Integer id) {
        liftRepository.delete(id);
    }


}
