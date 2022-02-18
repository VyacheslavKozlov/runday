package ru.vyacheslavkozlov.firstrunday.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.vyacheslavkozlov.firstrunday.entity.ShoeModel;

public interface ShoeModelRepository extends JpaRepository<ShoeModel, Integer> {
}
