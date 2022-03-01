package ru.vyacheslavkozlov.firstrunday.service;

import ru.vyacheslavkozlov.firstrunday.entity.Workout;

import java.util.List;

public interface WorkoutService {
    public List<Workout> findAll();

    public List<Workout> findAllBySneakersId(int sneakersId);
}
