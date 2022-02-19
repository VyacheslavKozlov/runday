package ru.vyacheslavkozlov.firstrunday.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.vyacheslavkozlov.firstrunday.entity.Workout;

import java.util.List;

public interface WorkoutRepository extends JpaRepository<Workout, Integer> {
    public List<Workout> findAllBySneakersId(int sneakersId);
}
