package ru.vyacheslavkozlov.firstrunday.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.vyacheslavkozlov.firstrunday.entity.Producer;

import java.util.List;

public interface ProducerRopository extends JpaRepository<Producer, Integer> {
}
