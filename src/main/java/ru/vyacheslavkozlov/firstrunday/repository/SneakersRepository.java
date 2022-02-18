package ru.vyacheslavkozlov.firstrunday.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.vyacheslavkozlov.firstrunday.entity.Sneakers;

import java.util.List;

public interface SneakersRepository extends JpaRepository<Sneakers, Integer> {
    public List<Sneakers> findAllByAccountId(int accountId);
}
