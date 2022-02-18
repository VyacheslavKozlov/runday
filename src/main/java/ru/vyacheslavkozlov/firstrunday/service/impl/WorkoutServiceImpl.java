package ru.vyacheslavkozlov.firstrunday.service.impl;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ru.vyacheslavkozlov.firstrunday.repository.WorkoutRepository;

@AllArgsConstructor
@Service
public class WorkoutServiceImpl {
    private final WorkoutRepository workoutRepository;
}
