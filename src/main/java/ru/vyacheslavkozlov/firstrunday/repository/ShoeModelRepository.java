package ru.vyacheslavkozlov.firstrunday.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.vyacheslavkozlov.firstrunday.entity.ShoeModel;

public interface ShoeModelRepository extends JpaRepository<ShoeModel, Integer> {
}
