package ru.vyacheslavkozlov.firstrunday.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.vyacheslavkozlov.firstrunday.entity.Workout;

public interface WorkoutRepository extends JpaRepository<Workout, Integer> {

}
