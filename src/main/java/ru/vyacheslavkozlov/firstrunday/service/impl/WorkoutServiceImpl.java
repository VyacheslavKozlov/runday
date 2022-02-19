package ru.vyacheslavkozlov.firstrunday.service.impl;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ru.vyacheslavkozlov.firstrunday.entity.Workout;
import ru.vyacheslavkozlov.firstrunday.repository.WorkoutRepository;

import java.util.List;

@AllArgsConstructor
@Service
public class WorkoutServiceImpl {
    private final WorkoutRepository workoutRepository;

    public List<Workout> findAll() {
        return workoutRepository.findAll();
    }

    public List<Workout> findAllBySneakersId(int sneakersId){
        return workoutRepository.findAllBySneakersId(sneakersId);
    }
}
