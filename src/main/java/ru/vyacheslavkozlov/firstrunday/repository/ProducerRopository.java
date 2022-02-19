package ru.vyacheslavkozlov.firstrunday.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.vyacheslavkozlov.firstrunday.entity.Producer;

import java.util.List;

public interface ProducerRopository extends JpaRepository<Producer, Integer> {
}
